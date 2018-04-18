/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.josmario.stdetection.text;

import br.com.josmario.stdetection.color.ColorUtility;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
            Logger.getLogger(ColorUtility.class.getName()).log(Level.SEVERE, null, ex);
        }

        return page.toString();
    }

    public Document getPageDocument(String url) {
        Document page = null;
        try {
            page = Jsoup.connect(url).get();
        } catch (IOException ex) {
            Logger.getLogger(ColorUtility.class.getName()).log(Level.SEVERE, null, ex);
        }

        return page;
    }

    public List<String> getWordList(String url) {
        List<String> result = new ArrayList<>();

        String temp = this.getPage(url).replaceAll("</body>[\\w|\\W]+", "");
        temp = temp.replaceAll("[\\w|\\W]+<body>", "");
        temp = temp.replaceAll("\\s*\\{.*?\\}", "");
        temp = temp.replaceAll("<script\\b[^<]*(?:(?!<\\/script>)<[^<]*)*<\\/script>", "");
        temp = temp.replaceAll("\\<[^>]*>", "");
        temp = temp.replace("[\\n]+", "[\\s]");
        temp = temp.replace("\\s\\s", "\\s");

        for (String string : temp.split(" ")) {
            result.add(string.replace("\\W", ""));
        }

        return result;
    }
}
