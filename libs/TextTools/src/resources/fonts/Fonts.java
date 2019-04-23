/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.fonts;

import java.io.File;
import java.io.FileInputStream;
import javafx.scene.text.Font;





/**
 *
 * @author DaanM
 */
public class Fonts {

    public static Font regular(double size) {
        try {
            File file = new File(System.getProperty("user.dir") + "\\src\\resources\\fonts\\font_regular.ttf");
            Font font = Font.loadFont(new FileInputStream(file), size);
            return font;
        } catch (Exception e) {
        }
        return null;
    }





    public static Font title(double size) {
        try {
            File file = new File(System.getProperty("user.dir") + "\\src\\resources\\fonts\\font_title.ttf");
            Font font = Font.loadFont(new FileInputStream(file), size);
            return font;
        } catch (Exception e) {
        }
        return null;
    }





}
