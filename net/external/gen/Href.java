/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.external.gen;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;





/**
 *
 * @author DaanM
 */
public class Href {

    public final String name;
    public final String href;





    public Href(String name, String href) {
        this.name = name;
        this.href = href;
    }





    @Override
    public String toString() {
        return name + "\t" + href;
    }





    public static List<Href> getHrefList(Document doc) {
        List<Href> list = new ArrayList<>();
        Elements elements = doc.getElementsByAttribute("href");
        for (Element element : elements) {
            String href = element.attr("href");
            String name = element.text();
            if (href != null && name != null) {
                list.add(new Href(name, href));
            }
        }
        return list;
    }





}
