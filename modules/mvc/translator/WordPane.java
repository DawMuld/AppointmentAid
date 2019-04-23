/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules.mvc.translator;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import modules.common.builders.ViewBuilder;
import net.external.translations.WordEntry;
import resources.raw.fonts.Noto;




/**
 *
 * @author DaanM
 */
public class WordPane extends GridPane {

    public static final double WORD_LABEL_WIDTH = 250;
    public static final double META_LABEL_WIDTH = 100;
    public static final double INFO_LABEL_WIDTH = 100;
    private List<Label> wordLabels;
    private List<Label> metaLabels;
    private List<Label> infoLabels;






    public WordPane() {
        super();

        setPadding(new Insets(8));
        setBackground(ViewBuilder.createBlackBackground());
        wordLabels = new ArrayList<>();
        metaLabels = new ArrayList<>();
        infoLabels = new ArrayList<>();

    }






    public void clear() {
        wordLabels.forEach((label) -> {
            label.setText("");
        });
        metaLabels.forEach((label) -> {
            label.setText("");
        });
        infoLabels.forEach((label) -> {
            label.setText("");
        });
    }






    public void display(List<WordEntry> words) {
        if (wordLabels.isEmpty()) {
            for (int i = 0; i < words.size(); i++) {
                addLine();
            }
        } else {
            if (wordLabels.size() > words.size()) {
                int rowsToRemove = wordLabels.size() - words.size();
                for (int i = 0; i < rowsToRemove; i++) {
                    removeLine();
                }
            } else if (wordLabels.size() < words.size()) {
                int rowsToAdd = words.size() - wordLabels.size();
                for (int i = 0; i < rowsToAdd; i++) {
                    addLine();
                }
            }
        }
        for (int i = 0; i < words.size(); i++) {
            WordEntry entry = words.get(i);
            wordLabels.get(i).setText(entry.getWord());
            if (entry.hasMeta()) {
                metaLabels.get(i).setText(entry.getMeta());
            } else {
                metaLabels.get(i).setText("");
            }
            if (entry.hasInfo()) {
                infoLabels.get(i).setText(entry.getInfo());
            } else {
                infoLabels.get(i).setText("");
            }
        }

    }






    private void addLine() {
        int row = wordLabels.size();
        Label wordLabel = createWordLabel();
        Label metaLabel = createMetaLabel();
        Label infoLabel = createInfoLabel();
        wordLabels.add(wordLabel);
        this.add(wordLabel, 0, row, 3, 1);
        metaLabels.add(metaLabel);
        this.add(metaLabel, 3, row, 1, 1);
        infoLabels.add(infoLabel);
        this.add(infoLabel, 4, row, 1, 1);
    }






    private void removeLine() {
        Label wordLabel = wordLabels.get(wordLabels.size() - 1);
        Label metaLabel = metaLabels.get(metaLabels.size() - 1);
        Label infoLabel = infoLabels.get(infoLabels.size() - 1);
        this.getChildren().removeAll(wordLabel, metaLabel, infoLabel);
        wordLabels.remove(wordLabel);
        metaLabels.remove(metaLabel);
        infoLabels.remove(infoLabel);

    }






    private Label createWordLabel() {
        Label label = new Label();
        label.setPrefWidth(WORD_LABEL_WIDTH);
        label.setFont(Noto.bold(12));
        label.setTextFill(Color.web("#FFFFFF"));
        label.setBackground(Background.EMPTY);
        return label;
    }






    private Label createMetaLabel() {
        Label label = new Label();
        label.setPrefWidth(META_LABEL_WIDTH);
        label.setFont(Noto.regular(12));
        label.setTextFill(Color.web("#FFFFFF"));
        label.setBackground(Background.EMPTY);
        return label;

    }






    private Label createInfoLabel() {
        Label label = new Label();
        label.setPrefWidth(INFO_LABEL_WIDTH);
        label.setFont(Noto.regular(12));
        label.setTextFill(Color.web("#FFFFFF"));
        label.setBackground(Background.EMPTY);
        return label;

    }

}

