/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.external.consumedicine;

import java.util.ArrayList;
import java.util.List;
import net.external.gen.DocBuilder;
import net.external.gen.Href;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;





/**
 *
 * @author DaanM
 */
public class ConsumedicinePage {

    private String title;
    private List<ConsumedicineContent> contentList;





    public static ConsumedicinePage buildPage(Href href) {
        String pageTitle = href.name;
        List<ConsumedicineContent> list = new ArrayList<>();
        Document doc = DocBuilder.build(href.href);
        Element article = doc.getElementsByTag("article").first();
        String title = article.getElementsByTag("h1").first().text();
        Elements toggleTitles = article.getElementsByClass("et_pb_toggle_title");
        Elements toggleContents = article.getElementsByClass("et_pb_toggle_content");
        int size = Math.max(toggleTitles.size(), toggleContents.size());
        for (int i = 0; i < size; i++) {
            list.add(new ConsumedicineContent(toggleTitles.get(i).text(), toggleContents.get(i).text()));
        }
        return new ConsumedicinePage(pageTitle, list);
    }





    public ConsumedicinePage(String title, List<ConsumedicineContent> contentList) {
        this.title = title;
        this.contentList = contentList;
    }





    @Override
    public String toString() {
        return title.toUpperCase() + "\n" + getContentListAsString();
    }





    public String getContentListAsString() {
        String content = "";
        for (ConsumedicineContent c : contentList) {
            content += c.toString() + "\n\n";
        }
        return content;
    }





}
