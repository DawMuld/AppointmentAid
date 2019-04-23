/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.bst;
/**
 *
 * @author DaanM
 */
public class WordFreq implements Comparable<WordFreq> {

    public final int freq;
    public final String word;





    public WordFreq(int freq, String word) {
        this.freq = freq;
        this.word = word;
    }





    public WordFreq(BstNode node) {
        this.freq = node.freq();
        this.word = node.word();
    }





    @Override
    public int compareTo(WordFreq o) {
        return Integer.compare(o.freq, freq);
    }





}
