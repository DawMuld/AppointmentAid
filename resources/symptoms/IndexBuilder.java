/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.symptoms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;




/**
 *
 * @author daanm
 */
public class IndexBuilder {

    private static final String DATA_PATH = System.getProperty("user.dir") + "\\src\\resources\\nlp\\symptom_db.txt";
    private static final String DICT_PATH = "C:\\Users\\DaanM\\OneDrive - Pharma Partners B.V\\projects\\symptomen_set.txt";
    private static final String INDX_PATH = System.getProperty("user.dir") + "\\src\\resources\\nlp\\symptom_index.txt";






    public static void main(String[] args) {
        ArrayList<IndexKey> indexKeys = loadIndexKeys();
        ArrayList<SymptomItem> symptomItems = loadSymptoms();
        for (IndexKey indexKey : indexKeys) {
            System.out.println(indexKey.toLine());
        }
        for (SymptomItem symptomItem : symptomItems) {
            System.out.println(symptomItem.toString());
        }
    }






    public static ArrayList<IndexKey> loadIndexKeys() {
        ArrayList<IndexKey> indexKeys = new ArrayList<>();
        File file = new File(System.getProperty("user.dir") + "\\src\\resources\\nlp\\symptom_index.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] items = line.split(";");
                String word = items[0];
                if (items.length > 1) {
                    int[] indices = new int[items.length - 1];
                    for (int i = 1; i < items.length; i++) {
                        int index = Integer.parseInt(items[i]);
                        indices[(i - 1)] = index;
                    }
                    IndexKey indexKey = new IndexKey(word, indices);
                    indexKeys.add(indexKey);
                }
            }
            reader.close();
        } catch (IOException e) {
        }
        return indexKeys;

    }






    public static ArrayList<SymptomItem> loadSymptoms() {
        File file = new File(System.getProperty("user.dir") + "\\src\\resources\\nlp\\symptom_db.txt");
        ArrayList<SymptomItem> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                System.out.println(line);
                String indexString = line.split(";")[0];
                indexString = indexString.replaceAll("\\D", "");
                System.out.println(indexString);
                int index = Integer.parseInt(indexString);
                String symptom = line.split(";")[1];
                list.add(new SymptomItem(index, symptom));
            }
            reader.close();
        } catch (IOException e) {
        }
        return list;
    }






    private static ArrayList<String> loadDictionary() {
        File file = new File(DICT_PATH);
        ArrayList<String> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                list.add(line);
            }
            reader.close();
        } catch (IOException e) {
        }
        return list;
    }






    private static ArrayList<Integer> getMatchingIndices(String word, ArrayList<SymptomItem> symptoms) {
        ArrayList<Integer> list = new ArrayList<>();
        for (SymptomItem symptom : symptoms) {
            if (symptom.symptom.contains(word)) {
                list.add(symptom.index);
            }
        }
        return list;
    }






    private static ArrayList<IndexKey> buildIndexList(ArrayList<SymptomItem> symptomItems, ArrayList<String> keys) {
        ArrayList<IndexKey> indexKeys = new ArrayList<>();
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            ArrayList<Integer> indexList = getMatchingIndices(key, symptomItems);
            IndexKey indexKey = new IndexKey(key, indexList);
            indexKeys.add(indexKey);
        }
        return indexKeys;
    }






    private static void exportIndexKeys(ArrayList<IndexKey> indexKeys) {
        File file = new File(INDX_PATH);
        try {
            file.createNewFile();
            PrintWriter writer = new PrintWriter(new FileWriter(file));
            Iterator<IndexKey> iterator = indexKeys.iterator();
            while (iterator.hasNext()) {
                IndexKey indexKey = iterator.next();
                if (indexKey.indices != null && indexKey.indices.length >= 1) {
                    writer.println(indexKey.toLine());
                }
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
        }
        System.out.println("Finished Export");
    }

}

