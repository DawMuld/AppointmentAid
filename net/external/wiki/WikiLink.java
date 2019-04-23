/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.external.wiki;

import com.analysis.Tokenizer;




/**
 *
 * @author daan-
 */
public class WikiLink {

    public final String name;
    public final String href;






    public WikiLink(String name, String href) {
        this.name = name;
        this.href = href;
    }






    @Override
    public String toString() {
        return name + "\t" + href;
    }






    public boolean match(String token) {
        String[] nameTokens = Tokenizer.tokenize(name);
        for (String nameToken : nameTokens) {
            if (nameToken.equalsIgnoreCase(token)) {
                return true;
            }
        }
        return false;
    }

}

