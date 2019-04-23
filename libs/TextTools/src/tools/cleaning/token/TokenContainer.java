/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.cleaning.token;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;





/**
 *
 * @author DaanM
 */
public class TokenContainer {

    private final String[] tokens;





    public TokenContainer(String[] tokens) {
        this.tokens = tokens;
    }





    public TokenContainer(String text) {
        this.tokens = Tokenizer.tokenize(text);
    }





    public String toLine() {
        String line = "";
        for (String token : tokens) {
            line += token + ", ";
        }
        return line;
    }





    public int size() {
        return tokens.length;
    }





    public ObservableList<String> toObservableList() {
        ObservableList<String> list = FXCollections.observableArrayList();
        for (String token : tokens) {
            list.add(token);
        }
        return list;
    }





    public double meanTokenSize() {
        int totalSize = 0;
        for (int i = 0; i < tokens.length; i++) {
            totalSize += tokens[i].length();
        }
        return (double) ((double) totalSize / (double) size());
    }





}
