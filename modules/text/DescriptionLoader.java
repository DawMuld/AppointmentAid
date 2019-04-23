/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules.text;

import com.core.agenda.Agenda;
import com.core.planner.Planner;
import com.core.planner.PlannerBuilder;
import java.util.Iterator;
import java.util.List;





/**
 *
 * @author DaanM
 */
public class DescriptionLoader {
    
    public static void main(String[] args){
        printAgendaList(createSet_1());
    }
    
    public static List<Agenda> createSet_1(){
       Planner planner = PlannerBuilder.buildFromResource(0);
       return planner.getSortedAgendaList();
    }
    
    public static List<Agenda> createSet_2(){
        Planner planner = PlannerBuilder.buildFromResource(1);
        return planner.getSortedAgendaList();
    }
    
    public static List<Agenda> createSet_3(){
        Planner planner = PlannerBuilder.buildFromResource(2);
        return planner.getSortedAgendaList();
    }
    
    public static void printAgendaList(List<Agenda> list){
        Iterator<Agenda> i = list.iterator();
        while(i.hasNext()){
            Agenda agenda = i.next();
            System.out.println(agenda.size() + "\t\t" + agenda.getEmployee().toString());
        }
    }
    
    
}
