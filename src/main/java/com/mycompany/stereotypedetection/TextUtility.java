/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stereotypedetection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author josmario
 */
public class TextUtility {

    private Map<String, Integer> getWordFrequency(String text) {
        Map<String, Integer> totals = new HashMap<>();

        for (String string : text.split(" ")) {
            if (totals.containsKey(text)) {
                Integer temp = totals.get(text);
                totals.remove(string);
                totals.put(text, temp++);
            } else {
                totals.put(text, 1);
            }
        }

        return totals;
    }

    public Double getTextSimilarity(String baseText, String sampleText) {

        Double sim = 0.0;

        return sim;
    }

}
