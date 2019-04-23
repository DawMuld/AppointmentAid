/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.search;
/**
 *
 * @author DaanM
 */
public class Content {

    private String title;
    private String content;





    public Content() {
        title = "";
        content = "";
    }





    public Content(String title, String content) {
        this.title = title;
        this.content = content;
    }





    public String getTitle() {
        return title;
    }





    public void setTitle(String title) {
        this.title = title;
    }





    public String getContent() {
        return content;
    }





    public void setContent(String content) {
        this.content = content;
    }





    public void appendContent(String content) {
        this.content += "\n" + content;
    }





    @Override
    public String toString() {
        return title + "\n" + content;
    }





}
