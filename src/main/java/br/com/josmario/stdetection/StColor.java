/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.josmario.stdetection;

import it.grabz.grabzit.GrabzItClient;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
public class StColor {

    private Integer[][] SAMPLE;

    private final int SAMPLE_SIZE = 500;
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

    public StColor() {
        SAMPLE = new Integer[800][600];

        for (int i = 0; i < 800; i++) {
            for (int j = 0; j < 600; j++) {
                SAMPLE[i][j] = 0;
            }
        }

    }

    private void saveImage(String sourceUrl, String filepath) {
        try {
            GrabzItClient grabzIt = new GrabzItClient("MThmZDcxMWIzYmRkNDU1MGI0YzQ4YjM1ODRjNWEwMWE=", "GFc/P2Y/P3k/aT8/P3E/P1tMQj8/PD8/D3c/NVpjPxI=");
            grabzIt.URLToImage(sourceUrl);
            grabzIt.SaveTo(filepath);
        } catch (Exception ex) {
            Logger.getLogger(StColor.class.getName()).log(Level.SEVERE, null, ex);
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

        sim = (numSim(redA, redB, 255) + numSim(greenA, greenB, 255) + numSim(blueA, blueB, 255)) / 3.0;

        return sim;
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

        //normalization
        for (Color c : baseModel) {
            Double temp = model.get(c);
            Double norm = temp / SAMPLE_SIZE;

            model.remove(c);
            model.put(c, norm);
        }
        return model;
    }

    /**
     * Stereotype estimation based on colors
     *
     * @param url URL to a Web Page
     * @return Score for each stereotype [st-female, st-male]
     */
    public Double[] getColorSt(String url) {
        try {
            String filename = UUID.randomUUID().toString();
            String file = "/home/josmario/temp/page-imgs/" + filename + ".jpg";
            this.saveImage(url, file);

            List<Color> sample = this.getSample(file);
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

        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void printSample(BufferedImage bufferedImage, Integer[][] dots) {

        Graphics graphics = bufferedImage.getGraphics();

        for (int i = 0; i < 800; i++) {
            for (int j = 0; j < 600; j++) {
                if (SAMPLE[i][j] == 1) {
                    graphics.setColor(Color.red);
                    graphics.fillOval(i, j, 3, 3);
                }
            }
        }

        graphics.dispose();

        BufferedImage resized = new BufferedImage(800, 600, bufferedImage.getType());
        Graphics2D g = resized.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(bufferedImage, 0, 0, 800, 600, 0, 0, bufferedImage.getWidth(),
                bufferedImage.getHeight(), null);
        g.dispose();

        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(new JLabel(new ImageIcon(resized)));
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
