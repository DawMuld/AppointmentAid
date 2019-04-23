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
public interface IndexedArticle extends Comparable<IndexedArticle> {

    public String getDisplayName();





    public String getPreviewText();





    public boolean matchTitle(String query);





    public boolean matchContent(String query);





    public boolean matchCrawler(ArticleCrawler crawler);





    public Article getArticle();





    @Override
    public default int compareTo(IndexedArticle o) {
        return this.getDisplayName().compareTo(o.getDisplayName());
    }





}
