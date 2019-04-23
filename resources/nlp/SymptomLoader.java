/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.nlp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;





/**
 *
 * @author DaanM
 */
public class SymptomLoader {

    public static List<String> getSymptomList() {
        String path = System.getProperty("user.dir") + "\\src\\resources\\nlp\\symptom_db.txt";
        File file = new File(path);
        List<String> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                String item = line.split(";")[1];
                list.add(item);
            }
            reader.close();
        } catch (Exception e) {
        }
        return list;
    }





}
