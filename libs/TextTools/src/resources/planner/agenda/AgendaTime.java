/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.planner.agenda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;





/**
 *
 * @author daanm
 */
public class AgendaTime implements Comparable<AgendaTime> {

    private static final DateTimeFormatter DTF_DATE = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter DTF_TIME = DateTimeFormatter.ofPattern("HH:mm:ss");

    private final LocalDateTime start;
    private final LocalDateTime end;
    private final int duration;






    public AgendaTime(LocalDateTime start, int duration) {
        this.start = start;
        this.end = start.plusMinutes((long) duration);
        this.duration = duration;
    }






    @Override
    public String toString() {
        return duration + " min appointment on " + DTF_DATE.format(start) + " from " + DTF_TIME.format(start) + " to " + DTF_TIME.format(end);
    }






    public LocalDateTime getStartTime() {
        return start;
    }






    public LocalDateTime getEndTime() {
        return end;
    }






    public int getDuration() {
        return duration;
    }






    @Override
    public int compareTo(AgendaTime o) {
        return start.compareTo(o.getStartTime());
    }


}



