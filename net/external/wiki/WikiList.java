/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.external.wiki;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;





/**
 *
 * @author daan-
 */
public class WikiList {

    public static final String PATH = "https://nl.wikibooks.org/wiki/Geneeskunde/Lijst_van_aandoeningen";





    public static void main(String[] args) {
        List<String> list = getDiseaseList();
        for (String item : list) {
            System.out.println(item);
        }
    }





    public static List<WikiLink> getWikiLinkList() {
        List<WikiLink> list = new ArrayList<>();
        try {
            URL url = new URL(PATH);
            Document doc = Jsoup.parse(url, 5000);
            Elements elements = doc.getElementsByClass("extiw");
            for (Element element : elements) {
                String href = element.attr("href");
                if (href != null && href.contains("https://nl.wikipedia.org/wiki/")) {
                    list.add(new WikiLink(element.text(), element.attr("href")));
                }
            }
        } catch (Exception e) {
        }
        return list;
    }





    public static List<String> getDiseaseList() {
        List<String> list = new ArrayList<>();
        try {
            URL url = new URL(PATH);
            Document doc = Jsoup.parse(url, 5000);
            Elements elements = doc.getElementsByClass("extiw");
            for (Element element : elements) {
                String href = element.attr("href");
                if (href != null && href.contains("https://nl.wikipedia.org/wiki/")) {
                    list.add(element.text());
                }
            }
        } catch (Exception e) {
        }
        return list;
    }





    public static List<String> getDiseaseHrefList() {
        List<String> list = new ArrayList<>();
        try {
            URL url = new URL(PATH);
            Document doc = Jsoup.parse(url, 5000);
            Elements elements = doc.getElementsByClass("extiw");
            for (Element element : elements) {
                String href = element.attr("href");
                if (href != null && href.contains("https://nl.wikipedia.org/wiki/")) {
                    list.add(element.attr("href"));
                }
            }
        } catch (Exception e) {
        }
        return list;
    }





}
