/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.views;

import javafx.scene.paint.Color;





/**
 *
 * @author daanm
 */
public class View {

    public static Color BG_COLOR = Color.web("#FFFFFF");
    public static Color LINE_COLOR = Color.web("#898989");
    public static Color ITEM_BORDER_COLOR = Color.web("#212121");
    public static Color[] ITEM_COLORS = new Color[]{Color.web("#F4F2B8"), Color.web("#9AC1BC"), Color.web("#59A4AA")};
    public static Color SELECTED_ITEM_COLOR = Color.web("#EF6955");
    





    public static Color getItemColor(int index) {
        int i = index % ITEM_COLORS.length;
        return ITEM_COLORS[i];

    }


}



