/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.agenda;

import com.core.data.Employee;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;





/**
 *
 * @author daanm
 */
public class Agenda implements Comparable<Agenda> {

    private final Employee employee;
    private Node head;





    public Agenda(Employee employee) {
        this.employee = employee;
        head = null;
    }





    public void printAgenda() {
        System.out.println("\nAGANDA FOR : \t\t" + employee.toString());
        System.out.println("_____________________________________________________");
        Iterator<AgendaItem> iterator = new AgendaIterator(head);
        while (iterator.hasNext()) {
            System.out.println("\t" + iterator.next().toString());
        }
        System.out.println("_____________________________________________________\n\n\n");
    }





    public Employee getEmployee() {
        return employee;
    }





    public boolean isEmpty() {
        return head == null;
    }





    public int size() {
        int size = 0;
        Node node = head;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }





    public List<AgendaItem> getItemsfor(LocalDate ld) {
        List<AgendaItem> list = new ArrayList<>();
        Node node = head;
        while (node != null) {
            if (node.item.isOnDate(ld)) {
                list.add(node.item);
            }
            node = node.next;
        }
        return list;
    }





    public AgendaItem getItemAt(int index) {
        Node node = head;
        int count = 0;
        while (node != null && count < index) {
            node = node.next;
            count++;
        }
        if (node != null) {
            return node.item;
        }
        return null;
    }





    public Iterator<AgendaItem> iterator() {
        return new AgendaIterator(head);
    }





    public void insert(AgendaItem item) {
        Node node = new Node(item);
        if (head == null) {
            head = node;
        } else {
            Node curr = head;
            Node prev = null;
            while (curr != null && item.getStartTime().compareTo(curr.item.getStartTime()) > 0) {
                prev = curr;
                curr = curr.next;
            }
            if (curr != null && item.getStartTime().compareTo(curr.item.getStartTime()) == 0) {
                return;
            }
            if (prev == null) {
                node.next = head;
                head = node;
            } else {
                node.next = prev.next;
                prev.next = node;
            }
        }
    }





    @Override
    public int compareTo(Agenda o) {
        return Integer.compare(size(), o.size());
    }





    public class Node {

        public AgendaItem item;
        public Node next;





        public Node(AgendaItem item) {
            this.item = item;
            next = null;
        }





    }
    public class AgendaIterator implements Iterator<AgendaItem> {

        private Node pointer;





        public AgendaIterator(Node node) {
            pointer = node;
        }





        @Override
        public boolean hasNext() {
            return pointer != null;
        }





        @Override
        public AgendaItem next() {
            AgendaItem hold = pointer.item;
            pointer = pointer.next;
            return hold;
        }





    }


}
