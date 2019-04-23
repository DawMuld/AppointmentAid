/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.raw.fonts;

import java.io.File;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;





/**
 *
 * @author daanm
 */
public class FontLoader {

    public static Font loadSketchFont(double size) {
        return loadFont("sketchy", size);

    }






    public static Font loadFont(String name, double size) {
        String path = System.getProperty("user.dir") + "\\src\\resources\\raw\\fonts\\" + name;
        File file = new File(path);
        try {
            return Font.loadFont(new FileInputStream(file), size);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }


}



