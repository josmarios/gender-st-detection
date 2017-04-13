/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stereotypedetection;

import it.grabz.grabzit.GrabzItClient;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author josmario
 */
public class Core {

    private final int SAMPLE_SIZE = 50;
    
    //[red, green, blue, purple, black]
    private final double[] MALE_COLOR_WEIGHTS = {3.2};

    public static void main(String[] args) {
        Core c = new Core();
        String url = "http://www.ufal.edu.br";
        String file = "/home/nees/temp/ufal.png";
        c.saveImage(url, file);

        System.out.println("Image saved!");
    }

    private String getPage(String url) {
        Document page = null;
        try {
            page = Jsoup.connect(url).get();
        } catch (IOException ex) {
            Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
        }

        return page.toString();
    }

    private void saveImage(String sourceUrl, String filepath) {
        try {
            GrabzItClient grabzIt = new GrabzItClient("MThmZDcxMWIzYmRkNDU1MGI0YzQ4YjM1ODRjNWEwMWE=", "GFc/P2Y/P3k/aT8/P3E/P1tMQj8/PD8/D3c/NVpjPxI=");
            grabzIt.URLToImage(sourceUrl);
            grabzIt.SaveTo(filepath);
        } catch (Exception ex) {
            Logger.getLogger(Core.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public byte[] extractBytes(String ImageName) throws IOException {
        // open image
        File imgPath = new File(ImageName);
        BufferedImage bufferedImage = ImageIO.read(imgPath);

        int w = bufferedImage.getWidth();
        int h = bufferedImage.getHeight();

        for (int i = 0; i < SAMPLE_SIZE; i++) {

            int randomX = (int) (Math.random() * w);
            int randomY = (int) (Math.random() * h);
        }

        // get DataBufferBytes from Raster
        WritableRaster raster = bufferedImage.getRaster();
        DataBufferByte data = (DataBufferByte) raster.getDataBuffer();

        return (data.getData());
    }

    private double cosineSimilarity(double[] vectorA, double[] vectorB) {
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
}
