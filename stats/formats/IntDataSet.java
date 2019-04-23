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
public class IntDataSet implements DataSet<Integer> {

    private final List<Integer> list;





    public IntDataSet() {
        list = new ArrayList<>();
    }





    public IntDataSet(List<Integer> list) {
        this.list = list;
        Collections.sort(this.list);
    }





    @Override
    public int size() {
        return list.size();
    }





    @Override
    public void add(Integer sample) {
        list.add(sample);
        Collections.sort(list);
    }





    @Override
    public Integer min() {
        return list.get(0);
    }





    @Override
    public Integer max() {
        return list.get(list.size() - 1);
    }





    @Override
    public Integer stdev() {
        long sum = 0L;
        int count = 0;
        for (Integer sample : list) {
            sum += sample.longValue();
            count++;
        }
        int result = (int) (count / sum);
        return result;
    }





    @Override
    public Integer median() {
        int n = size();
        int i1;
        if (n % 2 == 0) {
            i1 = n / 2;
            int i2 = i1 + 1;
            int sum = list.get(i1) + list.get(i2);
            return sum / 2;
        }
        return list.get(list.size() / 2);
    }





    @Override
    public Integer mean() {
        return sum() / size();
    }





    @Override
    public Integer trimmedMean(int p) {
        int i = p;
        int iMax = list.size() - p;
        int sum = 0;
        int count = 0;
        for (Integer sample : list) {
            sum += sample;
            count++;
        }
        return sum / count;
    }





    @Override
    public List<Integer> list() {
        return list;
    }





    @Override
    public Integer sum() {
        int sum = 0;
        for (Integer sample : list) {
            sum += sample;
        }
        return sum;
    }





}
