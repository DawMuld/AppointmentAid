/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui;

import com.core.agenda.Agenda;
import com.core.agenda.AgendaItem;
import com.core.planner.Planner;
import com.core.planner.PlannerBuilder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.collections.ObservableList;





/**
 *
 * @author daanm
 */
public class Model implements AgendaModel {

    private ObservableList<Agenda> agendaList;
    private Agenda selectedAgenda;

    private ArrayList<AgendaItem> itemList;
    private AgendaItem selectedItem;

    private LocalDate[] visibleDates;

    private ArrayList<AgendaObserver> oList;






    public Model() {
        Planner planner = PlannerBuilder.buildFromResources();
        agendaList = planner.createAgendaList();
        selectedAgenda = agendaList.get(0);
        visibleDates = getCurrentWeek();
        itemList = new ArrayList<>();
        oList = new ArrayList<>();
        updateItemList();
    }
    
    
    public void nextWeek(){
        updateNextWeek();
        updateItemList();
        fireWeekChanged();
    }
    
    public void prevWeek(){
        updatePrevWeek();
        updateItemList();
        fireWeekChanged();
    }
    
    public void setSelectedAgenda(Agenda agenda){
        selectedAgenda = agenda;
        updateItemList();
        fireAgendaChanged();
    }
    
    public void setSelectedAgendaItem(AgendaItem item){
        selectedItem= item;
        fireSelectionChanged();
    }






    private void updateItemList() {
        itemList.clear();
        selectedItem = null;
        if (selectedAgenda != null) {
            for (LocalDate date : visibleDates) {
                List<AgendaItem> items = selectedAgenda.getItemsfor(date);
                for (AgendaItem item : items) {
                    itemList.add(item);
                }
            }
        }
    }






    private void updateNextWeek() {
        for (int i = 0; i < visibleDates.length; i++) {
            visibleDates[i] = visibleDates[i].plusWeeks(1L);
        }
    }






    private void updatePrevWeek() {
        for (int i = 0; i < visibleDates.length; i++) {
            visibleDates[i] = visibleDates[i].minusWeeks(1L);
        }
    }






    private void fireWeekChanged() {
        if (!oList.isEmpty()) {
            Iterator<AgendaObserver> iterator = oList.iterator();
            while (iterator.hasNext()) {
                iterator.next().weekChanged(this);
            }
        }
    }






    private void fireSelectionChanged() {
        if (!oList.isEmpty()) {
            Iterator<AgendaObserver> iterator = oList.iterator();
            while (iterator.hasNext()) {
                iterator.next().selectionChanged(this);
            }
        }
    }






    private void fireAgendaChanged() {
        if (!oList.isEmpty()) {
            Iterator<AgendaObserver> iterator = oList.iterator();
            while (iterator.hasNext()) {
                iterator.next().agendaChanged(this);
            }
        }
    }






    @Override
    public void addAgendaObserver(AgendaObserver observer) {
        oList.add(observer);
    }






    @Override
    public void removeAgendaObserver(AgendaObserver observer) {
        oList.remove(observer);
    }






    @Override
    public ObservableList<Agenda> getAgendaList() {
        return agendaList;
    }






    @Override
    public Agenda getCurrentAgenda() {
        return selectedAgenda;
    }






    @Override
    public LocalDate[] getWeekDays() {
        return visibleDates;
    }






    @Override
    public List<AgendaItem> getItemsFor(LocalDate localDate) {
        return selectedAgenda.getItemsfor(localDate);
    }






    @Override
    public AgendaItem getSelectedAgendaItem() {
        return selectedItem;
    }






    private LocalDate[] getCurrentWeek() {
        LocalDate today = LocalDate.now();
        int offset = today.getDayOfWeek().getValue() - 1;
        if (offset > 0) {
            today = today.minusDays((long) offset);
        }
        LocalDate[] week = new LocalDate[5];
        for (int i = 0; i < week.length; i++) {
            week[i] = today;
            today = today.plusDays(1L);
        }
        return week;
    }


}



