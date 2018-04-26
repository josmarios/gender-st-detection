/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.josmario.stdetection.text;

import br.com.josmario.stdetection.data.Database;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

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

//        Double max = 0.0;
//        for (Double current : values.values()) {
//            max = current >= max ? current : max;
//        }
        double total = 0.0;

        for (Double value : values.values()) {
            total += value;
        }

        for (String w : values.keySet()) {
            double normal = values.get(w) / total;

            normal = Math.round(normal * 1000000);
            normal /= 1000000;
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

        totals = normalize(totals);

        return totals;
    }

    public double getBias(Map<String, Double> base, Map<String, Double> sample) {

        if (base == null || sample == null) {
            return 0.0;
        }

        double st = 0.0;

        double total = 0.0;
        double cummulativeSt = 0.0;
//        double totalSt = 0.0;
//        for (String string : base.keySet()) {
//            totalSt += base.get(string);
//
//        }
//        for (String string : sample.keySet()) {
//            if (base.containsKey(string)) {
//
//                System.out.println(base.get(string) + "-" + sample.get(string));
//                double stStrength = Math.sqrt(base.get(string) * sample.get(string));
//                cummulativeSt += stStrength;
//                total++;
//            }
//        }
//
//        double overallStrength = totalSt != 0 ? cummulativeSt / totalSt : 0.0;
        double freqScore = getFrequencyScore(base.keySet(), sample.keySet());

//        st = Math.sqrt(overallStrength * freqScore);
//        System.out.println("cummulativeSt: " + cummulativeSt);
//        System.out.println("Totalst: " + totalSt);
//        System.out.println("overallStrength: " + overallStrength);
//        System.out.println("freqScore: " + freqScore);
//        System.out.println("st: " + st);
        return freqScore;
    }

    public Double getBias(Map<String, Double> base, String text) {
        Double[] st = {};
        List<String> words = new ArrayList<>();

        if (text != null) {

            String temp = text
                    .replaceAll("[\\n]+", " ")
                    .replaceAll("[0-9]", "")
                    .replaceAll("[\\s]+", "0")
                    .replaceAll("\\W", "");

            for (String string : temp.split("0")) {
                String s = string.toLowerCase();
                if (s.length() > 2) {
                    words.add(s);
                }
            }

            Map<String, Double> freqs = this.getWordFrequency(words);
            return this.getBias(base, freqs);
        }

        return 0.0;
    }

    private double getFrequencyScore(Set<String> baseText, Set<String> sample) {

        double sim = 0.0;
        double total = 0.0;

        for (String string : sample) {
            if (baseText.contains(string)) {
                total++;
            }
        }

        sim = sample.size() > 0 ? total / sample.size() : 0.0;
        // sim = Math.round(sim * 100000) / 100000D;

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

    public void storeFrequency(String url, String target) {

        System.out.println("Getting wordlist...");
        List<String> wordList = HtmlUtility.getInstance().getWordList(url);

        if (wordList != null) {

            System.out.println("Calculating word frequencies...");
            Map<String, Double> freq = this.getWordFrequency(wordList);

            File out = new File(target);

            try {

                FileWriter fw = new FileWriter(out);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.append("\"term\", \"relative_frequency\"\n");
                for (String term : freq.keySet()) {
                    String line = "\"" + term + "\", \"" + freq.get(term) + "\"\n";
                    bw.append(line);
                }
            } catch (IOException e) {
            }
        } else {

            System.out.println("Couldn't get a valid word list from '" + url + "'. Frequency not stored.");
        }
    }

}
