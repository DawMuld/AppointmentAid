/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.search;

import java.util.List;





/**
 *
 * @author DaanM
 */
public class SearchTask {
    private final List<IndexedArticle> sourceList;
    private final SearchModel searchModel;
    
    public SearchTask(List<IndexedArticle> sourceList, SearchModel searchModel){
        this.sourceList = sourceList;
        this.searchModel = searchModel;
    }
    
    
    
    
}
