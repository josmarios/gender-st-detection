/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stereotypedetection;

/**
 *
 * @author josmario
 */
public class Test {
    
    public static void main(String[] args) {
//        StColor stColor = new StColor();
//        Double[] st = stColor.getColorSt("http://www.ufal.edu.br");
//        System.out.println("[" + st[0] + "," + st[1] + "]");

        new FaceRecognition().getImages("https://www.walmart.com.br/bebedouro-cadence-acqua-plus-mesa-20-litros-quente-e-frio-preto-127v/3430834/pr");
    }
}
