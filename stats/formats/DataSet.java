/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stats.formats;

import java.util.List;





/**
 *
 * @author DaanM
 * @param <T>
 */
public interface DataSet<T> {

    public int size();





    public void add(T sample);





    public T min();





    public T max();





    public T stdev();





    public T median();





    public T mean();





    public T trimmedMean(int p);





    public List<T> list();





    public T sum();





}
