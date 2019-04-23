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
public class Stack<T> {

    private StackNode<T> head;





    public Stack() {
        head = null;
    }





    public boolean isEmpty() {
        return head != null;
    }





    public void push(T data) {
        StackNode<T> node = new StackNode<>(data);
        node.next = head;
        head = node;
    }





    public T pop() {
        T hold = head.data;
        head = head.next;
        return hold;
    }





}
