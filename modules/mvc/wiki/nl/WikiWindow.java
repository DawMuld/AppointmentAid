/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules.mvc.wiki.nl;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;





/**
 *
 * @author DaanM
 */
public class WikiWindow extends Application
{
    public static void main(String[] args){launch(args);}

    @Override
    public void start(Stage stage) throws Exception {
        WikiView wikiView = new WikiView();
        Scene scene = new Scene(wikiView);
        stage.setScene(scene);
        stage.show();
    }
    
}
