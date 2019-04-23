/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.export;

import com.analysis.Tokenizer;
import com.core.agenda.Agenda;
import com.core.agenda.AgendaItem;
import com.core.bst.BinarySearchTree;
import com.core.bst.WordFreq;
import com.core.planner.Planner;
import com.core.planner.PlannerBuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;





/**
 *
 * @author DaanM
 */
public class DescriptionExporter {

    public static void exportDescriptions(File file) {
        Planner planner = PlannerBuilder.buildFromResources();
        try {
            file.createNewFile();
            PrintWriter writer = new PrintWriter(new FileWriter(file));
            for (int i = 0; i < planner.size(); i++) {
                Agenda agenda = planner.getAgendaAt(i);
                for (int j = 0; j < agenda.size(); j++) {
                    AgendaItem item = agenda.getItemAt(j);
                    String[] tokens = Tokenizer.tokenize(item.getDescription());
                    String line = "";
                    for (String token : tokens) {
                        line += token + " ";
                    }
                    writer.println(line);
                }
            }
            writer.flush();
            writer.close();
        } catch (Exception e) {
        }
    }





}
