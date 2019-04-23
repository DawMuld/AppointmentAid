/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.data;




/**
 *
 * @author daanm
 */
public class Person implements Comparable<Person> {

    private final String lastName;
    private final String initials;






    public Person(String initials, String lastName) {
        this.lastName = lastName;
        this.initials = initials;
    }






    @Override
    public String toString() {
        if (initials.isEmpty()) {
            return lastName;
        }
        return initials + " " + lastName;
    }






    @Override
    public int compareTo(Person o) {
        return lastName.compareTo(o.getLastName());
    }






    public boolean equals(Person person) {
        return initials.equalsIgnoreCase(person.getInitials()) && lastName.equalsIgnoreCase(person.getLastName());
    }






    public boolean equalsIgnoreInitials(Person person) {
        return lastName.equalsIgnoreCase(person.getLastName());
    }






    public String getLastName() {
        return lastName;
    }






    public String getInitials() {
        return initials;
    }


}



