/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.external.biomedcentral;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;





/**
 *
 * @author daanm
 */
public class SearchUrl {

    public static final String ARTICLE_PATH = "https://eurjmedres.biomedcentral.com";
    public static final String CORE_PATH = "https://eurjmedres.biomedcentral.com/articles?";
    public static final String QUERY_PATH = "query=";
    public static final String PATH_ARGS = "&volume=&searchtype=&tab=keyword";






    public static URL createSearchURL(String query) {
        String qPath = query.trim().replaceAll("\\s", "+");
        try {
            return new URL(CORE_PATH + QUERY_PATH + qPath + PATH_ARGS);
        } catch (MalformedURLException ex) {
        }
        return null;
    }






    public static void main(String[] args) {
        URL url = createSearchURL("head");
        System.out.println(url.toString());
        try {
            Document doc = Jsoup.parse(url, 5000);
            doc.normalise();
            ArrayList<String> linkList = new ArrayList<>();
            ArrayList<String> resultList =  collectResultPages(doc);
            collectFullTextHrefs(doc, linkList);
            if(resultList != null && !resultList.isEmpty()){
                for(String resultPage:resultList){
                    System.out.println("\n\t" + resultPage);
                    processResultPage(resultPage, linkList);
                }
            }
            for(int i = 0; i <10; i++){
                try{
                    Document document = Jsoup.parse(new URL(linkList.get(i)), 5000);
                    BiomedCitation citation = new BiomedCitation(document);
                    System.out.println("\n\n" + citation.toString());
                }catch(IOException e){
                   System.out.println("Cannot parse link");
                }
                
            }
            
            
        } catch (IOException ex) {
            System.out.println("Cannot parse url");
        }

    }






    public static void processResultPage(String path, ArrayList<String> linkList) {
        try {
            URL url = new URL(path);
            Document doc = Jsoup.parse(url, 5000);
            if (doc != null) {
                doc.normalise();
                collectFullTextHrefs(doc, linkList);
            }
        } catch (Exception e) {
        }

    }






    public static ArrayList<String> collectFullTextHrefs(Document doc, ArrayList<String> linkList) {
        Elements elements = doc.getElementsByAttributeValue("data-test", "fulltext-link");
        for (Element element : elements) {
            String href = ARTICLE_PATH + element.attr("href");
            linkList.add(href);
        }
        return linkList;
    }






    public static ArrayList<String> collectResultPages(Document doc) {
        ArrayList<String> pageLinks = new ArrayList<>();
        Elements elements = doc.getElementsByClass("c-pagination__link");
        for (Element element : elements) {
            String pageLink = ARTICLE_PATH + element.attr("href");
            if (pageLink.length() > ARTICLE_PATH.length() && !pageLinks.contains(pageLink)) {
                pageLinks.add(pageLink);
            }
        }
        return pageLinks;
    }


}



