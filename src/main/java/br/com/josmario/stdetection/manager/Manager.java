package br.com.josmario.stdetection.manager;

import br.com.josmario.stdetection.color.ColorUtility;
import br.com.josmario.stdetection.data.Database;
import br.com.josmario.stdetection.text.HtmlUtility;
import br.com.josmario.stdetection.text.TextUtility;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
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
    private final String BASE_DIR;
    private final String URLS_FILE = "/home/josmario/universities.txt";

    private Manager() {
        BASE_DIR = System.getProperty("user.home") + "/database/";
        new File(BASE_DIR).mkdir();
    }

    public static Manager getInstance() {
        if (instance == null) {
            instance = new Manager();
        }
        return instance;
    }

    public static void main(String[] args) {

        if (args.length > 0) {
            String input = args[0];
            Double[] score = Manager.getInstance().getTextBias(input);
            String genderMessage = score[0] > score[1] ? "MALE" : "FEMALE";
            String neutralMessage = "No";
            String decision = score[3] != 0 ? genderMessage : neutralMessage;
            System.out.println("Overall Decision: " + decision + " stereotype.");
        } else {

            while (true) {
                Manager.getInstance().showMenu();

            }
        }
    }

    private void showMenu() {

        System.out.println(""
                + "\n---------------------\n"
                + "0-Exit\n"
                + "1-Load URLs\n"
                + "2-Generate Dictionary\n"
                + "3-Create Database\n"
                + "4-Calculate Bias");

        Scanner sc = new Scanner(System.in);
        int exit = sc.nextInt();

        //show menu
        switch (exit) {
            case 1:
                Database.getInstance().loadUrls(URLS_FILE);
                break;
            case 2:
                Manager.getInstance().generateDictionary();
                break;
            case 3:
                Manager.getInstance().createDatabase();
                break;
            case 4:
                Manager.getInstance().calculateBias(1);
                break;
            default:
                System.exit(0);
        }
    }

    public void generateDictionary() {
        try {

            File f = new File(BASE_DIR + "dictionary.csv");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            String line = "\"url\",\"id\"\n";
            bw.write(line);

            for (String url : Database.getInstance().getUrls()) {

                line = url + "," + UUID.randomUUID().toString() + "\n";
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

        String dictionary = "dictionary.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(BASE_DIR + dictionary))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String url = data[0];
                String id = data[1];

                System.out.println("\n========================> [" + url + "] <========================");
                new File(BASE_DIR + id).mkdirs();

                String frequency = BASE_DIR + id + "/freq.csv";
                String screenshot = BASE_DIR + id + "/screenshot.png";
                String sampleImg = BASE_DIR + id + "/sample.png";
                String sampleCsv = BASE_DIR + id + "/sample.csv";

                if (!new File(frequency).exists()) {
                    System.out.println("Storing word frequencies...");
                    TextUtility.getInstance().storeFrequency(url, frequency);
                }

                if (!new File(screenshot).exists()) {
                    System.out.println("Saving screenshot...");
                    ColorUtility.getInstance().saveImage(url, screenshot);
                }

                if (!new File(sampleImg).exists()) {
                    System.out.println("Saving sample...");
                    ColorUtility.getInstance().saveSample(screenshot, sampleImg, sampleCsv);
                }
            }

        } catch (IOException e) {
        }
    }

    public void calculateBias(int gender) {

        FilenameFilter filter = (File dir, String name) -> name.contains("-");
        FileWriter fw = null;
        try {
            fw = new FileWriter(new File(BASE_DIR + "biasdata.csv"));
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (String dir : new File(BASE_DIR).list(filter)) {

            try {
                System.out.println("================> " + dir + " <================");

                Double[] textBias = getWordListBias(dir + "/freq.csv");
                Double[] colorBias = ColorUtility.getInstance().getBias(BASE_DIR + dir + "/sample.csv");

                NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
                DecimalFormat df = (DecimalFormat) nf;
                df.applyPattern("##.######");
//                DecimalFormat df = new DecimalFormat("#.######");
                df.setRoundingMode(RoundingMode.CEILING);

                String line = df.format(colorBias[0]) + "," + df.format(colorBias[1]) + "," + df.format(textBias[0]) + "," + df.format(textBias[1]) + "," + gender + "\n";
                System.out.println("color-f, color-m, text-f, text-m, gender(0-f, 1-m)");
                System.out.println(line);
                fw.append(line);
            } catch (IOException ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        try {
            fw.flush();
            fw.close();
        } catch (IOException ex) {

        }
    }

    private Double[] getWordListBias(String file) {

        double stScore = 0;

        Map<String, Double> stMale = readData("stMale.csv");
        Map<String, Double> stFemale = readData("stFemale.csv");
        Map<String, Double> sample = readData(file);

        Double mScore = TextUtility.getInstance().getBias(stMale, sample);
        Double fScore = TextUtility.getInstance().getBias(stFemale, sample);
        stScore = Math.abs(mScore - fScore);

        Double decision = mScore > fScore ? -1.0 : 1.0;

        decision = stScore < 0.5 ? decision : 0.0;

        Double[] st = {fScore, mScore, stScore, decision};
        return st;

    }

    private Double[] getTextBias(String file) {

        double stScore = 0;

        Map<String, Double> stMale = readData("stMale.csv");
        Map<String, Double> stFemale = readData("stFemale.csv");

        String text = this.readTextFile(file);
        Double mScore = TextUtility.getInstance().getBias(stMale, text);
        Double fScore = TextUtility.getInstance().getBias(stFemale, text);
        stScore = Math.abs(mScore - fScore);

        Double decision = mScore > fScore ? -1.0 : 1.0;

        decision = stScore < 0.5 ? 0.0 : decision;

        Double[] st = {mScore, fScore, stScore, decision};
        return st;

    }

    private String readTextFile(String filename) {
        String text = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filename)));

            String line = "";
            while ((line = br.readLine()) != null) {
                text += line + "\n";
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File not found: " + filename);
        } catch (IOException ex) {
            System.out.println("Error while reading '" + filename + "'.");
        }
        return text;
    }

    private Map<String, Double> readData(String filename) {
        Map<String, Double> data = new HashMap<>();

        if (filename.equals("stFemale.csv") || filename.equals("stMale.csv")) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(filename)));
                String line = br.readLine();
                while ((line = br.readLine()) != null) {
                    String word = line.split(",")[0].replaceAll("\"", "");
                    Double value = Double.valueOf(line.split(",")[1].replaceAll("\"", ""));
                    data.put(word.toLowerCase(), value);
                }

            } catch (Exception ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

            try {
                BufferedReader br = new BufferedReader(new FileReader(new File(BASE_DIR + filename)));
                String line = br.readLine();
                while ((line = br.readLine()) != null) {
                    String word = line.split(",")[0].replaceAll("\"", "");
                    Double value = Double.valueOf(line.split(",")[1].replaceAll("\"", ""));
                    data.put(word.toLowerCase(), value);
                }
            } catch (Exception ex) {
                Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return data;
    }

}
