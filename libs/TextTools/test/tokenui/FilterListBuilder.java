/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenui;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import resources.planner.agenda.Agenda;
import resources.planner.agenda.AgendaItem;
import resources.planner.builder.PlannerBuilder;
import tools.cleaning.token.TokenContainer;
import tools.cleaning.token.Tokenizer;





/**
 *
 * @author DaanM
 */
public class FilterListBuilder extends Application {

    public static void main(String[] args) {
        launch(args);
    }





    private ListView<TokenContainer> setListView;
    private ListView<String> tokenListView;
    private ListView<String> filterListView;





    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane root = new BorderPane();
        ObservableList<TokenContainer> tokenSetList = FXCollections.observableArrayList();
        Agenda agenda = PlannerBuilder.buildFromResource(0).getLargestAgenda();
        for (int i = 0; i < agenda.size(); i++) {
            AgendaItem item = agenda.getItemAt(i);
            tokenSetList.add(new TokenContainer(Tokenizer.tokenize(item.getDescription())));
        }
        setListView = new ListView<>(tokenSetList);
        setListView.setCellFactory((param) -> {
            return new TokenSetListCell();
        });
        setListView.setPrefSize(500, 800);
        tokenListView = new ListView<>();
        tokenListView.setPrefSize(500, 800);
        filterListView = new ListView<>();
        filterListView.setPrefSize(500, 800);
        TitledPane tp1 = new TitledPane("TokenSets", setListView);
        TitledPane tp2 = new TitledPane("TokenLists", tokenListView);
        TitledPane tp3 = new TitledPane("FilterList", filterListView);
        setListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setSelectedSet(newValue);
            }
        });
        tokenListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                filterListView.getItems().add(newValue);
            }
        });
        Button filterButton = new Button("filter");
        filterButton.setOnAction((event) -> {
            Set<String> set = new HashSet<>();
            List<String> wordList = filterListView.getItems();
            for (String word : wordList) {
                set.add(word);
            }
            wordList.clear();
            Iterator<String> iterator = wordList.iterator();
            while (iterator.hasNext()) {
                wordList.add(iterator.next());
            }
        });
        Button deleteButton = new Button("remove");
        deleteButton.setOnAction((event) -> {
           filterListView.getItems().removeAll(filterListView.getSelectionModel().getSelectedItems());
        });
        root.setLeft(tp1);
        root.setCenter(tp2);
        root.setRight(tp3);
        FlowPane flowPane = new FlowPane(Orientation.HORIZONTAL);
        flowPane.setAlignment(Pos.BASELINE_RIGHT);
        flowPane.setPadding(new Insets(8));
        flowPane.getChildren().addAll(filterButton, deleteButton);
        root.setTop(flowPane);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }





    private void setSelectedSet(TokenContainer set) {
        if (set != null) {
            tokenListView.setItems(set.toObservableList());
        }
    }





    public class TokenSetListCell extends ListCell<TokenContainer> {

        @Override
        public void updateItem(TokenContainer item, boolean empty) {
            super.updateItem(item, empty);
            if (empty == true) {
                setGraphic(null);
                setText("");
            } else {
                GridPane pane = new GridPane();
                pane.setHgap(4);
                pane.setVgap(2);
                Label label_1 = new Label("descriptionsize: " + String.valueOf(item.size()));
                Label label_2 = new Label("tokensize: " + String.valueOf(item.meanTokenSize()));
                Label label_3 = new Label("tokens : " + item.toLine());
                label_3.setWrapText(true);
                label_3.setTextOverrun(OverrunStyle.WORD_ELLIPSIS);
                label_3.setMaxWidth(460);
                pane.add(label_1, 0, 0);
                pane.add(label_2, 0, 1);
                pane.add(label_3, 0, 2);
                pane.setBorder(new Border(new BorderStroke(Color.web("#8a8a8a"), BorderStrokeStyle.SOLID, new CornerRadii(5.4), new BorderWidths(2))));
                pane.setPadding(new Insets(5)); 
                setGraphic(pane);
            }
        }





    }


}
