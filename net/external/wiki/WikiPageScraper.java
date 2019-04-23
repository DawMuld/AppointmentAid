/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.external.wiki;

import com.analysis.StringNormalizer;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.external.gen.Paragraph;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;





/**
 *
 * @author DaanM
 */
public class WikiPageScraper {

    private static List<WikiLink> wikiList;





    public static void main(String[] args) {
        List<WikiLink> links = getWikiList();
        List<String> list = new ArrayList<>();
        for (WikiLink link : links) {
            List<String> content = getHeaderContent(link, "Symptomen[bewerken]");
            if (content != null) {
                String txt = "[" + link.name + "]\n";
                for (String item : content) {
                    txt += item + "\n";
                }
                list.add(txt);
            }
        }
        System.out.println("Listsize: " + list.size() + "\tdesired size: 156");
        System.out.println("\n\n\n");
        for (String q : list) {
            System.out.println(StringNormalizer.normalizeToLines(q));
            System.out.println("\n");
        }
    }





    public static List<Paragraph> getWikiParagraphs(WikiLink wikiLink) {
        List<Paragraph> list = new ArrayList<>();
        Document doc = getWikiDoc(wikiLink);
        List<String> headers = getH2Headers(wikiLink);
        for (String header : headers) {
            List<String> contentList = getHeaderContent(wikiLink, header);
            String content = "";
            for (String contentItem : contentList) {
                content += StringNormalizer.normalizeToLines(contentItem);
                content += "\n";
            }
            Paragraph paragraph = new Paragraph(header.replace("\\[bewerken\\]", ""), content);
            list.add(paragraph);
        }
        return list;
    }





    public static List<WikiLink> getWikiList() {
        if (wikiList == null) {
            synchronized (WikiPageScraper.class) {
                if (wikiList == null) {
                    wikiList = WikiList.getWikiLinkList();
                }
            }
        }
        return wikiList;
    }





    public static List<String> getHeaderContent(WikiLink link, String h2Header) {
        Document doc = getWikiDoc(link);
        if (doc == null) {
            return null;
        }
        Elements h2Nodes = doc.getElementsByTag("h2");
        for (Element h2Node : h2Nodes) {
            if (h2Node.text().equalsIgnoreCase(h2Header)) {
                List<String> list = new ArrayList<>();
                Element pointer = h2Node;
                while (pointer.nextElementSibling() != null) {
                    pointer = pointer.nextElementSibling();
                    if (pointer.tagName().equals("p")) {
                        list.add(pointer.text());
                    }else if(pointer.tagName().equals("li")){
                        list.add("\t" + pointer.text());
                    } else {
                        
                        if (pointer.tagName().equals("h2")) {
                            break;
                        }
                        if(pointer.hasText()){
                            list.add(pointer.text());
                        }
                        
                    }
                }
                return list;
            }
        }
        return null;
    }





    public static List<String> getH1Headers(WikiLink link) {
        List<String> headers = new ArrayList<>();
        Document doc = getWikiDoc(link);
        Elements elements = doc.getElementsByTag("h1");
        for (Element element : elements) {
            headers.add(element.text());
        }
        return headers;
    }





    public static List<String> getH2Headers(WikiLink link) {
        List<String> headers = new ArrayList<>();
        Document doc = getWikiDoc(link);
        if (doc == null) {
            return headers;
        }
        Elements elements = doc.getElementsByTag("h2");
        for (Element element : elements) {
            String txt = element.text().replace("[bewerken]", "");
            headers.add(txt);
        }
        return headers;
    }





    public static List<String> getH3Headers(WikiLink link) {
        List<String> headers = new ArrayList<>();
        Document doc = getWikiDoc(link);
        Elements elements = doc.getElementsByTag("h3");
        for (Element element : elements) {
            headers.add(element.text());
        }
        return headers;
    }





    private static Document getWikiDoc(WikiLink link) {
        try {
            URL url = new URL(link.href);
            Document doc = Jsoup.parse(url, 5000);
            return doc;
        } catch (Exception e) {
        }
        return null;
    }
    
    





}
