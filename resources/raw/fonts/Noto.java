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
 * @author DaanM
 */
public class Noto {

    public static Font regular(double fontSize) {
        String path = System.getProperty("user.dir") + "\\src\\resources\\raw\\fonts\\NotoRegular.ttf";
        File file = new File(path);
        try {
            Font font = Font.loadFont(new FileInputStream(file), fontSize);
            return font;
        } catch (Exception e) {
            System.out.println("Cannot load NotoRegular.ttf");
        }
        return null;
    }





    public static Font bold(double fontSize) {
        String path = System.getProperty("user.dir") + "\\src\\resources\\raw\\fonts\\NotoBold.ttf";
        File file = new File(path);
        try {
            Font font = Font.loadFont(new FileInputStream(file), fontSize);
            return font;
        } catch (Exception e) {
            System.out.println("Cannot load NotoBold.ttf");
        }
        return null;
    }





}
