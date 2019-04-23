/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.views;

import com.gui.AgendaController;
import com.gui.Controller;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import resources.raw.fonts.Roboto;




/**
 *
 * @author daanm
 */
public class WeekView extends BorderPane {

    private HBox dayBox;
    private DayCanvas[] days;
    private Button nextWeekButton;
    private Button prevWeekButton;
    private AgendaController controller;






    public WeekView(Controller controller) {
        super();
        dayBox = new HBox();
        dayBox.setSpacing(12);
        days = new DayCanvas[]{new DayCanvas(0, controller), new DayCanvas(1, controller), new DayCanvas(2, controller), new DayCanvas(3, controller), new DayCanvas(4, controller)};
        dayBox.getChildren().addAll(days);
        super.setCenter(dayBox);
        nextWeekButton = new Button("next->");
        prevWeekButton = new Button("<-prev");
        nextWeekButton.setOnAction((t) -> {
            controller.nextWeek();
        });
        prevWeekButton.setOnAction((t) -> {
            controller.prevWeek();
        });
        nextWeekButton.setFont(Roboto.getRobotoFont(10));
        prevWeekButton.setFont(Roboto.getRobotoFont(10));
        this.controller = controller;
        for (DayCanvas day : days) {
            controller.getAgendaModel().addAgendaObserver(day);
        }
        AnchorPane buttonPane = new AnchorPane();
        AnchorPane.setLeftAnchor(prevWeekButton, 16.0);
        AnchorPane.setTopAnchor(prevWeekButton, 4.0);
        AnchorPane.setRightAnchor(nextWeekButton, 16.0);
        AnchorPane.setTopAnchor(nextWeekButton, 4.0);
        buttonPane.getChildren().addAll(prevWeekButton, nextWeekButton);
        super.setTop(buttonPane);
        SelectionPane selectionPane = new SelectionPane(controller);
        super.setBottom(selectionPane);

    }

}

