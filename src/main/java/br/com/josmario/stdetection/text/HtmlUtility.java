/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.josmario.stdetection.text;

import br.com.josmario.stdetection.color.ColorUtility;
import java.io.IOException;
import java.net.URL;
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
            page = Jsoup.parseBodyFragment(
                    Jsoup.connect(url)
                            .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.79 Safari/537.36")
                            .timeout(10000)
                            .get()
                            .body()
                            .html()
            );
//            page = Jsoup.connect(url).timeout(10000).get();
        } catch (IOException ex) {
            Logger.getLogger(ColorUtility.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return page.toString();
    }

    public Document getPageDocument(String url) {
        Document page = null;
        try {
            page = Jsoup.parseBodyFragment(
                    Jsoup.connect(url)
                            .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.79 Safari/537.36")
                            .timeout(10000)
                            .get()
                            .body()
                            .html()
            );

//            page = Jsoup.parse(new URL(url), 1000);
            //page = Jsoup.connect(url).get();
        } catch (IOException ex) {
            Logger.getLogger(ColorUtility.class.getName()).log(Level.SEVERE, null, ex);
        }

        return page;
    }

    public List<String> getWordList(String url) {
        List<String> result = new ArrayList<>();

        String pageContent = this.getPage(url);

        if (pageContent != null) {

            System.out.println("Cleaning HTML tags...");
            String temp = pageContent
                    .replaceAll("</body>[\\w|\\W]+", "")
                    .split("<body\\b[^<]*>")[1]
                    .replaceAll("[\\s]*\\{.*?\\}", "")
                    .replaceAll("<script\\b[^<]*(?:(?!</script>)<[^<]*)*</script>", "")
                    .replaceAll("<[^>]*>", "")
                    .replaceAll("\n", " ")
                    .replaceAll("  ", " ")
                    .replaceAll("[0-9]", "")
                    .replaceAll("[\\s]+", "0")
                    .replaceAll("\\W", "");

            for (String string : temp.split("0")) {
                String s = string.toLowerCase();
                if (s.length() > 2) {
                    result.add(s);
                }
            }
            return result;
        }
        return null;
    }
}
