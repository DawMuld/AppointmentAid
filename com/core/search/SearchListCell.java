/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.search;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;
import resources.raw.fonts.Noto;





/**
 *
 * @author DaanM
 */
public class SearchListCell extends ListCell<IndexedArticle> {

    @Override
    public void updateItem(IndexedArticle item, boolean empty) {
        super.updateItem(item, empty);
        if (empty == false) {
            setText("");
            setGraphic(null);
        } else {
            GridPane pane = new GridPane();
            pane.setVgap(4);
            pane.setHgap(4);
            pane.setPadding(new Insets(6, 8, 4, 8));
            pane.add(createTitleLabel(item.getDisplayName()), 0, 0, 1, 1);
            pane.add(createPreviewLabel(item.getPreviewText()), 0, 1, 1, 2);
            setGraphic(pane);
        }
    }





    public static Label createTitleLabel(String title) {
        Label label = new Label(title);
        label.setBackground(Background.EMPTY);
        label.setFont(Noto.bold(22));
        label.setWrapText(true);
        label.setTextAlignment(TextAlignment.CENTER);
        return label;
    }





    public Label createPreviewLabel(String text) {
        Label label = new Label(text);
        label.setBackground(Background.EMPTY);
        label.setFont(Noto.regular(18));
        label.setWrapText(true);
        label.setTextAlignment(TextAlignment.LEFT);
        return label;
    }





}
