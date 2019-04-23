/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.sidebar;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;





/**
 *
 * @author daanm
 */
public class SideBarMenu extends VBox {

    public static final double CELL_SIZE = 32.0;






    public SideBarMenu() {
        super(4.0);
        setPadding(new Insets(4));
        setPrefWidth(CELL_SIZE);
    }






    public void addMenuItem(SideBarDisplay display, BorderPane borderPane) {
        ImageView imageView = display.getMenuIcon();
        imageView.setFitHeight(CELL_SIZE);
        imageView.setFitWidth(CELL_SIZE);
        Button button = new Button();
        button.setBackground(Background.EMPTY);
        button.setPadding(Insets.EMPTY);
        button.setGraphic(imageView);
        button.setOnAction((t) -> {
            display.showDisplay(borderPane);
        });
        button.hoverProperty().addListener((ov, t, t1) -> {
            if (t1 == true) {
                button.setEffect(new DropShadow(2, 1.5, 1.5, Color.web("#323232")));
            } else {
                button.setEffect(null);
            }

        });
        getChildren().add(button);
    }


}



