/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.cleaning.token;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.SelectionMode;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import resources.fonts.Fonts;





/**
 *
 * @author DaanM
 */
public class TokenSet {

    private final HashSet<String> validTokenSet;
    private final HashSet<String> invalidTokenSet;
    private final ObservableList<String> validTokenList;
    private final ObservableList<String> invalidTokenList;





    public TokenSet() {
        validTokenSet = new HashSet<>();
        invalidTokenSet = new HashSet<>();
        validTokenList = FXCollections.observableArrayList();
        invalidTokenList = FXCollections.observableArrayList();
    }





    public ListView<String> createInvalidTokenListView() {
        ListView<String> listView = buildListView(invalidTokenList);
        return listView;
    }





    public ListView<String> createValidTokenListView() {
        ListView<String> listView = buildListView(validTokenList);
        return listView;
    }





    public Iterator<String> invalidTokenIterator() {
        return invalidTokenSet.iterator();
    }





    public Iterator<String> validTokenIterator() {
        return validTokenSet.iterator();
    }





    public void insertTokenData(String[] tokens) {
        for (String token : tokens) {
            if (!invalidTokenSet.contains(token) && !validTokenSet.contains(token)) {
                validTokenSet.add(token);
                validTokenList.add(token);
                validTokenList.sort((o1, o2) -> {
                    return o1.compareTo(o2);
                });
            }
        }
    }





    public void invalidate(String token) {
        if (validTokenSet.contains(token)) {
            validTokenSet.remove(token);
            validTokenList.remove(token);
            validTokenList.sort((o1, o2) -> {
                return o1.compareTo(o2);
            });
        }
        if (!invalidTokenSet.contains(token)) {
            invalidTokenSet.add(token);
            invalidTokenList.add(token);
            invalidTokenList.sort((o1, o2) -> {
                return o1.compareTo(o2);
            });
        }
    }





    public void validate(String token) {
        if (!invalidTokenSet.contains(token)) {
            invalidTokenSet.remove(token);
            invalidTokenList.remove(token);
            invalidTokenList.sort((o1, o2) -> {
                return o1.compareTo(o2);
            });
        }
        if (!validTokenSet.contains(token)) {
            validTokenSet.add(token);
            validTokenList.add(token);
            validTokenList.sort((o1, o2) -> {
                return o1.compareTo(o2);
            });
        }
    }





    private ListView<String> buildListView(ObservableList<String> items) {
        ListView<String> listView = new ListView<>(items);
        listView.setMinWidth(500);
        listView.setMinHeight(800);
        listView.setBackground(Background.EMPTY);
        listView.setPadding(new Insets(4));
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView.setCellFactory((param) -> {
            return new TokenListCell();
        });
        return listView;
    }





    public class TokenListCell extends ListCell<String> {

        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            if (empty == true) {
                setText("");
                setGraphic(null);
            } else {
                FlowPane pane = new FlowPane();
                pane.setAlignment(Pos.BASELINE_LEFT);
                pane.setPadding(new Insets(4));
                Label label = new Label(item);
                label.setFont(Fonts.regular(14));
                pane.getChildren().add(label);
                setGraphic(pane);
            }
        }





    }


}
