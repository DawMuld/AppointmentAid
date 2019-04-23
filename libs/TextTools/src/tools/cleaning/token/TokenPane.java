/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.cleaning.token;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import resources.fonts.Fonts;





/**
 *
 * @author DaanM
 */
public class TokenPane extends BorderPane {

    private TokenSet tokenSet;
    private ListView<String> invalidTokenList;
    private ListView<String> validTokenList;
    private Button invalidateButton;
    private Button validateButton;





    public TokenPane() {
        super();
        tokenSet = new TokenSet();
        invalidTokenList = tokenSet.createInvalidTokenListView();
        validTokenList = tokenSet.createValidTokenListView();
        invalidateButton = new Button("Invalidate");
        validateButton = new Button("Validate");
        TitledPane tp1 = new TitledPane("Valid Tokens", validTokenList);
        TitledPane tp2 = new TitledPane("Invalid Tokens", invalidTokenList);
        tp1.setFont(Fonts.title(22));
        tp2.setFont(Fonts.title(22));
        setLeft(tp1);
        setRight(tp2);
        FlowPane buttonPane = new FlowPane();
        buttonPane.setPadding(new Insets(6));
        buttonPane.setAlignment(Pos.CENTER);
        buttonPane.getChildren().addAll(invalidateButton, validateButton);
        setCenter(buttonPane);
        invalidateButton.setOnAction((event) -> {
            List<String> items = validTokenList.getSelectionModel().getSelectedItems();
            if (!items.isEmpty()) {
                for (int i = items.size() - 1; i >= 0; i--) {
                    tokenSet.invalidate(items.get(i));
                }
            }
        });
        validateButton.setOnAction((event) -> {
            List<String> items = invalidTokenList.getSelectionModel().getSelectedItems();
            if (!items.isEmpty()) {
                for (int i = items.size() - 1; i >= 0; i--) {
                    tokenSet.validate(items.get(i));
                }
            }
        });
        FlowPane bottomPane = new FlowPane();
        bottomPane.setAlignment(Pos.BASELINE_RIGHT);
        bottomPane.setHgap(8);
        bottomPane.setVgap(8);
        bottomPane.setPadding(new Insets(8));
        Button saveButton = new Button("Save");
        saveButton.setOnAction((event) -> {
            Platform.runLater(() -> {
                save();
            });
        });
        setBottom(bottomPane);
        bottomPane.getChildren().add(saveButton);
        saveButton.setFont(Fonts.regular(18));
    }





    public void addTokens(String[] tokens) {
        tokenSet.insertTokenData(tokens);
    }





    private void save() {
        try {
            File file = new File(System.getProperty("user.dir") + "\\src\\resources\\token_filter_list.txt");
            file.createNewFile();
            PrintWriter writer = new PrintWriter(new FileWriter(file));
            Iterator<String> i = tokenSet.invalidTokenIterator();
            while (i.hasNext()) {
                writer.println(i.next());
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("Save error.... whoeps");
        }
        try {
            File file = new File(System.getProperty("user.dir") + "\\src\\resources\\token_target_list.txt");
            file.createNewFile();
            PrintWriter writer = new PrintWriter(new FileWriter(file));
            Iterator<String> i = tokenSet.validTokenIterator();
            while (i.hasNext()) {
                writer.println(i.next());
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println("Save error.... whoeps");
        }
    }





}
