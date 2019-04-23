/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.planner.data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import resources.planner.agenda.AgendaTime;





/**
 *
 * @author daanm
 */
public class DateExtractor {

    public static final Pattern PATTERN_1 = Pattern.compile("(\\d\\d):(\\d\\d):(\\d\\d)*");
    public static final Pattern PATTERN_2 = Pattern.compile("(\\d\\d\\d\\d)-(\\d\\d)-(\\d\\d)*");
    public static final Pattern PATTERN_3 = Pattern.compile("(\\d\\d)\\s(\\d\\d):(\\d\\d):(\\d\\d)\\s(CET|CEST)\\s(\\d\\d\\d\\d)\\s(\\d)*");





    public static LocalDate extractLocalDate(String line) {
        Matcher matcher = PATTERN_2.matcher(line);
        if (matcher.find()) {
            String dateString = line.substring(matcher.start(), matcher.end());
            String[] array = dateString.split("-");
            int year = Integer.parseInt(array[0]);
            int month = Integer.parseInt(array[1]);
            int day = Integer.parseInt(array[2]);
            return LocalDate.of(year, month, day);
        }
        return null;
    }





    public static AgendaTime parseAgendaTime(String line) {
        Matcher matcher = PATTERN_3.matcher(line);
        if (matcher.find()) {
            String portion = line.substring(matcher.start(), matcher.end());
            String monthName = line.substring(matcher.start() - 4, matcher.start());
            String[] items = portion.split(" ");
            int day = Integer.parseInt(items[0]);
            int year = Integer.parseInt(items[items.length - 2]);
            int month = resolveMonthName(monthName);
            int[] time = parseHMS(items[1]);
            LocalDateTime ldtStart = LocalDateTime.of(year, month, day, time[0], time[1], time[2]);
            int duration = Integer.parseInt(items[items.length - 1]);
            return new AgendaTime(ldtStart, duration);
        }
        return null;
    }





    private static int[] parseHMS(String timeString) {
        String[] items = timeString.split(":");
        int hour = Integer.parseInt(items[0]);
        int minute = Integer.parseInt(items[1]);
        int seconds = Integer.parseInt(items[2]);
        return new int[]{hour, minute, seconds};
    }





    private static int resolveMonthName(String monthName) {
        switch (monthName.trim()) {
            case "Jan":
                return 1;
            case "Feb":
                return 2;
            case "Mar":
                return 3;
            case "Apr":
                return 4;
            case "May":
                return 5;
            case "Jun":
                return 6;
            case "Jul":
                return 7;
            case "Aug":
                return 8;
            case "Sep":
                return 9;
            case "Oct":
                return 10;
            case "Nov":
                return 11;
            case "Dec":
                return 12;
            default:
                return 0;
        }
    }





}
