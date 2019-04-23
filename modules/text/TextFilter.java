/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules.text;

import com.analysis.Tokenizer;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import resources.stopwords.StopwordLoader;





/**
 *
 * @author DaanM
 */
public class TextFilter {

    private HashSet<String> filterSet;





    public static TextFilter stopWordFilter() {
        List<String> filterList = StopwordLoader.loadStopWordsNL();
        return new TextFilter(filterList);
    }





    public TextFilter(List<String> filterList) {
        this.filterSet = new HashSet<String>();
        for (String item : filterList) {
            filterSet.add(item);
        }
    }





    public String applyFilter(String input) {
        String[] tokens = Tokenizer.tokenize(input);
        String output = "";
        for (String token : tokens) {
            if (!filterSet.contains(token)) {
                output += "\n" + token;
            }
        }
        return output;
    }





}
