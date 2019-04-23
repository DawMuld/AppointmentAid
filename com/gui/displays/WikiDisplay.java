/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.displays;

import com.analysis.Tokenizer;
import com.core.agenda.AgendaItem;
import com.gui.AgendaController;
import com.gui.AgendaModel;
import com.gui.AgendaObserver;
import com.gui.sidebar.SideBarDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import net.external.wiki.WikiLink;
import net.external.wiki.WikiPageLoader;
import net.external.wiki.WikiService;
import resources.img.ImgLoader;
import resources.raw.fonts.Roboto;




/**
 *
 * @author daan-
 */
public class WikiDisplay extends BorderPane implements SideBarDisplay, AgendaObserver {

    private final Label titleLabel;
    private final TextArea contentArea;
    private final Image iconImage;
    private WikiPageLoader pageLoader;






    public WikiDisplay(AgendaController controller) {
        super();
        titleLabel = new Label("-");
        titleLabel.setFont(Roboto.getRobotoMediumFont(18));
        contentArea = new TextArea();
        contentArea.setFont(Roboto.getRobotoFont(14));
        contentArea.setWrapText(true);
        contentArea.setPrefRowCount(30);
        contentArea.setPrefColumnCount(20);
        iconImage = ImgLoader.wikiImage();
        pageLoader = WikiPageLoader.getInstance();
        super.setTop(titleLabel);
        super.setCenter(contentArea);
        controller.getAgendaModel().addAgendaObserver(this);

    }






    @Override
    public ImageView getMenuIcon() {
        return new ImageView(iconImage);
    }






    @Override
    public void showDisplay(BorderPane borderPane) {
        borderPane.setCenter(this);
    }






    @Override
    public void agendaChanged(AgendaModel model) {
        titleLabel.setText("");
        contentArea.setText("");
    }






    @Override
    public void weekChanged(AgendaModel model) {
        titleLabel.setText("");
        contentArea.setText("");
    }






    @Override
    public void selectionChanged(AgendaModel model) {
        AgendaItem item = model.getSelectedAgendaItem();
        if (item != null) {
            String[] tokens = Tokenizer.tokenize(item.getDescription());
            for (String token : tokens) {
                WikiLink wiki = pageLoader.find(token);
                if (wiki != null) {
                    WikiService service = new WikiService(wiki.name);
                    service.setOnSucceeded((event) -> {
                        String text = (String) event.getSource().getValue();
                        titleLabel.setText(wiki.name);
                        contentArea.setText(text);
                    });
                    titleLabel.setText("");
                    contentArea.setText("Loading content...");
                    service.start();
                }
            }

        }

    }
}

