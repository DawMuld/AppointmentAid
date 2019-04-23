/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.displays;

import com.gui.AgendaController;
import com.gui.AgendaModel;
import com.gui.AgendaObserver;
import com.gui.sidebar.SideBarDisplay;
import javafx.geometry.Insets;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import modules.text.TextFilter;
import resources.img.ImgLoader;
import resources.raw.fonts.Roboto;





/**
 *
 * @author DaanM
 */
public class FilteredTextDisplay extends VBox implements SideBarDisplay, AgendaObserver {

    private TextFilter textFilter;
    private TextArea inputArea;
    private TextArea outputArea;





    public FilteredTextDisplay(AgendaController controller) {
        super();
        textFilter = TextFilter.stopWordFilter();
        inputArea = new TextArea();
        outputArea = new TextArea();
        TitledPane inputPane = new TitledPane("Input", inputArea);
        TitledPane outputPane = new TitledPane("Output", outputArea);
        inputArea.setWrapText(true);
        inputArea.setPrefRowCount(30);
        inputArea.setFont(Roboto.getRobotoMediumFont(14));
        outputArea.setWrapText(true);
        outputArea.setPrefRowCount(30);
        outputArea.setFont(Roboto.getRobotoMediumFont(14));
        setPadding(new Insets(8));
        getChildren().addAll(inputPane, outputPane);
        controller.getAgendaModel().addAgendaObserver(this);
    }





    @Override
    public ImageView getMenuIcon() {
        return new ImageView(ImgLoader.filterImage());
    }





    @Override
    public void showDisplay(BorderPane borderPane) {
        borderPane.setCenter(this);
    }





    @Override
    public void agendaChanged(AgendaModel model) {
        clearDisplay();
    }





    @Override
    public void weekChanged(AgendaModel model) {
        clearDisplay();
    }





    @Override
    public void selectionChanged(AgendaModel model) {
        String input = model.getSelectedAgendaItem().getDescription();
        filterAndDisplay(input);
    }





    private void filterAndDisplay(String input) {
        inputArea.setText(input);
        outputArea.setText(textFilter.applyFilter(input));
    }





    private void clearDisplay() {
        inputArea.setText("");
        outputArea.setText("");
    }





}
