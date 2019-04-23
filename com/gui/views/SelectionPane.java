/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gui.views;

import com.core.agenda.AgendaItem;
import com.gui.AgendaController;
import com.gui.AgendaModel;
import com.gui.AgendaObserver;
import java.time.format.DateTimeFormatter;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import resources.raw.fonts.Roboto;





/**
 *
 * @author daanm
 */
public class SelectionPane extends GridPane implements AgendaObserver {

    private TextField patientField;
    private TextField startTimeField;
    private TextField endTimeField;
    private TextArea descriptionArea;






    public SelectionPane(AgendaController controller) {
        super();
        super.setHgap(4);
        super.setVgap(4);
        super.setPadding(new Insets(4, 8, 4, 8));
        patientField = makeField();
        super.add(makeLabel("Patient"), 0, 0, 2, 1);
        super.add(patientField, 0, 1, 2, 1);
        startTimeField = makeField();
        super.add(makeLabel("start"), 0, 2, 1, 1);
        super.add(startTimeField, 0, 3, 1, 1);
        endTimeField = makeField();
        super.add(makeLabel("end"), 1, 2, 1, 1);
        super.add(endTimeField, 1, 3, 1, 1);
        descriptionArea = new TextArea();
        descriptionArea.setFont(Roboto.getRobotoFont(14));
        descriptionArea.setPrefRowCount(3);
        descriptionArea.setWrapText(true);

        super.add(makeLabel("Appointment details"), 3, 0, 3, 1);
        super.add(descriptionArea, 3, 1, 3, 3);
        controller.getAgendaModel().addAgendaObserver(this);
    }






    private Label makeLabel(String text) {
        Label label = new Label(text);
        label.setFont(Roboto.getRobotoMediumFont(14));
        return label;
    }






    private TextField makeField() {
        TextField field = new TextField();
        field.setFont(Roboto.getRobotoFont(14));
        return field;
    }






    private void display(AgendaItem item) {
        String patient = item.getPatient().getInitials() + " " + item.getPatient().getLastName();
        String start = DateTimeFormatter.ofPattern("HH:mm").format(item.getStartTime());
        String end = DateTimeFormatter.ofPattern("HH:mm").format(item.getEndTime());
        String details = item.getDescription();
        Platform.runLater(() -> {
            patientField.setText(patient);
            startTimeField.setText(start);
            endTimeField.setText(end);
            descriptionArea.setText(details);
        });
    }






    private void clear() {
        patientField.setText("");
        startTimeField.setText("");
        endTimeField.setText("");
        descriptionArea.setText("");
    }






    @Override
    public void agendaChanged(AgendaModel model) {
        clear();
    }






    @Override
    public void weekChanged(AgendaModel model) {
        clear();

    }






    @Override
    public void selectionChanged(AgendaModel model) {
        display(model.getSelectedAgendaItem());
    }


}



