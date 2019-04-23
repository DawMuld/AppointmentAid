/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules.common.builders;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import resources.raw.fonts.FontLoader;
import resources.raw.fonts.Roboto;





/**
 *
 * @author DaanM
 */
public class ViewBuilder {

    public static Label createSketchyLabel(String text, double fontsize) {
        Label label = new Label(text);
        label.setFont(FontLoader.loadSketchFont(fontsize));
        label.setPadding(new Insets(4, 6, 4, 6));
        label.setWrapText(true);
        label.setBackground(createWhiteBackground());
        return label;
    }





    public static Label createRobotoLabel(String text, double fontsize) {
        Label label = new Label(text);
        label.setFont(Roboto.getRobotoMediumFont(fontsize));
        label.setPadding(new Insets(4, 6, 4, 6));
        label.setWrapText(true);
        label.setBackground(createWhiteBackground());
        return label;
    }





    public static TextField createTextField(double fontsize) {
        TextField field = new TextField();
        field.setFont(Roboto.getRobotoFont(fontsize));
        field.setPadding(new Insets(4, 6, 4, 6));
        field.setBackground(createWhiteBackground());
        return field;
    }





    public static Button createButton(String text, double fontsize) {
        Button button = new Button(text);
        button.setFont(Roboto.getRobotoBlackFont(fontsize));
        button.setBorder(new Border(new BorderStroke(Color.web("#357edd"), BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(4))));
        button.setTextFill(Color.web("#357edd"));
        button.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == true) {
                button.setBackground(createButtonBackground());
                button.setTextFill(Color.web("#FFFFFF"));
            } else {
                button.setBackground(Background.EMPTY);
                button.setTextFill(Color.web("#357edd"));
            }
        });
        button.pressedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == true) {
                button.setBackground(createButtonBackground());
                button.setTextFill(Color.web("#FFFFFF"));
            } else {
                button.setBackground(Background.EMPTY);
                button.setTextFill(Color.web("#357edd"));
            }
        });
        button.setEffect(new DropShadow(5.0, 2.5, 2.5, Color.DARKGRAY));
        return button;
    }





    public static Background createWhiteBackground() {
        return new Background(new BackgroundFill(Color.web("#FFFFFF"), CornerRadii.EMPTY, Insets.EMPTY));
    }





    public static Background createBlackBackground() {
        return new Background(new BackgroundFill(Color.web("#000000"), CornerRadii.EMPTY, Insets.EMPTY));
    }





    public static Background createButtonBackground() {
        return new Background(new BackgroundFill(Color.web("#357edd"), new CornerRadii(10), Insets.EMPTY));
    }





}
