/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analysis;




/**
 *
 * @author daan-
 */
public class Tokenizer {

    public static String[] tokenize(String input) {
        String text = input.replaceAll("\\.", " ");
        text = text.replaceAll(",", " ");
        text = text.replaceAll("\\(", "");
        text = text.replaceAll("\\)", "");
        text = text.replaceAll("\\?", "");
        text = text.replaceAll("\\\\", "");
        text = text.replaceAll("/", " ");
        text = text.replaceAll("!", "");
        text = text.replaceAll(":", "");
        text = text.replaceAll("'", "");
        text = text.replaceAll("\"", "");
        text = text.replaceAll("\\s\\s", " ");
        text = text.replaceAll("\\s\\s\\s", " ");
        text = text.replaceAll("\\s\\s\\s\\s", " ");
        return text.split(" ");
    }






    public static void printTokens(String[] input) {
        String line = "";
        for (String token : input) {
            line += token + " - ";
        }
        System.out.println(line);
    }

}

