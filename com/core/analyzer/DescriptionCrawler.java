/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.analyzer;

import com.core.agenda.Agenda;
import com.core.agenda.AgendaItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import com.analysis.StopWordFilter;





/**
 *
 * @author daanm
 */
public class DescriptionCrawler {

    public static String collectDescriptions(Agenda agenda) {
        Iterator<AgendaItem> iterator = agenda.iterator();
        String text = "";

        while (iterator.hasNext()) {
            text += iterator.next().getDescription();
        }
        return text;
    }






    public static String collectAndFilterDescriptions(Agenda agenda) {
        String text = collectDescriptions(agenda);
        return StopWordFilter.filterStopWords(text);
    }






    public static Set<String> getUniqueWords(Agenda agenda) {
        Set<String> set = new TreeSet<>();
        String[] words = collectAndFilterDescriptions(agenda).split("\\s");
        for (String word : words) {
            if (word.trim().length() > 1) {
                set.add(word);
            }
        }
        return set;
    }






    public static String[] tokenize(Agenda agenda) {
        return collectAndFilterDescriptions(agenda).split("\\s");
    }






    public static HashMap<String, Integer> createMap(Agenda agenda) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] words = tokenize(agenda);
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        return map;
    }






    public static ArrayList<CountedWord> getWordList(Agenda agenda) {
        HashMap<String, Integer> map = createMap(agenda);
        ArrayList<CountedWord> list = new ArrayList<>();
        Set<String> keys = map.keySet();
        Iterator<String> keyIterator = keys.iterator();
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            int count = map.get(key);
            list.add(new CountedWord(key, count));
        }
        Collections.sort(list);
        Collections.reverse(list);
        return list;
    }


}



