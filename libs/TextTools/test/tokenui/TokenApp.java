/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokenui;

import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import resources.planner.agenda.Agenda;
import resources.planner.agenda.AgendaItem;
import resources.planner.builder.Planner;
import resources.planner.builder.PlannerBuilder;
import tools.cleaning.token.TokenPane;
import tools.cleaning.token.Tokenizer;





/**
 *
 * @author DaanM
 */
public class TokenApp extends Application {
    public static void main(String[] args){launch(args);}

    @Override
    public void start(Stage stage) throws Exception {
        TokenPane root = new TokenPane();
        Planner planner = PlannerBuilder.buildFromResource(0);
        List<Agenda> aList = planner.createAgendaList();
        for(Agenda agenda:aList){
            for(int i = 0; i < agenda.size(); i++){
                AgendaItem item = agenda.getItemAt(i);
                String[] tokens = Tokenizer.tokenize(item.getDescription());
                root.addTokens(tokens);
            }
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
