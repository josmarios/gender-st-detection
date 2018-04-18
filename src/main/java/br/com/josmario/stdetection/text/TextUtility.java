/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.josmario.stdetection.text;

import br.com.josmario.stdetection.data.Database;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author josmario
 */
public class TextUtility {

    private static TextUtility instance;

    private TextUtility() {
    }

    public static TextUtility getInstance() {
        if (instance == null) {
            instance = new TextUtility();
        }
        return instance;
    }

    public static void main(String[] args) {
//        String input = args[0];
//        String output = args[1];
//
//        Database.getInstance().loadUrls(input);
//
//        for (String url : Database.getInstance().getUrls()) {
//            System.out.println(HtmlUtility.getInstance().getPlainText(url));
//        }

        String source = "https://www.google.com";

        Map<String, Double> freqs = TextUtility.getInstance().getWordFrequency(HtmlUtility.getInstance().getWordList(source));
        for (String s : freqs.keySet()) {
            System.out.println(s + ":" + freqs.get(s) + "\n");
        }
    }

    private Map<String, Double> normalize(Map<String, Double> values) {
        Map<String, Double> result = new HashMap<>();

        Double max = 0.0;
        for (Double current : values.values()) {
            max = current > max ? current : max;
        }

        for (String w : values.keySet()) {
            double normal = values.get(w) / max;
            result.put(w, normal);
        }

        return result;
    }

    public Map<String, Double> getWordFrequency(List<String> text) {
        Map<String, Double> totals = new HashMap<>();

        for (String word : text) {
            if (totals.containsKey(word)) {
                Double temp = totals.get(word);
                totals.remove(word);
                totals.put(word, ++temp);
            } else {
                totals.put(word, 1.0);
            }
        }

        return normalize(totals);
    }

    public Double getTextSimilarity(String baseText, String sampleText) {

        Double sim = 0.0;

        return sim;
    }

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

}
