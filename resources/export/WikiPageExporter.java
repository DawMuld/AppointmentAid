/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.export;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;
import net.external.wiki.WikiLink;
import net.external.wiki.WikiList;
import net.external.wiki.WikiPage;





/**
 *
 * @author DaanM
 */
public class WikiPageExporter {

    public static final String storagePath = "C:\\JHealth_ML\\wiki\\";
    public static final DecimalFormat DF = new DecimalFormat("000");





    public static void main(String[] args) {
        File file = new File(storagePath);
        File[] files = file.listFiles();
        for (File item : files) {
            boolean empty = isEmpty(item);
            if (empty == true) {
                item.delete();
            }
        }
    }





    public static void storeWikiPage(File file, WikiPage page) {
        try {
            file.createNewFile();
            PrintWriter writer = new PrintWriter(new FileWriter(file));
            writer.println(page.wikiLink.name + "\n");
            for (int i = 0; i < page.paragraphs.size(); i++) {
                writer.println(page.paragraphs.get(i).toString());
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
        }
    }





    public static boolean isEmpty(File file) {
        boolean empty = true;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            int count = 0;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                count++;
                System.out.println(DF.format(count) + "\t" + line);
            }
            if (count > 10) {
                empty = false;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage() + "\t" + e.getMessage());
        }
        return empty;
    }





}
