/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stereotypedetection;

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
}
