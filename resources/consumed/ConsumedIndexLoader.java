/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.consumed;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import net.external.gen.Href;





/**
 *
 * @author DaanM
 */
public class ConsumedIndexLoader {

    public static List<Href> loadConsumedIndex() {
        List<Href> list = new ArrayList<>();
        String path = System.getProperty("user.dir") + "\\src\\resources\\consumed\\consumed_index.txt";
        File file = new File(path);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] items = line.split(";");
                String name = items[0];
                String href = items[1];
                list.add(new Href(name, href));
            }
            reader.close();
        } catch (Exception e) {
        }
        return list;
    }


    public static List<Href> loadConsumedicineIndex() {
        List<Href> list = new ArrayList<>();
        String path = System.getProperty("user.dir") + "\\src\\resources\\consumed\\consumedicine_index.txt";
        File file = new File(path);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] items = line.split(";");
                String name = items[0];
                String href = items[1];
                list.add(new Href(name, href));
            }
            reader.close();
        } catch (Exception e) {
        }
        return list;
    }





    public static void main(String[] args) {
        List<Href> list = loadConsumedicineIndex();
        for (Href href : list) {
            System.out.println(href.toString());
        }
    }





}
