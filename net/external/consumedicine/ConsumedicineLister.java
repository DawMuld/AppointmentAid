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
import resources.consumed.ConsumedIndexLoader;





/**
 *
 * @author DaanM
 */
public class ConsumedicineLister {

    public static void main(String[] args) {
        List<Href> list = ConsumedIndexLoader.loadConsumedicineIndex();
        for(int i = 0; i < 20; i++){
            ConsumedicinePage page = ConsumedicinePage.buildPage(list.get(i));
            System.out.println(page.toString());
        }
    }





    public static List<Href> getConsumedicineLinkList() {
        List<Href> linkList = new ArrayList<>();
        String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        for (int letterIndex = 0; letterIndex < letters.length; letterIndex++) {
            List<Href> pageList = getPages(letters[letterIndex]);
            for (int pageIndex = 0; pageIndex < pageList.size(); pageIndex++) {
                Href pageRef = pageList.get(pageIndex);
                List<Href> resultList = getResults(pageRef);
                for (int resultIndex = 0; resultIndex < resultList.size(); resultIndex++) {
                    linkList.add(resultList.get(resultIndex));
                }
            }
        }
        return linkList;
    }





    public static List<Href> getResults(Href pageRef) {
        List<Href> resultList = new ArrayList<>();
        Document doc = DocBuilder.build(pageRef.href);
        Element results = doc.getElementsByClass("resultaten").first();
        Elements elements = results.getElementsByAttribute("href");
        for (Element element : elements) {
            String name = element.text();
            if (element.text().replaceAll("\\d", "").length() > 1) {
                String href = "https://consumed.nl" + element.attr("href");
                resultList.add(new Href(name, href));
            }
        }
        return resultList;
    }





    public static List<Href> getPages(String letter) {
        List<Href> pageList = new ArrayList<>();
        String url = "https://consumed.nl/medicijnen-az/?suggestion=" + letter.toUpperCase();
        Document doc = DocBuilder.build(url);
        Elements elements = doc.getElementsByClass("page-numbers");
        for (Element element : elements) {
            String number = element.text();
            if (number != null) {
                number = number.replaceAll("\\D", "");
                if (number.length() > 0) {
                    Href href = new Href(element.text(), "https://consumed.nl/medicijnen-az/" + element.attr("href"));
                    pageList.add(href);
                }
            }
        }
        return pageList;
    }





}
