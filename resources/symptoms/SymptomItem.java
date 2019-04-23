/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.symptoms;

import java.text.DecimalFormat;




/**
 *
 * @author daanm
 */
public class SymptomItem {

    public static final DecimalFormat DF = new DecimalFormat("0000");
    public final int index;
    public final String symptom;






    public SymptomItem(int index, String symptom) {
        this.index = index;
        this.symptom = symptom;
    }






    @Override
    public String toString() {
        return "[" + DF.format(index) + "]\t" + symptom;
    }

}

