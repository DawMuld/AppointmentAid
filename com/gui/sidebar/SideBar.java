/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.sidebar;

import javafx.scene.layout.BorderPane;








/**
 *
 * @author daanm
 */
public class SideBar extends BorderPane {
    private SideBarMenu sideBarMenu;
    
    
    
    public SideBar(){
        super();
        sideBarMenu = new SideBarMenu();
        super.setRight(sideBarMenu);
        
    
    }
    
    
    
    public void addSideBarDisplay(SideBarDisplay display){
        sideBarMenu.addMenuItem(display, this);
    }
    
    
    
    
}



