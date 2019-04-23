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
public class SimpleIndexedArticle implements IndexedArticle {

    private final Article article;





    public SimpleIndexedArticle(Article article) {
        this.article = article;
    }





    @Override
    public String getDisplayName() {
        return article.getTitle();
    }





    @Override
    public String getPreviewText() {
        Content content = article.get(0);
        if (content != null) {
            return content.getContent().substring(0, 100) + "...";
        }
        return "...";
    }





    @Override
    public boolean matchTitle(String query) {
        return article.getTitle().contains(query);
    }





    @Override
    public boolean matchContent(String query) {
        for (int i = 0; i < article.contentSize(); i++) {
            Content content = article.get(i);
            if (content.getTitle().contains(query)) {
                return true;
            }
            if (content.getContent().contains(query)) {
                return true;
            }
        }
        return false;
    }





    @Override
    public boolean matchCrawler(ArticleCrawler crawler) {
        return crawler.match(article);
    }





    @Override
    public Article getArticle() {
        return article;
    }





}
