/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules.mvc.html;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;





/**
 *
 * @author DaanM
 */
public class WebViewer extends BorderPane {

    private WebView browser;
    private WebEngine engine;





    public WebViewer() {
        super();
        browser = new WebView();
        engine = browser.getEngine();
        engine.load("https://eurjmedres.biomedcentral.com/articles");
        setCenter(browser);
    }





    @Override
    protected void layoutChildren() {
        double w = getWidth();
        double h = getHeight();
        layoutInArea(browser, 0, 0, w, h, 0, HPos.CENTER, VPos.CENTER);
    }





}
