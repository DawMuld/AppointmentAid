/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.external.wiki;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Service;
import javafx.concurrent.Task;




/**
 *
 * @author daan-
 */
public class WikiService extends Service<String> {

    private StringProperty wikiNameProperty = new SimpleStringProperty();






    public WikiService() {
    }






    public WikiService(String wikiName) {
        this.wikiNameProperty.set(wikiName);
    }






    public final void setWikiName(String value) {
        wikiNameProperty.set(value);
    }






    public final String getWikiName() {
        return wikiNameProperty.get();
    }






    public final StringProperty wikiNameProperty() {
        return wikiNameProperty;
    }






    @Override
    protected Task<String> createTask() {
        final String _url = getWikiName();
        return new Task<String>() {
            @Override
            protected String call()
                    throws Exception {
                String result = null;
                WikiPageLoader loader = WikiPageLoader.getInstance();
                WikiLink wiki = loader.find(_url);
                if (wiki != null) {
                    result = loader.getTextContent(wiki);
                }
                return result;
            }
        };
    }

}

