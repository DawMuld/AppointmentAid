/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.displays;

import com.core.agenda.AgendaItem;
import com.gui.AgendaController;
import com.gui.AgendaModel;
import com.gui.AgendaObserver;
import com.gui.sidebar.SideBarDisplay;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import net.symptoms.SymptomDatabase;
import resources.img.ImgLoader;
import resources.raw.fonts.FontLoader;
import resources.raw.fonts.Roboto;




/**
 *
 * @author daanm
 */
public class SymptomDisplay extends VBox implements SideBarDisplay, AgendaObserver {

    private SymptomDatabase symDB;
    private TextArea symArea;
    private TextArea accentArea;






    public SymptomDisplay(AgendaController controller) {
        super(4);
        symDB = SymptomDatabase.getInstance();
        symArea = new TextArea();
        accentArea = new TextArea();
        Label title = new Label("Symptom Matches");
        title.setFont(FontLoader.loadSketchFont(22));
        symArea.setFont(Roboto.getRobotoFont(14));
        accentArea.setFont(Roboto.getRobotoFont(14));
        symArea.setWrapText(true);
        accentArea.setWrapText(true);
        symArea.setPrefColumnCount(30);
        symArea.setPrefRowCount(50);
        accentArea.setPrefColumnCount(30);
        getChildren().addAll(title, symArea, accentArea);
        setPadding(new Insets(16, 8, 16, 8));
        controller.getAgendaModel().addAgendaObserver(this);

    }






    private void clearSymptoms() {
        symArea.setText("");
        accentArea.setText("");
    }






    private void showSymptoms(AgendaItem item) {
        clearSymptoms();
        List<String> list = symDB.getContainingSymptoms(item.getDescription());
        if (!list.isEmpty()) {
            for (String sym : list) {
                symArea.appendText(" - " + sym + "\n");
            }
        } else {
            symArea.setText("No matches detected");
            accentArea.setText("No accents detected");
        }

    }






    @Override
    public ImageView getMenuIcon() {
        return new ImageView(ImgLoader.symptomsImage());
    }






    @Override
    public void showDisplay(BorderPane borderPane) {
        borderPane.setCenter(this);
        borderPane.autosize();
    }






    @Override
    public void agendaChanged(AgendaModel model) {
        clearSymptoms();
    }






    @Override
    public void weekChanged(AgendaModel model) {
        clearSymptoms();
    }






    @Override
    public void selectionChanged(AgendaModel model) {
        showSymptoms(model.getSelectedAgendaItem());
    }

}

