/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.raw.fonts;

import java.io.File;
import java.io.FileInputStream;
import javafx.scene.text.Font;





/**
 *
 * @author daanm
 */
public class Roboto {

    public static Font getRobotoFont(double size) {
        try {
            File file = new File(Roboto.class.getResource("Roboto-Regular.ttf").toURI());
            Font font = Font.loadFont(new FileInputStream(file), size);
            return font;
        } catch (Exception e) {
        }
        return null;
    }






    public static Font getRobotoBlackFont(double size) {
        try {
            File file = new File(Roboto.class.getResource("Roboto-Black.ttf").toURI());
            Font font = Font.loadFont(new FileInputStream(file), size);
            return font;
        } catch (Exception e) {
        }
        return null;
    }






    public static Font getRobotoMediumFont(double size) {
        try {
            File file = new File(Roboto.class.getResource("Roboto-Medium.ttf").toURI());
            Font font = Font.loadFont(new FileInputStream(file), size);
            return font;
        } catch (Exception e) {
        }
        return null;
    }






    public static Font getRobotoThinFont(double size) {
        try {
            File file = new File(Roboto.class.getResource("Roboto-Thin.ttf").toURI());
            Font font = Font.loadFont(new FileInputStream(file), size);
            return font;
        } catch (Exception e) {
        }
        return null;
    }


}



