/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.external.consumedicine;
/**
 *
 * @author DaanM
 */
public class ConsumedicineContent {

    public final String header;
    public final String content;





    public ConsumedicineContent(String header, String content) {
        this.header = header;
        this.content = content;
    }





    @Override
    public String toString() {
        return header.toUpperCase() + "\n" + content;
    }





}
