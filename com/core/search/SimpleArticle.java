/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;





/**
 *
 * @author DaanM
 */
public class SimpleArticle implements Article {

    private String source;
    private String title;
    private List<Content> contentList;





    public SimpleArticle(String source, String title) {
        this.source = source;
        this.title = title;
        this.contentList = new ArrayList<>();
    }





    public SimpleArticle(String source, String title, List<Content> contentList) {
        this.source = source;
        this.title = title;
        this.contentList = contentList;
    }





    public SimpleArticle(String source, String title, Content[] contentArray) {
        this.source = source;
        this.title = title;
        this.contentList = Arrays.asList(contentArray);
    }





    @Override
    public String toString() {
        String text = title + "\n";
        for (int i = 0; i < contentSize(); i++) {
            text += contentList.get(i).toString();
            text += "\n";
        }
        text += "\n\nsource: " + source;
        return text;
    }





    @Override
    public String getSource() {
        return source;
    }





    @Override
    public String getTitle() {
        return title;
    }





    @Override
    public int contentSize() {
        return contentList.size();
    }





    @Override
    public Content get(int index) {
        return contentList.get(index);
    }





    @Override
    public Content find(String title) {
        for (int i = 0; i < contentSize(); i++) {
            Content content = contentList.get(i);
            if (content.getTitle().contains(title)) {
                return content;
            }
        }
        return null;
    }





    @Override
    public Content[] getContent() {
        Content[] array = new Content[contentSize()];
        for (int i = 0; i < contentSize(); i++) {
            array[i] = contentList.get(i);
        }
        return array;
    }





}
