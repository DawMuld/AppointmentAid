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
public class Employee extends Person {

    private final String id;






    public Employee(String initials, String lastName, String id) {
        super(initials, lastName);
        this.id = id;
    }






    public String getId() {
        return id;
    }


}



