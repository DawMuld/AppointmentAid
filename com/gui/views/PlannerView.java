/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.views;

import com.core.agenda.Agenda;
import com.gui.AgendaController;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import resources.raw.fonts.Roboto;





/**
 *
 * @author daanm
 */
public class PlannerView extends BorderPane {

    private AgendaController controller;
    private ListView<Agenda> agendaList;






    public PlannerView(AgendaController controller) {
        super();
        this.controller = controller;
        this.agendaList = new ListView<Agenda>(controller.getAgendaModel().getAgendaList());
        agendaList.setCellFactory((p) -> {
            return new AgendaListCell(); //To change body of generated lambdas, choose Tools | Templates.
        });
        agendaList.getSelectionModel().selectedItemProperty().addListener((ov, t, t1) -> {
            controller.select(t1);
        });
        super.setCenter(agendaList);

    }




    public class AgendaListCell extends ListCell<Agenda> {

        @Override
        public void updateItem(Agenda item, boolean empty) {
            super.updateItem(item, empty);
            if (empty) {
                setText("");
                setGraphic(null);
            } else {
                Label nameLabel = new Label(item.getEmployee().getInitials() + " " + item.getEmployee().getLastName());
                Label sizeLabel = new Label(item.size() + " Agenda items");
                nameLabel.setFont(Roboto.getRobotoMediumFont(18));
                sizeLabel.setFont(Roboto.getRobotoThinFont(14));
                GridPane pane = new GridPane();
                pane.setPadding(new Insets(4, 8, 4, 8));
                pane.add(nameLabel, 0, 0);
                pane.add(sizeLabel, 0, 1);
                this.setGraphic(pane);
            }

        }


    }




}



