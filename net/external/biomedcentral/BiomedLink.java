/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.external.biomedcentral;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;





/**
 *
 * @author daanm
 */
public class BiomedLink {

    private final Document doc;






    public BiomedLink(String articleUrl) {
        try {
            doc = Jsoup.connect(articleUrl).get();
        } catch (IOException e) {
            throw new IllegalArgumentException();
        }
    }
    
    
    
    public String getArticleTitle(){
        Elements elements = doc.getElementsByClass("ArticleTitle");
        if(elements != null){
            return elements.get(0).text();
        }
        return "";
    }
    
    
    public String[] getAuthors(){
        Elements elements = doc.getElementsByAttributeValue("data-test", "author-name");
        String[] names = new String[elements.size()];
        for(int i = 0 ; i < elements.size(); i++){
            names[i] = elements.get(i).text().replaceAll("\\d", "").replaceAll(",", "").replace(" and", "").trim();
        }
        return names;
    }

}



