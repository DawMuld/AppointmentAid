/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analysis;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;




/**
 * Tries to find emphasized words in a string by detecting duplicate words
 *
 * @author daan-
 */
public class ClauseAccent {

    public static List<String> getAccents(String input) {
        ArrayList<String> resultList = new ArrayList<>();
        Set<String> set = new HashSet<>();
        String text = StopWordFilter.filterStopWords(input);
        String[] tokens = Tokenizer.tokenize(text);
        for (String token : tokens) {
            if (set.contains(token)) {
                resultList.add(token);
            }
            set.add(token);
        }
        return resultList;
    }

}

