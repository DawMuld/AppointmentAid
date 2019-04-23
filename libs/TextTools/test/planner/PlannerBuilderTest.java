/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planner;

import java.util.List;
import resources.planner.agenda.Agenda;
import resources.planner.builder.Planner;
import resources.planner.builder.PlannerBuilder;





/**
 *
 * @author DaanM
 */
public class PlannerBuilderTest {
    
    public static void main(String[] args){
        Planner planner = PlannerBuilder.buildFromResource(0);
        List<Agenda> list = planner.getSortedAgendaList();
        Agenda[] array = new Agenda[10];
        int index = list.size()-1;
        for(int i = 0; i < 10; i++){
            array[i] = list.get(index);
            index--;
        }
        for(Agenda agenda:array){
            System.out.println(agenda.size() + " agenda items for " + agenda.getEmployee().getLastName());
        }
    
    }
    
}
