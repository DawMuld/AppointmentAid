/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.external.translations;
/**
 *
 * @author daanm
 */
public class WordEntry {

    private String word;
    private String meta;
    private String info;





    public WordEntry(String word) {
        this.word = word;
    }





    public WordEntry(String word, String meta, String info) {
        this.word = word;
        this.meta = meta;
        this.info = info;
    }





    @Override
    public String toString() {
        String line = word;
        if (hasMeta()) {
            line += " " + meta;
        }
        if (hasInfo()) {
            line += " " + info;
        }
        return line;
    }





    public boolean isEmpty() {
        if (word != null) {
            return word.trim().isEmpty();
        }
        return true;
    }





    public boolean hasMeta() {
        return meta != null && !meta.isEmpty();
    }





    public boolean hasInfo() {
        return info != null && !info.isEmpty();
    }





    public String getWord() {
        return word;
    }





    public void setWord(String word) {
        this.word = word;
    }





    public String getMeta() {
        return meta;
    }





    public void setMeta(String meta) {
        this.meta = meta;
    }





    public String getInfo() {
        return info;
    }





    public void setInfo(String info) {
        this.info = info;
    }





}
