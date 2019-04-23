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
public interface Article {

    public String getSource();





    public String getTitle();





    public int contentSize();





    public Content get(int index);





    public Content find(String title);





    public Content[] getContent();





}
