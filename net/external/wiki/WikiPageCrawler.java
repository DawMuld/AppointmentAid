/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.external.wiki;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;





/**
 *
 * @author DaanM
 */
public class WikiPageCrawler {
    
    public static void main(String[] args){
        WikiLink link = WikiList.getWikiLinkList().get(1);
        processWikiPage(WikiPageLoader.getInstance().getWikiDocument(link));
    }
    
    public static void processWikiPage(Document doc){
        Elements headlines = doc.getElementsByClass("mw-headline");
        for(Element headline:headlines){
            System.out.println("node name: " + headline.nodeName());
            System.out.println("text     : " + headline.text());
            System.out.println("has next : " + headline.nextElementSibling() != null);
            Element pointer = headline;
            int count = 0;
            while(pointer != null && count < 10){
                System.out.println(count + " sibbling " + pointer.tagName() + " " + pointer.className() + " " + pointer.text());
                pointer = pointer.nextElementSibling();
                count++;
            }
        }
                
            
        }
    
}
