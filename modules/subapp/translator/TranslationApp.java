/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules.subapp.translator;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import modules.common.builders.ViewBuilder;
import modules.mvc.translator.TranslationResultPane;
import net.external.translations.Translation;
import net.external.translations.TranslatorDisplayer;
import resources.raw.fonts.Noto;




/**
 *
 * @author DaanM
 */
public class TranslationApp extends Application implements TranslatorDisplayer {

    private Stage stage;
    private VBox resultBox;
    private Label queryLabel;
    private List<TranslationResultPane> resultPanes;






    public static void main(String[] args) {
        launch(args);
    }






    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.resultPanes = new ArrayList<>();

        BorderPane root = new BorderPane();
        root.setPrefSize(1600, 900);
        FlowPane qPane = new FlowPane(Orientation.HORIZONTAL);
        qPane.setPadding(new Insets(24));
        queryLabel = new Label();
        queryLabel.setFont(Noto.bold(32));
        queryLabel.setTextFill(Color.web("#FFFFFF"));
        queryLabel.setPrefWidth(200);
        queryLabel.setTextAlignment(TextAlignment.CENTER);
        qPane.setBackground(ViewBuilder.createBlackBackground());
        qPane.getChildren().add(queryLabel);
        root.setLeft(qPane);
        resultBox = new VBox(4);
        resultBox.setPadding(new Insets(8));
        resultBox.setBackground(ViewBuilder.createBlackBackground());
        root.setCenter(resultBox);
        FlowPane inputPane = new FlowPane();
        inputPane.setAlignment(Pos.CENTER_LEFT);
        inputPane.setPadding(new Insets(8));
        inputPane.setBackground(Background.EMPTY);
        TextField inputField = new TextField();
        inputField.setPrefColumnCount(20);
        inputField.setFont(Noto.bold(18));
        inputField.setOnAction((event) -> {
            String input = inputField.getText();
            if (input != null && !input.isEmpty()) {
                displayTranslation(new Translation(input));

            }
        });
        inputPane.getChildren().add(inputField);
        root.setTop(inputPane);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        displayTranslation(new Translation("perfect"));
    }






    @Override
    public void showDisplay() {
        if (stage == null) {
            launch();
        }
    }






    @Override
    public void hideDisplay() {
        if (stage != null) {
            stage.close();
        }
    }






    @Override
    public void displayTranslation(Translation result) {
        setResultSize(result.size());
        queryLabel.setText(result.getQuery());
        for (int i = 0; i < result.size(); i++) {
            if (i < resultPanes.size()) {
                resultPanes.get(i).displayTranslation(result.getResult(i));
            }
        }
    }






    private void setResultSize(int size) {
        if (resultPanes.size() < size) {
            for (int i = 0; i < (size - resultPanes.size()) + 1; i++) {
                TranslationResultPane pane = new TranslationResultPane();
                resultPanes.add(pane);
                resultBox.getChildren().add(pane);
            }
        } else if (resultPanes.size() > size) {
            for (int i = 0; i < (resultPanes.size() - size); i++) {
                TranslationResultPane pane = resultPanes.remove(resultPanes.size() - 1);
                resultBox.getChildren().remove(pane);
            }
        }
    }

}

