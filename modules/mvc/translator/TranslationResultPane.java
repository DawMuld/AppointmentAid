/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modules.mvc.translator;

import javafx.scene.layout.AnchorPane;
import net.external.translations.TranslationResult;





/**
 *
 * @author DaanM
 */
public class TranslationResultPane extends AnchorPane{
    private WordPane sourcePane;
    private WordPane resultPane;
    
    
    public TranslationResultPane(){
        super();
        sourcePane = new WordPane();
        resultPane = new WordPane();
        AnchorPane.setTopAnchor(sourcePane, 8.0);
        AnchorPane.setLeftAnchor(sourcePane, 8.0);
        AnchorPane.setTopAnchor(resultPane, 8.0);
        AnchorPane.setRightAnchor(resultPane, 8.0);
        getChildren().addAll(sourcePane, resultPane);
        
    }
    
    
    public void displayTranslation(TranslationResult result){
        sourcePane.display(result.getSourceList());
        resultPane.display(result.getTargetList());
    }
    
    
    
    
    
}
