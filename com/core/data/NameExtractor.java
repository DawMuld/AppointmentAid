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
public class NameExtractor {

    public static final Pattern PATTERN_1 = Pattern.compile("(by)\\s(patient):*");
    public static final Pattern PATTERN_2 = Pattern.compile("(starting)\\s(at):*");
    public static final Pattern PATTERN_3 = Pattern.compile("(and)\\s(the)\\s(employee)\\s(chosen)\\s(is):*");
    public static final Pattern PATTERN_4 = Pattern.compile("(\\d\\d\\d\\d)-(\\d\\d)-(\\d\\d)T(\\d\\d):(\\d\\d):(\\d\\d).*");
    private static final String EMPLOYEE_ID_REPLACE_PART = "nl.pharmapartners.ehealthservices.eappointment.cim.";






    public static Person extractPatient(String line) {
        String name = extractPatientName(line);
        if (name == null) {
            return null;
        }
        String initials = "";
        String lastName = name;
        String[] names = name.split("\\s");
        if (names.length > 1) {
            initials = names[0];
            lastName = name.replace(initials, "").trim();
        }
        return new Person(initials, lastName);

    }






    public static String extractPatientName(String line) {
        Matcher m1 = PATTERN_1.matcher(line);
        Matcher m2 = PATTERN_2.matcher(line);
        if (m1.find() && m2.find()) {
            String name = line.substring(m1.end(), m2.start()).replaceAll("\"", "");
            name = name.replace(",", "");
            name = name.trim();
            return name;
        }
        return null;
    }

    
    
    public static Employee extraxtEmployee(String line){
        String name = extractEmployeeName(line);
        if(name == null){
            return null;
        }
        String id = name.split("\\s")[0];
        name = name.replace(id, "").trim();
        String initials = "";
        String lastName = name;
        String[] names = name.split("\\s");
        if (names.length > 1) {
            initials = names[0].trim();
            lastName = name.replace(initials, "").trim();
        }
        return new Employee(initials, lastName, id);
    }
        





    public static String extractEmployeeName(String line) {
        Matcher m1 = PATTERN_3.matcher(line);
        Matcher m2 = PATTERN_4.matcher(line);
        if (m1.find() && m2.find()) {
            String portion = line.substring(m1.end(), m2.start()).replaceAll("\"", "").trim();
            portion = portion.replace("null", "");
            portion = portion.replace(",", "");
            portion = portion.replace(EMPLOYEE_ID_REPLACE_PART, "");
            return portion;
        }
        return null;
    }


}



