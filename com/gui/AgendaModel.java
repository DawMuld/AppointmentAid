/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui;

import com.core.agenda.Agenda;
import com.core.agenda.AgendaItem;
import java.time.LocalDate;
import java.util.List;
import javafx.collections.ObservableList;





/**
 *
 * @author daanm
 */
public interface AgendaModel {

    public void addAgendaObserver(AgendaObserver observer);






    public void removeAgendaObserver(AgendaObserver observer);






    public ObservableList<Agenda> getAgendaList();






    public Agenda getCurrentAgenda();






    public LocalDate[] getWeekDays();






    public List<AgendaItem> getItemsFor(LocalDate localDate);






    public AgendaItem getSelectedAgendaItem();


}



