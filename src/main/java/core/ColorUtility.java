/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author josmario
 */
public class ColorUtility {

    private static ColorUtility instance;

    private Integer[][] SAMPLE;
    private Integer WIDTH;
    private Integer HEIGHT;

    private final int SAMPLE_SIZE = 3000;
    private final int GRADIENT_SIZE = 100;

    private Color[] FEMALE_GRADIENT;
    private Color[] MALE_GRADIENT;

    private ColorUtility() {
        this.initGradients();

    }

    public static ColorUtility getInstance() {
        if (instance == null) {
            instance = new ColorUtility();
        }
        return instance;
    }

    private void initGradients() {
        this.MALE_GRADIENT = loadGradient("blue-green-gradient.png");
        this.FEMALE_GRADIENT = loadGradient("red-purple-gradient.png");
    }

    private Color[] loadGradient(String file) {
        Color[] gradient = new Color[GRADIENT_SIZE];

        try {
            BufferedImage bufferedImage = ImageIO.read(Util.getInstance().getFileFromResourceAsStream(file));

            int w = bufferedImage.getWidth();
            int h = (int) bufferedImage.getHeight() / 2;
            int increment = (int) w / GRADIENT_SIZE;

            for (int i = 0, j = 0; j < GRADIENT_SIZE; i += increment, j++) {
                Color sample = new Color(bufferedImage.getRGB(i, h));
                gradient[j] = sample;
            }
        } catch (IOException ex) {

        }

        return gradient;
    }

