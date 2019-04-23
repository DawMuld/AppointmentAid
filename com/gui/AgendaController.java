/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui;

import com.core.agenda.Agenda;
import com.core.agenda.AgendaItem;





/**
 *
 * @author daanm
 */
public interface AgendaController {

    public AgendaModel getAgendaModel();






    public void nextWeek();






    public void prevWeek();






    public void select(AgendaItem agendaItem);






    public void select(Agenda agenda);


}



