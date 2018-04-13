/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.josmario.stdetection.text;

import br.com.josmario.stdetection.color.StColor;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author josmario
 */
public class HtmlUtility {

    private static HtmlUtility instance;

    private HtmlUtility() {
    }

    public static HtmlUtility getInstance() {
        if (instance == null) {
            instance = new HtmlUtility();
        }
        return instance;
    }

    /**
     * Gets html content from a given page
     *
     * @param url Page URL
     * @return
     */
    public String getPage(String url) {
        Document page = null;
        try {
            page = Jsoup.connect(url).get();
        } catch (IOException ex) {
            Logger.getLogger(StColor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return page.toString();
    }

    public Document getPageDocument(String url) {
        Document page = null;
        try {
            page = Jsoup.connect(url).get();
        } catch (IOException ex) {
            Logger.getLogger(StColor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return page;
    }

    public String getPlainText(String url) {
        return this.getPage(url).replaceAll("\\<[^>]*>", "");
    }
}
