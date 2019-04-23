/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stats.formats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;





/**
 *
 * @author DaanM
 */
public class DoubleDataSet implements DataSet<Double> {

    private final List<Double> list;





    public DoubleDataSet() {
        this.list = new ArrayList<>();
    }





    public DoubleDataSet(List<Double> list) {
        this.list = list;
        Collections.sort(this.list);
    }





    @Override
    public int size() {
        return list.size();
    }





    @Override
    public void add(Double sample) {
        list.add(sample);
        Collections.sort(list);
    }





    @Override
    public Double min() {
        return list.get(0);
    }





    @Override
    public Double max() {
        return list.get(list.size() - 1);
    }





    @Override
    public Double stdev() {
        double mean = mean();
        double stdev = 0.0;
        for (Double sample : list) {
            stdev += Math.sqrt(Math.pow(sample, 2));
        }
        return stdev / (double) (list.size() - 1);
    }





    @Override
    public Double median() {
        int n = size();
        if (n % 2 == 0) {
            int i1 = n / 2;
            int i2 = i1 + 1;
            return (list.get(i1) + list.get(i2)) / 2;
        }
        return list.get(size() / 2);
    }





    @Override
    public Double mean() {
        double total = sum();
        return total / size();
    }





    @Override
    public Double trimmedMean(int p) {
        int i = p;
        int iMax = size() - p;
        double sum = 0.0;
        int count = 0;
        for (; i < iMax; i++) {
            sum += list.get(i);
            count++;
        }
        return sum / count;
    }





    @Override
    public List<Double> list() {
        return list;
    }





    @Override
    public Double sum() {
        double sum = 0.0;
        for (Double sample : list) {
            sum += sample;
        }
        return sum;
    }





}
