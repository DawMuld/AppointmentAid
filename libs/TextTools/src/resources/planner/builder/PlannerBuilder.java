/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.planner.builder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import resources.planner.agenda.AgendaItem;
import resources.planner.agenda.AgendaTime;
import resources.planner.data.DateExtractor;
import resources.planner.data.DescriptionExtractor;
import resources.planner.data.Employee;
import resources.planner.data.NameExtractor;
import resources.planner.data.Person;





/**
 *
 * @author daanm
 */
public class PlannerBuilder {

    /**
     * Collects the Planner data files that are stored in the project and
     * constructs the Planner`
     *
     * @return
     */
    public static Planner buildFromResources() {
        File[] files = getResourceFiles();
        Planner planner = buildPlanner(files);
        return planner;
    }





    public static Planner buildFromResource(int index) {
        File[] files = getResourceFiles();
        int i = index % files.length;
        return buildPlanner(files[i]);
    }





    public static File[] getResourceFiles() {
        String path = System.getProperty("user.dir") + "\\src\\resources\\planners\\";
        File folder = new File(path);
        return folder.listFiles();
    }





    public static Planner buildPlanner(File file) {
        Planner planner = new Planner();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            for (line = reader.readLine(); line != null; line = reader.readLine()) {
                Person patient = NameExtractor.extractPatient(line);
                Employee employee = NameExtractor.extraxtEmployee(line);
                AgendaTime agendaTime = DateExtractor.parseAgendaTime(line);
                String description = DescriptionExtractor.extractDescriptionString(line);
                if (patient != null && employee != null && agendaTime != null) {
                    AgendaItem item = new AgendaItem(agendaTime, employee, patient);
                    if (description != null) {
                        item.setDescription(description);
                    }
                    planner.process(item);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Could not load Planner instance for file " + file.getAbsolutePath());
        }
        return planner;
    }





    public static Planner buildPlanner(File[] files) {
        Planner planner = new Planner();
        for (File file : files) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                for (line = reader.readLine(); line != null; line = reader.readLine()) {
                    Person patient = NameExtractor.extractPatient(line);
                    Employee employee = NameExtractor.extraxtEmployee(line);
                    AgendaTime agendaTime = DateExtractor.parseAgendaTime(line);
                    String description = DescriptionExtractor.extractDescriptionString(line);
                    if (patient != null && employee != null && agendaTime != null) {
                        AgendaItem item = new AgendaItem(agendaTime, employee, patient);
                        if (description != null) {
                            item.setDescription(description);
                        }
                        planner.process(item);
                    }
                }
                reader.close();
            } catch (IOException e) {
                System.out.println("Could not load Planner instance for file " + file.getAbsolutePath());
            }
        }
        return planner;
    }





}
