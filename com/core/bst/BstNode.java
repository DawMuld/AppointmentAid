/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.bst;
/**
 *
 * @author daanm
 */
public class BstNode implements Comparable<String> {

    private String word;
    private int freq;
    public BstNode left;
    public BstNode right;





    public BstNode(String word) {
        this.word = word;
        freq = 0;
        left = right = null;
    }





    public void visit() {
        freq++;
    }





    public int freq() {
        return freq;
    }





    public String word() {
        return word;
    }





    @Override
    public int compareTo(String o) {
        return word.compareTo(o);
    }





}
