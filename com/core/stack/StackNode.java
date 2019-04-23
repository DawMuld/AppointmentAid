/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.stack;
/**
 *
 * @author DaanM
 */
public class StackNode<T> {

    public final T data;
    public StackNode<T> next;





    public StackNode(T data) {
        this.data = data;
        next = null;
    }





    public boolean hasNext() {
        return next != null;
    }





}
