/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.analyzer;




/**
 *
 * @author daanm
 */
public class CountedWord implements Comparable<CountedWord>{
    public final String word;
    public final int count;


    public CountedWord(String word, int count){
        
        this.word = word;
        this.count = count;
    }




    @Override
    public int compareTo(CountedWord o) {
        return count-o.count;
    }
    
}



