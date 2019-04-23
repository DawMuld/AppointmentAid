/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.external.wiki;

import com.analysis.StringNormalizer;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import net.external.gen.Href;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;





/**
 *
 * @author daan-
 */
public class WikiPageLoader {

    private static WikiPageLoader instance;
    private List<WikiLink> wikiList;





    public static WikiPageLoader getInstance() {
        if (instance == null) {
            synchronized (WikiPageLoader.class) {
                if (instance == null) {
                    instance = new WikiPageLoader();
                }
            }
        }
        return instance;
    }





    private WikiPageLoader() {
        wikiList = WikiList.getWikiLinkList();
    }





    public int wikiSize() {
        return wikiList.size();
    }





    public WikiLink get(int index) {
        return wikiList.get(index);
    }





    public WikiLink find(String token) {
        for (WikiLink wiki : wikiList) {
            if (wiki.match(token)) {
                return wiki;
            }
        }
        return null;
    }





    public Document getWikiDocument(WikiLink wiki) {
        try {
            URL url = new URL(wiki.href);
            Document doc = Jsoup.parse(url, 5000);
            doc.normalise();
            return doc;
        } catch (Exception e) {
        }
        return null;
    }





    public String getTextContent(WikiLink wiki) {
        Document doc = getWikiDocument(wiki);
        if (doc != null) {
            Elements elements = doc.getElementsByClass("mw-parser-output");
            if (elements != null) {
                Elements targets = elements.get(0).getElementsByTag("p");
                if (targets != null) {
                    String text = targets.text();
                    text = StringNormalizer.normalizeToLines(text);
                    text = text.replaceAll("\\[.\\]", "");
                    return text;
                }
            }
        }
        return null;
    }





}
