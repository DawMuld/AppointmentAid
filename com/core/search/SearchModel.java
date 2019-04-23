/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.search;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;





/**
 *
 * @author DaanM
 */
public class SearchModel {

    private ArrayList<SearchModelObserver> oList;
    private ObservableList<IndexedArticle> sourceList;
    private ObservableList<IndexedArticle> itemList;
    private String query;
    private ArticleCrawler crawler;





    public SearchModel() {
        oList = new ArrayList<>();
        sourceList = FXCollections.observableArrayList();
        itemList = FXCollections.observableArrayList();
        query = "";
        crawler = null;
    }





    public SearchModel(List<IndexedArticle> sourceItems) {
        oList = new ArrayList<>();
        sourceList = FXCollections.observableArrayList();
        itemList = FXCollections.observableArrayList();
        query = "";
        crawler = null;
        for (int i = 0; i < sourceItems.size(); i++) {
            sourceList.add(sourceItems.get(i));
            itemList.add(sourceItems.get(i));
        }
    }





    public void clearItemList() {
        if (!itemList.isEmpty()) {
            itemList.clear();
        }
    }





    public void showAllItems() {
        if(itemList.size() != sourceList.size()){
            clearItemList();
            sourceList.forEach((item) -> {
                itemList.add(item);
            });
        }
    }
    
    public void showArticle(IndexedArticle article){
        itemList.add(article);
    }
    
    public void showArticles(List<IndexedArticle> articles){
        articles.forEach((article) -> {
            itemList.add(article);
        });
    }
    
    public void hideArticle(IndexedArticle article){
        itemList.remove(article);
    }
    
    public void hideArticles(List<IndexedArticle> articles){
        articles.forEach((article) -> {
            itemList.remove(article);
        });
    }   
    
    

    
    




    public void registerObsever(SearchModelObserver observer) {
        oList.add(observer);
    }





    public void removeObserver(SearchModelObserver observer) {
        oList.remove(observer);
    }





    public void updateObservers() {
        if (!oList.isEmpty()) {
            for (int i = 0; i < oList.size(); i++) {
                oList.get(i).updateContent(this);
            }
        }
    }





    public ObservableList<IndexedArticle> getItems() {
        return itemList;
    }





    public String getQuery() {
        return query;
    }





    public ArticleCrawler getCrawler() {
        return crawler;
    }





}
