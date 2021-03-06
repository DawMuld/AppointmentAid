/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.raw;

import com.core.agenda.AgendaItem;
import com.core.agenda.AgendaTime;
import com.core.data.Employee;
import com.core.data.Person;
import com.core.planner.Planner;
import com.core.data.DateExtractor;
import com.core.data.DescriptionExtractor;
import com.core.data.NameExtractor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;





/**
 *
 * @author daanm
 */
public class PlannerLoader {

    public static final Planner buildDefaultPlanner() {
        try {
            File file = new File(LineListReader.class.getResource("cal_feb2019.txt").toURI());
            return loadPlanner(file);
        } catch (Exception e) {
        }
        return null;

    }






    public static Planner loadPlanner(File file) {
        Planner planner = new Planner();
        ArrayList<String> lines = storeFileLines(file);
        for (int i = 0; i < lines.size(); i++) {
            Person patient = NameExtractor.extractPatient(lines.get(i));
            Employee employee = NameExtractor.extraxtEmployee(lines.get(i));
            AgendaTime time = DateExtractor.parseAgendaTime(lines.get(i));
            String desc = DescriptionExtractor.extractDescriptionString(lines.get(i));
            if (patient != null && employee != null && time != null && desc != null) {
                AgendaItem item = new AgendaItem(time, employee, patient);
                item.setDescription(desc);
                planner.process(item);
            }
        }
        return planner;
    }






    public static ArrayList<String> storeFileLines(File file) {
        ArrayList<String> lineList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                lineList.add(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lineList;
    }


}



