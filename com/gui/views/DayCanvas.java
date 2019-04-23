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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import resources.raw.fonts.FontLoader;
import resources.raw.fonts.Roboto;




/**
 *
 * @author daanm
 */
public class DayCanvas extends BorderPane implements AgendaObserver {

    public static final double CANVAS_WIDTH = 200;
    public static final double CANVAS_HEIGHT = 800;
    public static final int DAY_START = 6;
    public static final int DAY_END = 18;

    private final int dayIndex;
    private final AgendaController controller;
    private final Canvas canvas;
    private final GridPane header;
    private final Label dayLabel;
    private Label dateLabel;

    private ArrayList<AgendaItem> agendaItems;
    private AgendaItem selection;






    public DayCanvas(int dayIndex, AgendaController controller) {
        super();
        this.controller = controller;
        this.dayIndex = dayIndex;
        this.canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        this.header = new GridPane();
        this.agendaItems = new ArrayList<>();
        String dayName = getDayName(dayIndex);
        dayLabel = new Label(dayName);
        dayLabel.setFont(FontLoader.loadSketchFont(24.0));
        dateLabel = new Label("XX-XX");
        dateLabel.setFont(Roboto.getRobotoMediumFont(16));
        header.setPrefSize(CANVAS_WIDTH, 50);
        header.add(dayLabel, 0, 0);
        header.add(dateLabel, 0, 1);
        super.setCenter(canvas);
        super.setTop(header);
        canvas.setOnMouseClicked((t) -> {
            handleClick(t.getX(), t.getY());
        });
        clearCanvas();

    }






    public void updateHeaderDate(LocalDate localDate) {
        String text = DateTimeFormatter.ofPattern("dd-MMM").format(localDate);
        dateLabel.setText(text);
    }






    public void renderAgenda() {
        // Platform.runLater(() -> {
        clearCanvas();
        for (int i = 0; i < agendaItems.size(); i++) {
            AgendaItem item = agendaItems.get(i);
            Color color = View.getItemColor(i);
            renderItem(item, color);
        }
        //  });

    }






    public void renderSelection() {
        renderItem(selection, View.SELECTED_ITEM_COLOR);
    }






    public void clearCanvas() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(View.BG_COLOR);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setStroke(View.LINE_COLOR);
        double interval = canvas.getHeight() / ((double) (DAY_END - DAY_START));
        for (int i = 0; i < (DAY_END - DAY_START); i++) {
            double y = i * interval;
            gc.strokeLine(0, y, canvas.getWidth(), y);
        }
    }






    public void renderItem(AgendaItem item, Color color) {
        ItemBounds bounds = getItemBounds(item);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(0, bounds.y, canvas.getWidth(), bounds.height);
        gc.setStroke(View.ITEM_BORDER_COLOR);
        gc.strokeRect(0, bounds.y, canvas.getWidth(), bounds.height);
    }






    @Override
    public void agendaChanged(AgendaModel model) {
        agendaItems.clear();
        agendaItems.addAll(model.getItemsFor(model.getWeekDays()[dayIndex]));
        renderAgenda();
    }






    @Override
    public void weekChanged(AgendaModel model) {
        agendaItems.clear();
        LocalDate localDate = model.getWeekDays()[dayIndex];
        agendaItems.addAll(model.getItemsFor(localDate));
        updateHeaderDate(localDate);
        renderAgenda();

    }






    @Override
    public void selectionChanged(AgendaModel model) {
        if (selection != null) {
            renderAgenda();
        }
        if (model.getSelectedAgendaItem().getStartTime().getDayOfYear() == model.getWeekDays()[dayIndex].getDayOfYear()) {
            selection = model.getSelectedAgendaItem();
            renderSelection();
        }
    }






    private String getDayName(int dayIndex) {
        switch (dayIndex) {
            case 0:
                return "Maandag";
            case 1:
                return "Dinsdag";
            case 2:
                return "Woensdag";
            case 3:
                return "Donderdag";
            case 4:
                return "Vrijdag";
            case 5:
                return "Zaterdag";
            case 6:
                return "Zondag";
            default:
                return "Geendag";
        }
    }






    private double hourHeight() {
        double hourCount = (double) (DAY_END - DAY_START);
        return canvas.getHeight() / hourCount;
    }






    private ItemBounds getItemBounds(AgendaItem item) {
        double hours = (double) item.getStartTime().getHour();
        double minutes = (double) item.getStartTime().getMinute();
        double offset = (hours - DAY_START) * hourHeight();
        offset += (minutes / 60.0) * hourHeight();
        double height = ((double) item.getDuration() / 60.0) * hourHeight();
        return new ItemBounds(offset, height);
    }






    private void handleClick(double x, double y) {
        for (AgendaItem item : agendaItems) {
            ItemBounds bounds = getItemBounds(item);
            if (y >= bounds.y && y <= (bounds.y + bounds.height)) {
                controller.select(item);

                break;
            }

        }

    }

}

