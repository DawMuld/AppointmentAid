/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.symptoms;

import com.analysis.TokenIntersect;
import com.analysis.Tokenizer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import resources.symptoms.IndexBuilder;
import resources.symptoms.IndexKey;
import resources.symptoms.SymptomItem;




/**
 *
 * @author daanm
 */
public class SymptomDatabase {

    private static SymptomDatabase instance;
    private final ArrayList<IndexKey> indexKeys;
    private final ArrayList<SymptomItem> symptomItems;






    public static SymptomDatabase getInstance() {
        if (instance == null) {
            synchronized (SymptomDatabase.class) {
                if (instance == null) {
                    instance = new SymptomDatabase();
                }
            }
        }
        return instance;
    }






    private SymptomDatabase() {
        indexKeys = IndexBuilder.loadIndexKeys();
        symptomItems = IndexBuilder.loadSymptoms();
    }






    public ArrayList<String> detectSymptom(String input) {
        ArrayList<IndexKey> keyList = new ArrayList<>();
        for (int i = 0; i < indexKeys.size(); i++) {
            IndexKey indexKey = indexKeys.get(i);
            if (input.contains(indexKey.key)) {
                keyList.add(indexKey);
            }
        }
        ArrayList<String> symptoms = new ArrayList<>();
        if (!keyList.isEmpty()) {
            for (IndexKey indexKey : keyList) {
                for (int index : indexKey.indices) {
                    symptoms.add(symptomItems.get(index).symptom);
                }
            }
        }
        return symptoms;
    }






    public List<String> getContainingSymptoms(String input) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<RatioItem> rList = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("00.0");
        String[] dataTokens = Tokenizer.tokenize(input);
        for (SymptomItem item : symptomItems) {
            double matchRatio = TokenIntersect.getMatchRatio(Tokenizer.tokenize(item.symptom), dataTokens);
            if (matchRatio > 0.5) {
                rList.add(new RatioItem(matchRatio, df.format((100 * matchRatio)) + "% " + item.symptom));
            }
        }
        if (!rList.isEmpty()) {
            Collections.sort(rList);
            Collections.reverse(rList);
            for (RatioItem item : rList) {
                list.add(item.symptom);
            }
        }
        return list;
    }




    public class RatioItem implements Comparable<RatioItem> {

        public final double match;
        public final String symptom;






        public RatioItem(double match, String symptom) {
            this.match = match;
            this.symptom = symptom;
        }






        @Override
        public int compareTo(RatioItem o) {
            return Double.compare(match, o.match);
        }

    }


}

