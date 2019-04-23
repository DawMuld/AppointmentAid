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
public class Controller implements AgendaController {

    private Model model;






    public Controller() {
        this.model = new Model();
    }






    @Override
    public AgendaModel getAgendaModel() {
        return model;
    }






    @Override
    public void nextWeek() {
        model.nextWeek();
    }






    @Override
    public void prevWeek() {
        model.prevWeek();
    }






    @Override
    public void select(AgendaItem agendaItem) {
        model.setSelectedAgendaItem(agendaItem);
    }






    @Override
    public void select(Agenda agenda) {
        model.setSelectedAgenda(agenda);
    }


}



