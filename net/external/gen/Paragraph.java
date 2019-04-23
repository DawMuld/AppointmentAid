/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.external.gen;
/**
 *
 * @author DaanM
 */
public class Paragraph {

    public final String title;
    public final String content;





    public Paragraph(String title, String content) {
        this.title = title;
        this.content = content;
    }





    @Override
    public String toString() {
        return title + "\n" + content;
    }





}
