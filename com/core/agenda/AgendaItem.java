/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.agenda;

import com.core.data.Employee;
import com.core.data.Person;
import java.time.LocalDate;
import java.time.LocalDateTime;





/**
 *
 * @author daanm
 */
public class AgendaItem {

    private final AgendaTime time;
    private final Employee employee;
    private final Person patient;
    private String description;






    public AgendaItem(AgendaTime time, Employee employee, Person patient) {
        this.time = time;
        this.employee = employee;
        this.patient = patient;
    }






    @Override
    public String toString() {
        return time.toString() + " with " + patient.toString() + " at " + employee.toString() + " for " + description;
    }






    public boolean isOnDate(LocalDate ld) {
        LocalDate itemDate = time.getStartTime().toLocalDate();
        return itemDate.isEqual(ld);

    }






    public LocalDateTime getStartTime() {
        return time.getStartTime();
    }






    public LocalDateTime getEndTime() {
        return time.getEndTime();
    }






    public int getDuration() {
        return time.getDuration();
    }






    public Employee getEmployee() {
        return employee;
    }






    public Person getPatient() {
        return patient;
    }






    public void setDescription(String description) {
        this.description = description;
    }






    public String getDescription() {
        return description;
    }


}



