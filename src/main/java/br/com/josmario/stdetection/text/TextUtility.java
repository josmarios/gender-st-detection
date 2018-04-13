/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.josmario.stdetection.text;

import br.com.josmario.stdetection.data.Database;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author josmario
 */
public class TextUtility {

    public static void main(String[] args) {
        String input = args[0];
        String output = args[1];

        Database.getInstance().loadUrls(input);

        for (String url : Database.getInstance().getUrls()) {
            System.out.println(HtmlUtility.getInstance().getPlainText(url));
        }
    }

    public Map<String, Integer> getWordFrequency(String text) {
        Map<String, Integer> totals = new HashMap<>();

        for (String word : text.split(" ")) {
            if (totals.containsKey(word)) {
                Integer temp = totals.get(word);
                totals.remove(word);
                totals.put(word, ++temp);
            } else {
                totals.put(word, 1);
            }
        }

        return totals;
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
