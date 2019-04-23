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
public class TranslationResult {

    private List<WordEntry> sources;
    private List<WordEntry> targets;





    public TranslationResult() {
        sources = new ArrayList<>();
        targets = new ArrayList<>();
    }





    public boolean isEmpty() {
        return sources.isEmpty() || targets.isEmpty();
    }





    public void addSource(WordEntry entry) {
        if (!entry.isEmpty()) {
            sources.add(entry);
        }
    }





    public void addTarget(WordEntry entry) {
        if (!entry.isEmpty()) {
            targets.add(entry);
        }
    }





    public WordEntry getSource(int index) {
        return sources.get(index);
    }





    public WordEntry getTarget(int index) {
        return targets.get(index);
    }





    public List<WordEntry> getSourceList() {
        return sources;
    }





    public List<WordEntry> getTargetList() {
        return targets;
    }





    public int sourceSize() {
        return sources.size();
    }





    public int targetSize() {
        return targets.size();
    }





    public String sourceString() {
        String line = "";
        for (WordEntry entry : sources) {
            line += entry.toString() + ",  ";
        }
        return line;
    }





    public String targetString() {
        String line = "";
        for (WordEntry entry : targets) {
            line += entry.toString() + ",  ";
        }
        return line;
    }





}
