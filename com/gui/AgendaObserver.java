/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui;




/**
 *
 * @author daanm
 */
public interface AgendaObserver {

    public void agendaChanged(AgendaModel model);






    public void weekChanged(AgendaModel model);






    public void selectionChanged(AgendaModel model);


}



