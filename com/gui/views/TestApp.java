/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.views;

import com.gui.Controller;
import com.gui.displays.FilteredTextDisplay;
import com.gui.displays.SymptomDisplay;
import com.gui.displays.WikiDisplay;
import com.gui.sidebar.SideBar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;




/**
 *
 * @author daanm
 */
public class TestApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }






    @Override
    public void start(Stage stage) throws Exception {
        Controller controller = new Controller();
        WeekView weekView = new WeekView(controller);
        PlannerView plannerView = new PlannerView(controller);
        SideBar sideBar = new SideBar();
        SymptomDisplay symptomDisplay = new SymptomDisplay(controller);
        WikiDisplay wikiDisplay = new WikiDisplay(controller);
        FilteredTextDisplay filterDisplay = new FilteredTextDisplay(controller);
        sideBar.addSideBarDisplay(symptomDisplay);
        sideBar.addSideBarDisplay(wikiDisplay);
        sideBar.addSideBarDisplay(filterDisplay);
        BorderPane root = new BorderPane();
        root.setCenter(weekView);
        root.setLeft(plannerView);
        root.setRight(sideBar);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}

