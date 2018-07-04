/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.josmario.stdetection.color;

import com.clearspring.analytics.util.Varint;
import it.grabz.grabzit.GrabzItClient;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

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
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
    private final Color[] ST_COLORS = {
        //female
        new Color(250, 70, 130),
        new Color(230, 75, 150),
        new Color(212, 80, 155),
        new Color(190, 90, 170),
        new Color(180, 90, 180),
        //male
        new Color(100, 120, 235),
        new Color(80, 120, 245),
        new Color(70, 125, 250),
        new Color(50, 90, 255),
        new Color(0, 90, 255)
    };

    private ColorUtility() {

    }

    public static ColorUtility getInstance() {
        if (instance == null) {
            instance = new ColorUtility();
        }
        return instance;
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

            Process p = Runtime.getRuntime().exec("firefox -headless -screenshot " + filepath + " " + sourceUrl);
            p.waitFor(30, TimeUnit.SECONDS);

            if (p.isAlive()) {
                p.destroyForcibly();
            }

            System.out.println("Waiting for screenshot to proceed...");

        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ColorUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveSample(String source, String outImage, String outCsv) {
        try {

            List<Color> colors = new ArrayList<>();
            BufferedImage bufferedImage = ImageIO.read(new File(source));

            int w = bufferedImage.getWidth();
            int h = bufferedImage.getHeight();

            this.initSample(w, h);

            for (int i = 0; i < SAMPLE_SIZE; i++) {

                Integer randW = (int) (Math.random() * w);
                Integer randH = (int) (Math.random() * h);

                Color c = new Color(bufferedImage.getRGB(randW, randH));
                int temp = c.getRed() + c.getGreen() + c.getBlue();
                if (temp == 0 || temp == 765) {
                    this.SAMPLE[randW][randH] = 0;

                } else {
                    this.SAMPLE[randW][randH] = 1;
                    colors.add(c);
                }
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

            //saves colors to csv
            FileWriter fw = new FileWriter(outCsv);
            BufferedWriter bw = new BufferedWriter(fw);

            String line = "\"color\"\n";
            bw.append(line);
            for (Color color : colors) {
                line = "\"(" + color.getRed() + "," + color.getGreen() + "," + color.getBlue() + ")\"\n";
                bw.append(line);
            }
            bw.flush();
            fw.flush();
            bw.close();
            fw.close();

        } catch (IOException ex) {
            Logger.getLogger(ColorUtility.class.getName()).log(Level.SEVERE, null, ex);
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
        double sim = 0.0;

        int redA = a.getRed();
        int greenA = a.getGreen();
        int blueA = a.getBlue();

        int redB = b.getRed();
        int greenB = b.getGreen();
        int blueB = b.getBlue();
//
//        sim = (numSim(redA, redB, 255) + numSim(greenA, greenB, 255) + numSim(blueA, blueB, 255)) / 3.0;

        //converts RGB colors into Y'UV
        double wR = 0.299;
        double wB = 0.114;
        double wG = 1 - wR - wB;
        double uMax = 0.436;
        double vMax = 0.615;

        double yA = wR * redA + wG * greenA + wB * blueA;
        double uA = uMax * ((greenA - yA) / (1 - wB));
        double vA = vMax * ((redA - yA) / (1 - wR));

        double yB = wR * redB + wG * greenB + wB * blueB;
        double uB = uMax * ((greenB - yA) / (1 - wB));
        double vB = vMax * ((redB - yA) / (1 - wR));

        double vectorA[] = {yA, uA, vA};
        double vectorB[] = {yB, uB, vB};

        return cosineSimilarity(vectorA, vectorB);
    }

    /**
     * Similarity between two vectors
     *
     * @param vectorA
     * @param vectorB
     * @return Similarity ranging from 0.0 to 1.0
     */
    public double cosineSimilarity(double[] vectorA, double[] vectorB) {
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;
        for (int i = 0; i < vectorA.length; i++) {
            dotProduct += vectorA[i] * vectorB[i];
            normA += Math.pow(vectorA[i], 2);
            normB += Math.pow(vectorB[i], 2);
        }
        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }

    private Map<Color, Double> computeModel(Color[] baseModel, List<Color> sample) {

        Map<Color, Double> model = new HashMap<>();

        for (Color color : baseModel) {
            model.put(color, 0.0);
        }

        for (Color c : sample) {
            Color tempColor = null;
            Double maxSim = 0.0;
            for (Color baseColor : baseModel) {
                Double sim = colorSimilarity(c, baseColor);
                if (sim > maxSim) {
                    maxSim = sim;
                    tempColor = baseColor;
                }
            }
            Double increment = maxSim > 0.6 ? 1.0 : 0.0;
            model.put(tempColor, model.get(tempColor) + increment);
        }

        double max = 0.0;
        for (Color c : baseModel) {

        }
        //normalization
        for (Color c : baseModel) {
            Double temp = model.get(c);
            Double norm = temp / SAMPLE_SIZE;

            model.remove(c);
            model.put(c, norm);
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
            line = br.readLine();
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
     * @param url URL to a Web Page
     * @return Score for each stereotype [st-female, st-male]
     */
    public Double[] getBias(String file) {

//            String filename = UUID.randomUUID().toString();
//            String file = "/home/josmario/temp/page-imgs/" + filename + ".jpg";
////            this.saveImage(url, file);
//            this.saveImage(url, file);
        List<Color> sample = this.readSample(file);
        Map<Color, Double> stModel = this.computeModel(ST_COLORS, sample);

        List<Double> m = new ArrayList<>();

        stModel.values().stream().forEach((value) -> {
            m.add(value);
        });

        Double mScore = 0.0;
        Double fScore = 0.0;

        for (int i = 0; i < (m.size() / 2); i++) {
            fScore += m.get(i);
        }

        for (int i = (m.size() / 2); i < m.size(); i++) {
            mScore += m.get(i);
        }

        Double[] scores = {fScore, mScore};
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

//        BufferedImage resized = new BufferedImage(800, 600, bufferedImage.getType());
//        Graphics2D g = resized.createGraphics();
//        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
//                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//        g.drawImage(bufferedImage, 0, 0, 800, 600, 0, 0, bufferedImage.getWidth(),
//                bufferedImage.getHeight(), null);
//        g.dispose();
//
//        JFrame frame = new JFrame();
//        frame.getContentPane().setLayout(new FlowLayout());
//        frame.getContentPane().add(new JLabel(new ImageIcon(resized)));
//        frame.pack();
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
