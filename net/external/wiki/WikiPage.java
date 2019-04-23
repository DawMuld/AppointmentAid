/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.external.wiki;

import java.util.List;
import net.external.gen.Paragraph;





/**
 *
 * @author DaanM
 */
public class WikiPage {

    public final WikiLink wikiLink;
    public final List<Paragraph> paragraphs;





    public static WikiPage create(WikiLink wikiLink) {
        List<Paragraph> list = WikiPageScraper.getWikiParagraphs(wikiLink);
        return new WikiPage(wikiLink, list);
    }





    public WikiPage(WikiLink wikiLink, List<Paragraph> paragraphs) {
        this.wikiLink = wikiLink;
        this.paragraphs = paragraphs;
    }





    @Override
    public String toString() {
        String header = wikiLink.name + "\t[" + wikiLink.href + "]\n";
        String content = "";
        content = paragraphs.stream().map((paragraph) -> "\n" + paragraph).reduce(content, String::concat);
        return header + content;
    }





}
