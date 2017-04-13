/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stereotypedetection;

import gui.ava.html.image.generator.HtmlImageGenerator;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.*;
import org.jsoup.nodes.Document;

/**
 *
 * @author josmario
 */
public class Core {

    public static void main(String[] args) {
        Core c = new Core();
        String url = "http://www.ufal.edu.br";

        c.saveImage(url);

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

    private void saveImage(String url) {
        HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
        imageGenerator.loadUrl(url);
        imageGenerator.saveAsImage("/home/josmario/temp/ufal.png");
    }

}
