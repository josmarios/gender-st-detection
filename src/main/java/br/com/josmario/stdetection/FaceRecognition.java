/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.josmario.stdetection;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author josmario
 */
public class FaceRecognition {

    private final String TEMP_DIR = "/home/josmario/imgs-temp/";

    public FaceRecognition() {
        try {
            Files.createDirectory(Paths.get(TEMP_DIR));
        } catch (IOException ex) {
            Logger.getLogger(FaceRecognition.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Lists images from a given web page
     *
     * @param pageUrl Page URL
     */
    public void getImages(String pageUrl) {

        Document content = new HtmlUtility().getPageDocument(pageUrl);
        Elements images = content.select("img");
        for (Element element : images) {

            try {
                String currentUrl = element.absUrl("src");
                System.out.println("Found: " + currentUrl);
                URL url = new URL(currentUrl);
                BufferedImage iosStream = ImageIO.read(url);

                ImageIO.write(iosStream, "png", new File(TEMP_DIR + "-" + UUID.randomUUID().toString() + ".png"));

            } catch (Exception ex) {

            }
        }

    }

}
