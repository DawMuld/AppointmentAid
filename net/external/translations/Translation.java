
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.external.translations;

import java.util.ArrayList;
import java.util.List;





/**
 *
 * @author daanm
 */
public class Translation {

    private String query;
    private List<TranslationResult> results;





    public Translation(String query) {
        this.query = query;
        results = Translator.translate(query);
    }





    public String getQuery() {
        return query;
    }





    public List<TranslationResult> getResultList() {
        return results;
    }





    public TranslationResult getResult(int index) {
        return results.get(index);
    }





    public int size() {
        return results.size();
    }





    @Override
    public String toString() {
        String text = "\nQUERY: " + query + "\n";
        for (TranslationResult result : results) {
            if (!result.isEmpty()) {
                text += "\n\tSOURCE:\t" + result.sourceString();
                text += "\n\tTARGET:\t" + result.targetString() + "\n";
            }
        }
        return text;
    }





}
