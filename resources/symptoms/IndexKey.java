/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.symptoms;

import java.util.List;





/**
 * Represents a distinct word that originates from the symptoms database, and the list of indices for each symptom in the database that contains the
 * key. When raw input is categorized, it first will be compared to a list of index keys. For every IndexKey that occurs in the input text, the
 * associated indexes will be used to compare to. Every associated index refers to a symptom description that is likely to match at least partially
 * with the input data.
 *
 * For all symptoms that are computed to be associated with the input, further investigation will be executed to determine a classification.
 *
 * @author daanm
 */
public class IndexKey {

    public final String key;
    public final int[] indices;






    public IndexKey(String key, List<Integer> indexList) {
        this.key = key;
        this.indices = new int[indexList.size()];
        for (int i = 0; i < indexList.size(); i++) {
            indices[i] = indexList.get(i);
        }
    }






    public IndexKey(String key, int[] indices) {
        this.key = key;
        this.indices = indices;
    }






    public String toLine() {
        String line = key;
        for (int index : indices) {
            line += ";" + String.valueOf(index);
        }
        return line;
    }


}



