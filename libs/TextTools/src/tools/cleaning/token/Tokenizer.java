/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.cleaning.token;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import resources.planner.agenda.Agenda;
import resources.planner.agenda.AgendaItem;
import resources.planner.builder.PlannerBuilder;





/**
 *
 * @author DaanM
 */
public class Tokenizer {

    public static void main(String[] args) {
        Agenda agenda = PlannerBuilder.buildFromResource(0).getLargestAgenda();
        Iterator<AgendaItem> it = agenda.iterator();
        List<TokenContainer> setList = new ArrayList<>();
        while (it.hasNext()) {
            AgendaItem item = it.next();
            String input = item.getDescription();
            TokenContainer ts = new TokenContainer(tokenize(input));
            setList.add(ts);
        }
        System.out.println("size    mean token size");
        int totalSize = 0;
        double totalMeansize = 0.0;
        for (TokenContainer set : setList) {
            System.out.println(set.size() + "\t" + set.meanTokenSize());
            totalSize += set.size();
            totalMeansize += set.meanTokenSize();
        }
        double m1 = (double)totalSize/(double)setList.size();
        double m2 = totalMeansize/(double)setList.size();
        System.out.println("Average amount of tokens in a description: " + m1);
        System.out.println("Average amount of chars in a token       : " + m2);
        
        List<Double> tokenDeviations = new ArrayList<>();
        List<Double> charDeviations = new ArrayList<>();
        for(int i = 0; i < setList.size(); i++){
            double dToken = Math.sqrt(Math.pow((setList.get(i).size() - m1), 2));
            double dChar = Math.sqrt(Math.pow((setList.get(i).size() - m2), 2));
            tokenDeviations.add(dToken);
            charDeviations.add(dChar);
        }
        double stdevTokens = 0.0;
        double stdevChars = 0.0;
        for(int i = 0; i < tokenDeviations.size(); i++){
            stdevTokens += tokenDeviations.get(i);
            stdevChars += charDeviations.get(i);
        }
        stdevTokens/= (double)(tokenDeviations.size() -1);
        stdevChars/=(double)(charDeviations.size() -1);
        System.out.println("stdev tokens: \t" + stdevTokens);
        System.out.println("stdev chars : \t" + stdevChars);
        
    }





    public static final String[] tokenize(String input) {
        input = input.replaceAll("\\p{Punct}", " ");
        input = input.replaceAll("\\p{Digit}", " ");
        input = input.toLowerCase();
        input = input.replaceAll("\\s+", " ");
        String[] tokens = input.split("\\s");
        return tokens;
    }





}
