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
public class StringNormalizer {

    public static String normalizeToLines(String input) {
        String text = input.replaceAll("\\.\\s", ".\n");
        return text;
    }

}

