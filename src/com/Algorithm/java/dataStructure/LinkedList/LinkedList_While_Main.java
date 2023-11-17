package com.Algorithm.java.dataStructure.LinkedList;

class LinkedListWhileNode {
    int data;
    LinkedListWhileNode nextNode;

    public LinkedListWhileNode(int data) {
        this.data = data;
    }
}

public class LinkedList_While_Main {
    public static void main(String[] args) {
        WhileLinkedList list = new WhileLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.printList();
        list.insertFirst(10);
        list.insertMiddle(3, 11);
        list.insertLast(12);
        list.deleteMiddle(4);
        list.deleteWithData(11);
    }
}

class WhileLinkedList {
    LinkedListWhileNode header;

    public void printList() {
        LinkedListWhileNode node = header;
        while (node.nextNode != null) {
            System.out.printf("%d ", node.data);
            node = node.nextNode;
        }
        System.out.printf("%d ", node.data);
        System.out.println();
    }

    public void add(int data) {
        LinkedListWhileNode node = new LinkedListWhileNode(data);
        if (header == null) {
            header = node;
            return;
        }

        LinkedListWhileNode currentNode = header;
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        currentNode.nextNode = node;
    }

    public void insertFirst(int data) {
        LinkedListWhileNode node = new LinkedListWhileNode(data);
        node.nextNode = header;
        header = node;
        printList();
    }

    public void insertMiddle(int maxCount, int data) {
        LinkedListWhileNode newNode = new LinkedListWhileNode(data);
        LinkedListWhileNode previousNode = header;
        int cnt = 0;
        while (cnt != maxCount) {
            cnt++;
            previousNode = previousNode.nextNode;
        }
        LinkedListWhileNode temp = previousNode.nextNode;
        previousNode.nextNode = newNode;
        newNode.nextNode = temp;
        printList();
    }

    public void insertLast(int data) {
        LinkedListWhileNode newNode = new LinkedListWhileNode(data);
        LinkedListWhileNode currentNode = header;
        while (currentNode.nextNode != null) {
            currentNode = currentNode.nextNode;
        }
        currentNode.nextNode = newNode;
        printList();
    }

    public void deleteWithData(int data) {
        // data가 node.data랑 같을 때 삭제!
        if (header.data == data) {
            header = header.nextNode;
            return;
        }
        LinkedListWhileNode currentNode = header;
        LinkedListWhileNode preNode = null;
        while (currentNode != null && currentNode.data != data) {
            preNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        if (currentNode == null) {
            return;
        }
        preNode.nextNode = currentNode.nextNode;
        printList();
    }

    public void deleteMiddle(int maxCount) {
        LinkedListWhileNode current = header;
        LinkedListWhileNode previous = null;
        int cnt = 0;
        while (cnt != maxCount) {
            cnt++;
            previous = current;
            current = current.nextNode;
        }
        previous.nextNode = current.nextNode;
        printList();
    }
}
