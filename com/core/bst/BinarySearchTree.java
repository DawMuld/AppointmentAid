/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.bst;

import com.core.stack.Stack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;





/**
 *
 * @author daanm
 */
public class BinarySearchTree {

    private BstNode root;





    public BinarySearchTree() {
        root = null;
    }





    public boolean isEmpty() {
        return root != null;
    }





    public static BstNode findOrInsert(BstNode root, String text) {
        if (root == null) {
            return new BstNode(text);
        }
        if (root.compareTo(text) < 0) {
            if (root.left != null) {
                return findOrInsert(root.left, text);
            } else {
                return root.left = new BstNode(text);
            }
        } else if (root.compareTo(text) > 0) {
            if (root.right != null) {
                return findOrInsert(root.right, text);
            } else {
                return root.right = new BstNode(text);
            }
        } else {
            return root;
        }
    }





    public List<WordFreq> toWordFreqList() {
        List<WordFreq> list = new ArrayList<>();
        list = addInOrder(list, root);
        return list;
    }





    public void addToTree(List<String> list) {
        for (String item : list) {
            BstNode node = findOrInsert(root, item);
            if (root == null) {
                root = node;
            }
            node.visit();
        }
    }





    public void addToTree(String[] tokens) {
        for (String token : tokens) {
            BstNode node = findOrInsert(root, token);
            if (root == null) {
                root = node;
            }
            node.visit();
        }
    }





    public void printInOrder() {
        printInOrder(root);
    }





    private static List<WordFreq> addInOrder(List<WordFreq> list, BstNode root) {
        if (root == null) {
            return list;
        }
        if (root.left != null) {
            addInOrder(list, root.left);
        }
        list.add(new WordFreq(root.freq(), root.word()));
        if (root.right != null) {
            addInOrder(list, root.right);
        }
        return list;
    }





    public static void printInOrder(BstNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            printInOrder(root.left);
        }
        System.out.println(root.freq() + "\t" + root.word());
        if (root.right != null) {
            printInOrder(root.right);
        }
    }





}
