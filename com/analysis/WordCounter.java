/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analysis;

import com.core.bst.BinarySearchTree;
import com.core.bst.WordFreq;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;





/**
 *
 * @author DaanM
 */
public class WordCounter {

    public static List<WordFreq> getWordFreqList(String text) {
        BinarySearchTree bst = new BinarySearchTree();
        String[] tokens = Tokenizer.tokenize(text);
        bst.addToTree(tokens);
        List<WordFreq> list = bst.toWordFreqList();
        Collections.sort(list);
        return list;
    }





    public static List<WordFreq> getWordFreqList(String[] tokens) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.addToTree(tokens);
        List<WordFreq> list = bst.toWordFreqList();
        Collections.sort(list);
        return list;
    }





    public static List<WordFreq> getWordFreqList(File file) {
        BinarySearchTree bst = new BinarySearchTree();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                String[] tokens = Tokenizer.tokenize(line);
                bst.addToTree(tokens);
            }
            reader.close();
        } catch (Exception e) {
        }
        List<WordFreq> list = bst.toWordFreqList();
        Collections.sort(list);
        return list;
    }





}
