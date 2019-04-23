/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules.subapp.researcher;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modules.mvc.html.WebViewer;





/**
 *
 * @author DaanM
 */
public class ResearchApp extends Application {
    public static void main(String[] args){launch(args);}
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        WebViewer root = new WebViewer();
        root.setPrefSize(1600, 900);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
