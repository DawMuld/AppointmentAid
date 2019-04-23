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
public class ConsumedPage {

    private String title;
    private String content;
    private List<String> headers;
    private List<Href> links;





    public static ConsumedPage create(Href href) {
        try {
            URL url = new URL(href.href);
            Document doc = Jsoup.parse(url, 5000);
            Element article = doc.getElementsByTag("article").first();
            String title = article.getElementsByTag("h1").first().text();
            String content = article.getElementsByClass("et_pb_column et_pb_column_4_4  et_pb_column_0 et_pb_css_mix_blend_mode_passthrough").first().text();
            List<String> headers = new ArrayList<>();
            Elements ems = article.getElementsByTag("em");
            if (!ems.isEmpty()) {
                for (Element em : ems) {
                    headers.add(em.text());
                }
            }
            List<Href> links = new ArrayList<>();
            Elements hrefs = article.getElementsByAttribute("href");
            if (!hrefs.isEmpty()) {
                for (Element ref : hrefs) {
                    links.add(new Href(ref.text(), "https://consumed.nl" + ref.attr("href")));
                }
            }
            return new ConsumedPage(title, content, headers, links);
        } catch (Exception e) {
        }
        return null;
    }





    public ConsumedPage(String title, String content, List<String> headers, List<Href> links) {
        this.title = title;
        this.content = content;
        this.headers = headers;
        this.links = links;
    }





    @Override
    public String toString() {
        return title.toUpperCase() + "\n" + content + "\n" + "HEADERS:\n" + getHeadersAsLine() + "\nLINKS:\n" + getLinksAsLine() + "\n\n\n";
    }





    public String getHeadersAsLine() {
        String line = "";
        if (!headers.isEmpty()) {
            for (String header : headers) {
                line += "\t" + header + "\n" ;
            }
        }
        return line;
    }





    public String getLinksAsLine() {
        String line = "";
        if (!links.isEmpty()) {
            for (Href link : links) {
                line += "\t" + link.name + "@[" + link.href + "]\n";
            }
        }
        return line;
    }





}
