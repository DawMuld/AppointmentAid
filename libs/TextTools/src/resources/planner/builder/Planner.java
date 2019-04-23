/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.planner.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import resources.planner.agenda.Agenda;
import resources.planner.agenda.AgendaItem;
import resources.planner.data.Employee;





/**
 *
 * @author daanm
 */
public class Planner {

    private ArrayList<Agenda> agendaList;





    public Planner() {
        agendaList = new ArrayList<>();
    }





    public Agenda getLargestAgenda() {
        if (agendaList.isEmpty()) {
            return null;
        } else if (agendaList.size() == 1) {
            return agendaList.get(0);
        } else {
            Agenda agenda = agendaList.get(0);
            for (int i = 1; i < agendaList.size(); i++) {
                Agenda item = agendaList.get(i);
                if (item.size() > agenda.size()) {
                    agenda = item;
                }
            }
            return agenda;
        }
    }





    public void process(AgendaItem item) {
        Agenda agenda = this.locateAgenda(item.getEmployee());
        if (agenda == null) {
            agenda = new Agenda(item.getEmployee());
            agenda.insert(item);
            agendaList.add(agenda);
        } else {
            agenda.insert(item);
        }
    }





    public Agenda locateAgenda(Employee employee) {
        if (agendaList.isEmpty()) {
            return null;
        }
        for (int i = 0; i < agendaList.size(); i++) {
            Agenda agenda = agendaList.get(i);
            if (agenda.getEmployee().equalsIgnoreInitials(employee)) {
                return agenda;
            }
        }
        return null;
    }





    public void printPlanner() {
        for (int i = 0; i < agendaList.size(); i++) {
            agendaList.get(i).printAgenda();
        }
    }





    public ArrayList<Employee> getAvailableAgendas() {
        ArrayList<Employee> list = new ArrayList<>();
        for (int i = 0; i < agendaList.size(); i++) {
            list.add(agendaList.get(i).getEmployee());
        }
        return list;
    }





    public ObservableList<Agenda> createAgendaList() {
        return FXCollections.observableArrayList(agendaList);
    }





    public int size() {
        return agendaList.size();
    }





    public Agenda getAgendaAt(int index) {
        return agendaList.get(index);
    }





    public List<Agenda> getSortedAgendaList() {
        List<Agenda> list = new ArrayList<>(agendaList.size());
        for (Agenda agenda : agendaList) {
            list.add(agenda);
        }
        Collections.sort(list);
        return list;
    }





}
