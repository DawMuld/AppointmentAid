/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules.mvc.wiki.nl;

import com.analysis.StringNormalizer;
import java.util.List;
import net.external.wiki.WikiLink;
import net.external.wiki.WikiPage;
import net.external.wiki.WikiPageLoader;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;





/**
 *
 * @author DaanM
 */
public class WikiController {

    private WikiPage wikiPage;
    private WikiView view;





    public WikiController(WikiView view) {
        this.view = view;
    }





    public void showWikiPage(WikiLink wikiLink) {
        view.clearContent();
        view.setTitle(wikiLink.name);
        Document doc = WikiPageLoader.getInstance().getWikiDocument(wikiLink);
        Elements elements = doc.body().getAllElements();
        for (Element element : elements) {
            if (element.hasText()) {
                String tagname = element.tagName();
                if (tagname.equals("h2")) {
                    if (element.text().contains("bewerken")) {
                        view.addHeader(element.text());
                    }
                } else if (tagname.equals("p")) {
                    view.addPlain(element.text());
                }
            }
        }
    }





}
