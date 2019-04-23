/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules.mvc.wiki.nl;

import java.awt.TextArea;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modules.common.builders.ViewBuilder;
import net.external.wiki.WikiLink;
import net.external.wiki.WikiList;
import resources.raw.fonts.Roboto;





/**
 *
 * @author DaanM
 */
public class WikiView extends BorderPane {

    public static enum TStyle {
        TITLE, PLAIN, LIST
    };
    private Label header;
    private VBox body;
    private List<WikiText> contentList;
    private WikiController controller;
    private ListView<WikiLink> wikiList;





    public WikiView() {
        super();
        header = ViewBuilder.createSketchyLabel("None", 32);
        body = new VBox(4.0);
        contentList = new ArrayList<>();
        controller = new WikiController(this);
        wikiList = buildListView();
        setCenter(new ScrollPane(body));
        setTop(header);
        setRight(wikiList);
        setPrefWidth(1200);
        setPrefHeight(700);
        setBackground(ViewBuilder.createWhiteBackground());
        Button pb = ViewBuilder.createButton("PoinlessButton", 18);
        setBottom(pb);
    }
    
    
    

    public void clearContent(){
        contentList.clear();
        body.getChildren().clear();
        header.setText("");
    }

    public void setTitle(String title){
        header.setText(title);
    }
    
    public void addHeader(String text){
        WikiText wikiText = new WikiText(TStyle.TITLE, text);
        contentList.add(wikiText);
        Label t = createText(wikiText); 
        body.getChildren().add(t);
    }
    
    public void addPlain(String text){
        WikiText wikiText = new WikiText(TStyle.PLAIN, text);
        contentList.add(wikiText);
        Label t = createText(wikiText); 
        body.getChildren().add(t);
    }
    
    public void addList(String text){
        WikiText wikiText = new WikiText(TStyle.LIST, text);
        contentList.add(wikiText);
        Label t = createText(wikiText); 
        body.getChildren().add(t);
    }
    
    private Label createText(WikiText wikiText){
        Label label = new Label(wikiText.text);
        label.setWrapText(true);
        label.setPadding(new Insets(4));
        label.setMaxWidth(800);
        switch(wikiText.style){
            case LIST:
                label.setPadding(new Insets(4, 4, 4, 12));
                label.setFont(Roboto.getRobotoFont(13));
                return label;
            case PLAIN:
                label.setFont(Roboto.getRobotoFont(16));
                return label;
            case TITLE:
                label.setFont(Roboto.getRobotoMediumFont(22));
                return label;
        }
        return null;
    }

    
    private ListView<WikiLink> buildListView(){
        List<WikiLink> linkList = WikiList.getWikiLinkList();
        ObservableList<WikiLink> links = FXCollections.observableArrayList();
        for(WikiLink link:linkList){
            links.add(link);
        }
        ListView<WikiLink> listView = new ListView<>(links);
        listView.setCellFactory((param) -> {
            return new WikiLinkCell(); //To change body of generated lambdas, choose Tools | Templates.
        });
        listView.setPadding(new Insets(8));
        listView.setPrefWidth(300);
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            controller.showWikiPage(newValue);
        });
        return listView;
        
    }
    
    
    public class WikiLinkCell extends ListCell<WikiLink>{
        @Override
        public void updateItem(WikiLink item, boolean empty){
            super.updateItem(item, empty);
            if(empty == true){
                setText("");
                setGraphic(null);
            }else{
                setText(item.name);
                setPadding(new Insets(4));
                setFont(Roboto.getRobotoMediumFont(16));
            }
        }
    
    }



    public class WikiText {

        final TStyle style;
        final String text;





        public WikiText(TStyle style, String text) {
            this.style = style;
            this.text = text;
        }





    }


}
