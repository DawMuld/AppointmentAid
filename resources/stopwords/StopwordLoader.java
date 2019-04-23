/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.stopwords;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import modules.subapp.translator.TranslationApp;
import net.external.translations.Translation;
import net.external.translations.TranslationResult;
import net.external.translations.TranslatorDisplayer;





/**
 *
 * @author DaanM
 */
public class StopwordLoader {

    public static List<String> loadStopwordsEN() {
        List<String> list = new ArrayList<>();
        File file = new File(System.getProperty("user.dir") + "\\src\\resources\\stopwords\\stopwords_en.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String word;
            for (word = reader.readLine(); word != null; word = reader.readLine()) {
                list.add(word);
            }
        } catch (Exception e) {
            System.out.println("Exception thrown while loading wordlist_en.txt");
        }
        return list;
    }





    public static List<String> loadStopWordsNL() {
        List<String> list = new ArrayList<>();
        File file = new File(System.getProperty("user.dir") + "\\src\\resources\\stopwords\\stopwords_nl.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String word;
            for (word = reader.readLine(); word != null; word = reader.readLine()) {
                list.add(word);
            }
        } catch (Exception e) {
            System.out.println("Exception thrown while loading wordlist_en.txt");
        }
        return list;
    }





}
