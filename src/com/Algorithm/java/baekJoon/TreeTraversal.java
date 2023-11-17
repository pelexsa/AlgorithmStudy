package com.Algorithm.java.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int lineNum = Integer.parseInt(bf.readLine());

        Tree tree = new Tree();

        for (int i = 0; i < lineNum; i++) {
            char[] arr;
            arr = bf.readLine().replace(" ", "").toCharArray();
            tree.createNode(arr[0], arr[1], arr[2]);
        }

        TreeTraversal.preOrder(tree.root);
        System.out.println();
        TreeTraversal.inOrder(tree.root);
        System.out.println();
        TreeTraversal.postOrder(tree.root);
        System.out.println();
    }
}

class Tree {
    char data;
    static Tree root;
    Tree treeLeftNode, treeRightNode;

    public Tree() {
    }

    public Tree(char data) {
        this.data = data;
    }

    static void createNode(char nodeData, char leftData, char rightData) {
        if (root == null) {
            root = new Tree(nodeData);

            if (leftData != '.') {
                root.treeLeftNode = new Tree(leftData);
            }
            if (rightData != '.') {
                root.treeRightNode = new Tree(rightData);
            }
        } else {
            searchNode(root, nodeData, leftData, rightData);
        }
    }

    static void searchNode(Tree root, char nodeData, char leftData, char rightData) {
        if (root == null) {
            return;
        } else if (root.data == nodeData) {
            if (leftData != '.') {
                root.treeLeftNode = new Tree(leftData);
            }
            if (rightData != '.') {
                root.treeRightNode = new Tree(rightData);
            }
        } else {
            searchNode(root.treeLeftNode, nodeData, leftData, rightData);
            searchNode(root.treeRightNode, nodeData, leftData, rightData);
        }
    }
}

public class TreeTraversal {
    static void preOrder(Tree tree) {
        System.out.print(tree.data);
        if (tree.treeLeftNode != null) {
            preOrder(tree.treeLeftNode);
        }
        if (tree.treeRightNode != null) {
            preOrder(tree.treeRightNode);
        }
    }

    static void inOrder(Tree tree) {
        if (tree.treeLeftNode != null) {
            inOrder(tree.treeLeftNode);
        }
        System.out.print(tree.data);
        if (tree.treeRightNode != null) {
            inOrder(tree.treeRightNode);
        }
    }

    static void postOrder(Tree tree) {
        if (tree.treeLeftNode != null) {
            postOrder(tree.treeLeftNode);
        }
        if (tree.treeRightNode != null) {
            postOrder(tree.treeRightNode);
        }
        System.out.print(tree.data);
    }
}