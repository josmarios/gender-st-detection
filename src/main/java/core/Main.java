package core;

import core.ColorUtility;
import core.Util;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;
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
public class Main {

    private static Main instance;
    private String BASE_DIR;
    private String URLS_FILE;

    private Main() {
    }

    public static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    public static void main(String[] args) {

        if (args.length > 0) {
            String input = args[0];

            System.out.println("input: " + input);
            if (Files.isDirectory(Path.of(input))) {
                System.out.println("Calculating bias");
                Main.getInstance().BASE_DIR = input;
                Main.getInstance().calculateBias(-1);
            } else {

                Main.getInstance().URLS_FILE = input;
                Main.getInstance().BASE_DIR = new File(input).getParent() + "/";

                Logger.getGlobal().log(Level.INFO, "Loading URLs from {0}", Main.getInstance().URLS_FILE);
                Logger.getGlobal().log(Level.INFO, "Setting working directory to {0}", Main.getInstance().BASE_DIR);

                Util.getInstance().loadUrls(Main.getInstance().URLS_FILE);
                Main.getInstance().generateDictionary();
                Main.getInstance().createDatabase();

            }
        }
    }



    public void generateDictionary() {
        try {

            File f = new File(BASE_DIR + "dictionary.csv");
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            String line = "\"url\",\"id\"\n";
            bw.write(line);

            for (String url : Util.getInstance().getUrls()) {

                line = url + "," + UUID.randomUUID().toString() + "\n";
                bw.append(line);
                System.out.println(line);
            }
            bw.close();
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createDatabase() {

        String dictionary = "dictionary.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(BASE_DIR + dictionary))) {
            while ((line = br.readLine()) != null) {
                try {
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
                } catch (Exception e) {
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
            fw.append("id, red, green, blue, text-f, text-m, color-f, color-m\n");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (String dir : new File(BASE_DIR).list(filter)) {

            try {
                System.out.println("================> " + dir + " <================");

                //get url from dict
//                String key = Files.readAllLines(Path.of(BASE_DIR + dir)).stream().filter(l -> l.contains(dir)).findFirst().get();
                Double[] textBias = getWordListBias(dir + "/freq.csv");
//                Double[] colorBias = ColorUtility.getInstance().getBias(BASE_DIR + dir + "/sample.csv");
                Double[] rgbMean = ColorUtility.getInstance().getAverageColor(BASE_DIR + dir + "/sample.csv");
                Double[] colorBias = ColorUtility.getInstance().getBias(BASE_DIR + dir + "/sample.csv");

                NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);
                DecimalFormat df = (DecimalFormat) nf;
                df.applyPattern("##.######");
//                DecimalFormat df = new DecimalFormat("#.######");
                df.setRoundingMode(RoundingMode.CEILING);

//                String line = df.format(colorBias[0]) + "," + df.format(colorBias[1]) + "," + df.format(textBias[0]) + "," + df.format(textBias[1]) + "," + gender + "\n";
//                System.out.println("color-f, color-m, text-f, text-m, gender(0-f, 1-m)");
                String line = "";

                line = dir + ","
                        + df.format(rgbMean[0]) + ","
                        + df.format(rgbMean[1]) + ","
                        + df.format(rgbMean[2]) + ","
                        + df.format(textBias[0]) + ","
                        + df.format(textBias[1]) + ","
                        + df.format(colorBias[0]) + ","
                        + df.format(colorBias[1]) + "\n";

                System.out.println("id, red, green, blue, text-f, text-m, color-f, color-m");
                System.out.println(line);
                fw.append(line);
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
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

        String text = Util.getInstance().readTextFile(file);
        Double mScore = TextUtility.getInstance().getBias(stMale, text);
        Double fScore = TextUtility.getInstance().getBias(stFemale, text);
        stScore = Math.abs(mScore - fScore);

        Double decision = mScore > fScore ? -1.0 : 1.0;

        decision = stScore < 0.5 ? 0.0 : decision;

        Double[] st = {mScore, fScore, stScore, decision};
        return st;

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
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return data;
    }
}
