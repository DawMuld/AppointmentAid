/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;








/**
 *
 * @author daanm
 */
public class DescriptionExtractor {
    public static final Pattern PATTERN_1 = Pattern.compile("(description)\\s(given)\\s(is):*");
    public static final Pattern PATTERN_2 = Pattern.compile("(and)\\s(the)\\s(employee)");
    
    
    public static String extractDescriptionString(String line){
        Matcher m1 = PATTERN_1.matcher(line);
        Matcher m2 = PATTERN_2.matcher(line);
        if(m1.find() && m2.find()){
            String description = line.substring(m1.end(), m2.start()).trim();
            description = description.replaceAll("\"", "");
            return description;
        }
        return null;
        
    }
    
    
}



