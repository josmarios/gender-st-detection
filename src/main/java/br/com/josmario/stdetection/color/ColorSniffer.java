/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.josmario.stdetection.color;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author josmario
 */
public class ColorSniffer {

    private final static List<String> target = new ArrayList<>();
    private static ColorSniffer instance;

    private ColorSniffer() {
        if (this.instance == null) {
            instance = new ColorSniffer();
        }

        target.add("http://www.ufal.edu.br");
    }

    private static ColorSniffer getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        StColor stColor = new StColor();
        Double[] st = stColor.getColorSt("http://www.girlsgogames.com/");

        System.out.println("[" + st[0] + "," + st[1] + "]");

        //  new FaceRecognition().getImages("https://www.walmart.com.br/bebedouro-cadence-acqua-plus-mesa-20-litros-quente-e-frio-preto-127v/3430834/pr");
        String text1 = "O rato roeu a roupa do rei de roma e foi andar com o cachorro. O Rato nao gostava do gato.";
//        String text1 = "o rato mora rato rato casa mora o a";
//        
//        Map<String, Integer> freq = new TextUtility().getWordFrequency(text1.toLowerCase());
//        
//        for (String string : freq.keySet()) {
//            System.out.println(string+": "+ freq.get(string));
//        }

    }
}