    private void initSample(int w, int h) {
        WIDTH = w;
        HEIGHT = h;
        SAMPLE = new Integer[w][h];

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                SAMPLE[i][j] = 0;
            }
        }
    }

    public void saveImage(String sourceUrl, String filepath) {
        try {

            List<String> cmd = new ArrayList<>();

            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("windows")) {
                cmd.add("cmd");
                cmd.add("/c");
                cmd.add("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
            } else {
                cmd.add("firefox");
            }

            cmd.add("--headless");
            cmd.add("--screenshot");
            cmd.add(filepath);
            cmd.add(sourceUrl);

            Logger.getGlobal().log(Level.INFO, "Trying to take a screenshot: {0}", String.join(" ", cmd));

            Process p = new ProcessBuilder().command(cmd).start();
            p.waitFor(10, TimeUnit.SECONDS);
            if (p.isAlive()) {
                p.destroyForcibly();
            }

        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ColorUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveSample(String source, String outImage, String outCsv) {
        try {
            System.out.println("SOURCE: " + source);
            List<Color> colors = new ArrayList<>();
            BufferedImage bufferedImage = ImageIO.read(new File(source));

            int w = bufferedImage.getWidth();
            int h = bufferedImage.getHeight();

            this.initSample(w, h);

            for (int i = 0; i < SAMPLE_SIZE; i++) {

                boolean flag = true;
                while (flag) {
                    Integer randW = (int) (Math.random() * w);
                    Integer randH = (int) (Math.random() * h);

                    Color c = new Color(bufferedImage.getRGB(randW, randH));
                    int temp = c.getRed() + c.getGreen() + c.getBlue();
                    if (temp > 30 && temp < 735) {
                        this.SAMPLE[randW][randH] = 1;
                        colors.add(c);
                        flag = false;
                    }
                }
//                this.SAMPLE[randW][randH] = 1;
            }

            Graphics graphics = bufferedImage.getGraphics();

            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (SAMPLE[i][j] == 1) {
                        graphics.setColor(Color.red);
                        graphics.fillOval(i, j, 5, 5);
                    }
                }
            }

            ImageIO.write(bufferedImage, "PNG", new File(outImage));

            try (
                    FileWriter fw = new FileWriter(outCsv);
                    BufferedWriter bw = new BufferedWriter(fw)) {

                String line = "\"color\"\n";
                bw.append(line);
                for (Color color : colors) {
                    line = "\"(" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + ")\"\n";
                    bw.append(line);
                }
                bw.flush();
                fw.flush();
            }

        } catch (IOException ex) {
            Logger.getLogger(ColorUtility.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
    }

    /**
     * Get a sample of colors from a given image
     *
     * @param ImageName Image path
     * @return Array of colors (sample from the input image)
     * @throws IOException
     */
    public List<Color> getSample(String ImageName) throws IOException {
        // open image
        File imgPath = new File(ImageName);
        BufferedImage bufferedImage = ImageIO.read(imgPath);

        List<Color> output = new ArrayList<>();

        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();

        for (int i = 0; i < SAMPLE_SIZE; i++) {
            Color c = Color.BLACK;
            while (c == Color.BLACK || c == Color.WHITE) {
                Integer randW = (int) (Math.random() * w);
                Integer randH = (int) (Math.random() * h);
                c = new Color(bufferedImage.getRGB(randW, randH));
                this.SAMPLE[randW][randH] = 1;
                System.out.println("(" + randW + "," + randH + ")");
            }
            output.add(c);
        }

        this.printSample(bufferedImage, SAMPLE);
        return output;
    }

    private double numSim(int a, int b, double max) {
        return (Math.abs(Math.abs(a - b) - max)) / max;
    }

    /**
     * Gets the similarity between two given colors
     *
     * @param a Color A
     * @param b Color B
     * @return Score ranging from 0.0 to 1.0
     */
    private double colorSimilarity(Color a, Color b) {

        int redA = a.getRed();
        int greenA = a.getGreen();
        int blueA = a.getBlue();

        int redB = b.getRed();
        int greenB = b.getGreen();
        int blueB = b.getBlue();

        //converts RGB colors into Y'UV
        double wR = 0.299;
        double wB = 0.114;
        double wG = 1.0 - wR - wB;
        double uMax = 0.436;
        double vMax = 0.615;

        double yA = wR * redA + wG * greenA + wB * blueA;
        double uA = uMax * ((greenA - yA) / (1.0 - wB));
        double vA = vMax * ((redA - yA) / (1.0 - wR));

        double yB = wR * redB + wG * greenB + wB * blueB;
        double uB = uMax * ((greenB - yA) / (1.0 - wB));
        double vB = vMax * ((redB - yA) / (1.0 - wR));

        double vectorA[] = {yA, uA, vA};
        double vectorB[] = {yB, uB, vB};

        double sim = cosineSimilarity(vectorA, vectorB);

        //normalization
        double z = (sim + 1.0) / 2.0;
        return sim;
    }

    /**
     * Similarity between two vectors
     *
     * @param vectorA
     * @param vectorB
     * @return Similarity ranging from -1.0 to 1.0
     */
    public double cosineSimilarity(double[] vectorA, double[] vectorB) {
//        double dotProduct = 0.0;
//        double normA = 0.0;
//        double normB = 0.0;
//        for (int i = 0; i < vectorA.length; i++) {
//            dotProduct += vectorA[i] * vectorB[i];
//            normA += Math.pow(vectorA[i], 2);
//            normB += Math.pow(vectorB[i], 2);
//        }
//        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));

        //euclidian distance 
        double sim = 0.0;
        sim = Math.sqrt(Math.pow(vectorA[0] - vectorB[0], 2) + Math.pow(vectorA[1] - vectorB[1], 2) + Math.pow(vectorA[2] - vectorB[2], 2));

        return sim;
    }

    private Map<Color, Double> computeModel(Color[] gradient, List<Color> sample) {

        Map<Color, Double> model = new HashMap<>();

        for (Color c : sample) {
            Double minSim = Double.MAX_VALUE;
            for (Color baseColor : gradient) {
                Double sim = colorSimilarity(c, baseColor);
                minSim = sim < minSim ? sim : minSim;
            }
            //Normalized maxSim. Notice that 0<SUM(maxSim_i)<SAMPLE_SIZE
            model.put(c, minSim / new Double(sample.size()));
        }

        return model;
    }

    private List<Color> readSample(String file) {
        List<Color> colors = new ArrayList<>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File(file)));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ColorUtility.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
        String line;
        try {
            br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(ColorUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while ((line = br.readLine()) != null) {
                try {

                    line = line.replace("(", "").replace(")", "").replaceAll("\"", "");
                    int red = Integer.valueOf(line.split(",")[0]);
                    int green = Integer.valueOf(line.split(",")[1]);
                    int blue = Integer.valueOf(line.split(",")[2]);

                    if (red > 255 || green > 255 || blue > 255) {
                        System.out.println("ALERT: " + line);
                    }
                    colors.add(new Color(red, green, blue));

                } catch (NumberFormatException ex) {
                    Logger.getLogger(ColorUtility.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ColorUtility.class.getName()).log(Level.SEVERE, null, ex);
        }

        return colors;
    }

    /**
     * Stereotype estimation based on colors
     *
     * @param file Samples
     * @return Score for each stereotype [st-female, st-male]
     */
    public Double[] getBias(String file) {

        List<Color> sample = this.readSample(file);
        Map<Color, Double> fModel = this.computeModel(FEMALE_GRADIENT, sample);
        Map<Color, Double> mModel = this.computeModel(MALE_GRADIENT, sample);

        Double fSum = 0.0, mSum = 0.0;

        fSum = fModel.values().stream().map((value) -> value).reduce(fSum, (accumulator, _item) -> accumulator + _item);
        mSum = mModel.values().stream().map((value) -> value).reduce(mSum, (accumulator, _item) -> accumulator + _item);

        Double meanF, meanM;
        meanF = fSum / new Double(fModel.size());
        meanM = mSum / new Double(mModel.size());

        Double[] scores = {meanF, meanM};
        return scores;

    }

    public Double[] getAverageColor(String file) {
        List<Color> sample = this.readSample(file);

        double r = 0, g = 0, b = 0, meanR, meanG, meanB;

        for (Color c : sample) {
            r += c.getRed();
            g += c.getGreen();
            b += c.getBlue();
        }

        meanR = r / sample.size();
        meanG = g / sample.size();
        meanB = b / sample.size();

        Double[] scores = {meanR / 255.0, meanG / 255.0, meanB / 255.0};
        return scores;
    }

    public void printSample(BufferedImage bufferedImage, Integer[][] dots) {

        Graphics graphics = bufferedImage.getGraphics();

        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                if (SAMPLE[i][j] == 1) {
                    graphics.setColor(Color.red);
                    graphics.fillOval(i, j, 2, 2);
                }
            }
        }
        graphics.dispose();
    }
}
