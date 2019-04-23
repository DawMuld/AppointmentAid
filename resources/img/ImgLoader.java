/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.img;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;





/**
 *
 * @author daanm
 */
public class ImgLoader {

    public static Image loadFile(String name) {
        File file = new File(System.getProperty("user.dir") + "\\src\\resources\\img\\" + name);
        try {
            return new Image(new FileInputStream(file));
        } catch (FileNotFoundException e) {
        }
        return null;
    }





    public static Image symptomsImage() {
        return loadFile("symptom.png");
    }





    public static Image wikiImage() {
        return loadFile("wiki.png");
    }





    public static Image filterImage() {
        return loadFile("filter.png");
    }





}
