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
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.management.RuntimeErrorException;








/**
 *
 * @author daanm
 */
public class SymptomProcessor {
    private static final String PATH_IN = "C:\\Users\\DaanM\\OneDrive - Pharma Partners B.V\\projects\\symptomen_index.csv";
    private static final String PATH_OUT = "C:\\Users\\DaanM\\OneDrive - Pharma Partners B.V\\projects\\symptomen_set.txt";
    
    
    public static void main(String[] args){
        Set<String> set = new HashSet<>();
        ArrayList<String> tokenList = new ArrayList<>();
        File fileIn = new File(PATH_IN);
        File fileOut = new File(PATH_OUT);
        
        try{
            
            BufferedReader reader = new BufferedReader(new FileReader(fileIn));
            String line;
            for(line = reader.readLine(); line != null; line = reader.readLine()){
                String[] tokens = tokenize(line);
                for(String token:tokens){
                    tokenList.add(token);
                    if(token.length() >=3){
                        set.add(token);
                    }
                }
            }
            reader.close();
            System.out.println("Amount of tokens          : " + tokenList.size());
            System.out.println("Amount of distinct tokens : " + set.size());
        }catch(IOException e){
            System.out.println("Reader Error");
            throw new RuntimeErrorException(new Error("Cannot proceed when failed to process input"));
        }
        ArrayList<String> indexWords = new ArrayList<>();
        String[] setArray = new String[set.size()];
        setArray = set.toArray(setArray);
        for(int i = 0; i < set.size();i++){
            indexWords.add(setArray[i]);
        }
        Collections.sort(indexWords);
        try{
            fileOut.createNewFile();
            PrintWriter writer = new PrintWriter(new FileWriter(fileOut));
            Iterator<String> iterator = indexWords.iterator();
            while(iterator.hasNext()){
                writer.println(iterator.next());
            }
            writer.flush();
            writer.close();
            System.out.println("Finished writing the output");
        }catch(IOException e){
        
        }
        
        
        
        
    }
    
    
    public static String[] tokenize(String line){
        String[] words = line.split("\\s");
        for(int i = 0; i < words.length; i++){
            String word = words[i].trim();
            word = word.replaceAll("\'", "");
            word = word.replaceAll("\"", "");
            word = word.replaceAll("\\(", "");
            word = word.replaceAll("\\)", "");
            word = word.replaceAll("\\d", "");
            word = word.replaceAll("-", "");
            word = word.replaceAll("/", "");
            word = word.replaceAll(":", "");
            word = word.replaceAll(",", "");
            words[i] = word;
        }
        
        
        
        return words;
    }
    
    
   
    
    
    
    
    
    
    
    
}



