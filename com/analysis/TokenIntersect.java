/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analysis;

import java.util.HashSet;
import java.util.Set;




/**
 *
 * @author daan-
 */
public class TokenIntersect {

    public static double getMatchRatio(String[] query, String[] data) {
        Set<String> set = new HashSet<>();
        for (String word : data) {
            set.add(word);
        }
        double total = (double) query.length;
        double matches = 0.0;
        for (String q : query) {
            if (set.contains(q)) {
                matches += 1.0;
            }
        }
        if (total == 0.0 || matches == 0.0) {
            return 0.0;
        }
        return matches / total;
    }

}

