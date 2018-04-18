package br.com.josmario.stdetection.manager;

import br.com.josmario.stdetection.color.ColorUtility;
import br.com.josmario.stdetection.data.Database;
import br.com.josmario.stdetection.text.HtmlUtility;
import br.com.josmario.stdetection.text.TextUtility;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author josmario
 */
public class Manager {

    private static Manager instance;
    private final String workdir;

    private Manager() {
        workdir = System.getProperty("user.home");
    }

    public static Manager getInstance() {
        if (instance == null) {
            instance = new Manager();
        }
        return instance;
    }

    public static void main(String[] args) {
        // String input = args[0];
        // String output = args[1];

//        Database.getInstance().loadUrls("/home/josmario/repositories/st-detection/urls.txt");
//
//        for (String url : Database.getInstance().getUrls()) {
//            System.out.println("url: " + url);
//        }
        //Manager.getInstance().generateDictionary();
        Manager.getInstance().createDatabase();
    }

    public void generateDictionary() {
        try {
            new File(workdir + "/database/").mkdir();
            File f = new File(workdir + "/database/dictionary.csv");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            String line = "\"url\",\"id\"\n";
            bw.write(line);

            for (String url : Database.getInstance().getUrls()) {

                line = "\"" + url + "\",\"" + UUID.randomUUID().toString() + "\"\n";
                bw.append(line);
                System.out.println(line);
            }
            bw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createDatabase() {
        String baseDir = workdir + "/database/";
        String dictionary = "dictionary.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(baseDir + dictionary))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                line = line.replace("\"", "");
                String[] data = line.split(",");
                String url = data[0];
                String id = data[1];

                new File(baseDir + id).mkdirs();

                String frequency = baseDir + id + "/freq.csv";
                String screenshot = baseDir + id + "/screenshot.png";
                String sampleImg = baseDir + id + "/sample.png";
                String sampleCsv = baseDir + id + "/sample.csv";

                 TextUtility.getInstance().storeFrequency(url, frequency);
                ColorUtility.getInstance().saveImage(url, screenshot);
                ColorUtility.getInstance().saveSample(screenshot, sampleImg, sampleCsv);
            }

        } catch (IOException e) {
        }

    }

}
