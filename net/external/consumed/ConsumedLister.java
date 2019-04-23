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
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;





/**
 *
 * @author DaanM
 */
public class ConsumedLister {

    public static final String BASE = "https://consumed.nl";
    public static final String CAT = "/ziektebeelden/?term=";
    public static final String[] CATVALS = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "z"};





    public static void main(String[] args) {
        List<Href> list = getConsumedLinkList();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).name + ";" + list.get(i).href);
        }
    }





    public static URL createCatUrl(String catval) {
        String path = BASE + CAT + catval;
        try {
            return new URL(path);
        } catch (Exception e) {
        }
        return null;
    }





    public static Document getDoc(URL url) {
        try {
            return Jsoup.parse(url, 5000);
        } catch (Exception e) {
            System.out.println("Cannot make document for " + url.getPath());
            return null;
        }
    }





    public static List<Href> getPages(Document doc) {
        List<Href> pageList = new ArrayList<>();
        if (doc == null) {
            System.out.println("doc == null, cannot return pages");
            return pageList;
        }
        Elements elements = doc.getElementsByClass("page-numbers");
        for (Element element : elements) {
            String href = element.attr("href");
            if (href != null) {
                String name = element.text();
                pageList.add(new Href(name, BASE + "/ziektebeelden/" + href));
            }
        }
        return pageList;
    }





    public static List<Href> getResults(Document doc) {
        List<Href> list = new ArrayList<>();
        Element element = doc.getElementById("results");
        Elements elements = element.getElementsByAttribute("href");
        for (Element e : elements) {
            String name = e.text();
            String testName = name.replaceAll("\\d", "");
            if (testName.length() > 1) {
                String href = BASE + e.attr("href");
                Href item = new Href(name, href);
                list.add(item);
            }
        }
        return list;
    }





    public static List<Href> getAllPageResults(int catvalIndex) {
        URL url = createCatUrl(CATVALS[catvalIndex]);
        Document page1 = getDoc(url);
        List<Href> pageList = getPages(page1);
        ArrayList<Href> resultList = new ArrayList<>();
        for (int i = 0; i < pageList.size(); i++) {
            try {
                URL pageUrl = new URL(pageList.get(i).href);
                Document page = getDoc(pageUrl);
                List<Href> list = getResults(page);
                for (Href item : list) {
                    resultList.add(item);
                }
            } catch (Exception e) {
            }
        }
        return resultList;
    }





    public static List<Href> getConsumedLinkList() {
        ArrayList<Href> consumedList = new ArrayList<>();
        for (int i = 0; i < CATVALS.length; i++) {
            List<Href> list = getAllPageResults(i);
            for (int j = 0; j < list.size(); j++) {
                consumedList.add(list.get(j));
            }
        }
        return consumedList;
    }





}
