/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.external.gen;

import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;





/**
 *
 * @author DaanM
 */
public class DocBuilder {

    public static Document build(String url) {
        try {
            URL link = new URL(url);
            Document doc = Jsoup.parse(link, 5000);
            return doc;
        } catch (Exception e) {
        }
        return null;
    }





}
