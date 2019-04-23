/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.symptoms;

import com.analysis.Tokenizer;
import java.util.ArrayList;
import java.util.List;




/**
 *
 * @author daan-
 */
public class SymptomEvaluator {

    public static List<String> refineSymptomList(List<String> symptomList, String context) {
        ArrayList<String> list = new ArrayList<>();
        if (symptomList == null && symptomList.isEmpty()) {
            return list;
        }
        String[] tokens = Tokenizer.tokenize(context);
        for (String symtom : symptomList) {
            if (intersectingTokens(tokens, Tokenizer.tokenize(symtom))) {
                list.add(symtom);
            }
        }
        return list;
    }






    public static boolean intersectingTokens(String[] set1, String[] set2) {
        for (int i = 0; i < set1.length; i++) {
            String token = set1[i];
            for (int j = 0; j < set2.length; j++) {
                if (token.equalsIgnoreCase(set2[j])) {
                    return true;
                }
            }
        }
        return false;
    }

}

