/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author josmario
 */
public class Util {

    private static Util instance;
    private final List<String> urls = new ArrayList<>();

    private Util() {

    }

    public static Util getInstance() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }

    public List<String> getUrls() {
        return this.urls;
    }

    public void loadUrls(String filename) {
        System.out.println("LOADING URLs:");
        this.urls.clear();

        try {
            FileReader fr = new FileReader(new File(filename));
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                this.urls.add(line);
                System.out.println(line);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    String readTextFile(String filename) {
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

    InputStream getFileFromResourceAsStream(String fileName) {
        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);
        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }
}
