package com.Algorithm.dataStructure.LinkedList;

// LinkedList 만들기 - 재귀함수 이용
class LinkedListNode {
    int data;
    LinkedListNode nextNode;

    public LinkedListNode(int data) {
        this.data = data;
    }
}

public class LinkedList_Recursion_Main {
    public static void main(String[] args) {
        // LinkedList
        LinkedList list = new LinkedList();
        list.add(1, null);
        list.add(2, null);
        list.add(3, null);
        list.add(4, null);
        list.add(5, null);
        list.add(6, null);
        list.printList(null);
        list.insertFirst(10);
        list.insertMiddle(3, 11, null, 0);
        list.insertLast(12, null);
        list.deleteMiddle(4, null, null, 0);
        list.deleteWithData(5, null, null);
    }
}

class LinkedList {
    LinkedListNode header;

    void printList(LinkedListNode current) {
        if (header == null) return;

        if (current == null) current = header;

        if (current.nextNode != null) {
            System.out.printf("%d ", current.data);
            current = current.nextNode;
            if (current.nextNode != null) {
                printList(current);
            } else {
                System.out.printf("%d ", current.data);
                System.out.println();
                return;
            }
        }
    }

    void add(int data, LinkedListNode current) {
        LinkedListNode newNode = new LinkedListNode(data);
        if (header == null) {
            header = newNode;
            return;
        }

        if (current == null) current = header;

        if (current.nextNode != null) {
            current = current.nextNode;
            add(data, current);
        } else {
            current.nextNode = newNode;
        }
    }

    public void insertFirst(int data) {
        LinkedListNode newNode = new LinkedListNode(data);
        newNode.nextNode = header;
        header = newNode;
        printList(null);
    }

    public void insertMiddle(int maxCount, int data, LinkedListNode previous, int cnt) {
        if (previous == null) previous = header;

        if (cnt != maxCount) {
            previous = previous.nextNode;
            insertMiddle(maxCount, data, previous, cnt + 1);
        } else {
            LinkedListNode newNode = new LinkedListNode(data);
            LinkedListNode temp = previous.nextNode;
            previous.nextNode = newNode;
            newNode.nextNode = temp;
            printList(null);
        }
    }

    public void insertLast(int data, LinkedListNode current) {
        add(data, current);
        printList(null);
    }

    public void deleteMiddle(int maxCount, LinkedListNode previous, LinkedListNode current, int cnt) {
        if (current == null) current = header;

        if (cnt != maxCount) {
            previous = current;
            current = current.nextNode;
            deleteMiddle(maxCount, previous, current, cnt + 1);
        } else {
            previous.nextNode = current.nextNode;
            printList(null);
        }
    }

    public void deleteWithData(int data, LinkedListNode previous, LinkedListNode current) {
        if (current == null) current = header;

        if (current.data != data) {
            previous = current;
            current = current.nextNode;
            deleteWithData(data, previous, current);
        } else {
            previous.nextNode = current.nextNode;
            printList(null);
        }
    }
}

