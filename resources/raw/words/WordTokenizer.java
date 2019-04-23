/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.raw.words;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;








/**
 *
 * @author daanm
 */
public class WordTokenizer {
    
    public static String[] tokenizeArray(String input){
        String text = removeInterpunction(input);
        return splitToTokens(text);
    }
    
    public static List<String> tokenizeList(String input){
        List<String> list = new ArrayList<>();
        String[] array = tokenizeArray(input);
        for(int i = 0; i < array.length; i++){
            list.add(array[i]);
        }
        return list;
        
    }
    
    
    public static ObservableList<String> tokenizeObservable(String input){
        ObservableList<String> list = FXCollections.observableArrayList();
         String[] array = tokenizeArray(input);
        for(int i = 0; i < array.length; i++){
            list.add(array[i]);
        }
        return list;
    }
    
    
    
    private static String[] splitToTokens(String input){
        return input.split("\\s");
    }
    
    
    
    private static String removeInterpunction(String input){
        String result = input.replaceAll("\\.", "");
        result = result.replaceAll(",", "");
        result = result.replaceAll("/", " ");
        result = result.replaceAll("-", " ");
        result = result.replaceAll("\n", " ");
        result = result.replaceAll("\t", " ");
        result = result.replaceAll("'", " ");
        result = result.replaceAll("\"", " ");
        result = result.replaceAll(":", " ");
        result = result.replaceAll(";", " ");
        result = result.replaceAll("  ", " ");
        result = result.replaceAll("   ", " ");
        return result;
        
        
    
    }
    
    
    
}



