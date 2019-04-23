/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.external.consumed;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import net.external.gen.Href;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import resources.consumed.ConsumedIndexLoader;





/**
 *
 * @author DaanM
 */
public class ConsumedScraper {

    private static List<Href> indexList;





    public static void main(String[] args) {
        List<Href> iList = getIndexList();
        List<ConsumedPage> pages = new ArrayList<>();
        for (int i = 50; i < 100; i++) {
            pages.add(ConsumedPage.create(iList.get(i)));
        }
        for (ConsumedPage page : pages) {
            System.out.println(page.toString());
        }
    }





    public static List<Href> getIndexList() {
        if (indexList == null) {
            indexList = ConsumedIndexLoader.loadConsumedIndex();
        }
        return indexList;
    }





    public static Element getContentElement(Href link) {
        try {
            URL url = new URL(link.href);
            Document doc = Jsoup.parse(url, 5000);
            Elements elements = doc.getElementsByTag("article");
            return elements.first();
        } catch (Exception e) {
        }
        return null;
    }





    public static void printContentElement(Href link) {
        Element element = getContentElement(link);
        if (element != null) {
            Elements elements = element.getAllElements();
            for (Element child : elements) {
                printElementDetails(child);
            }
        }
    }





    public static void printElementDetails(Element element) {
        String tagname = element.tagName();
        String classname = element.className();
        List<Attribute> attrList = element.attributes().asList();
        String text = element.ownText();
        if (text.length() > 100) {
            text = text.substring(0, 100) + "...";
        }
        System.out.println("tag name   : " + tagname);
        System.out.println("class name : " + classname);
        System.out.println("attributes : ");
        for (Attribute attr : attrList) {
            if (!attr.getKey().equals("class")) {
                System.out.println("\t\tname=" + attr.getKey() + ", value=" + attr.getValue());
            }
        }
        System.out.println("text       : " + text);
        System.out.println("______________________________________________________________________________________________________________________");
    }





}
