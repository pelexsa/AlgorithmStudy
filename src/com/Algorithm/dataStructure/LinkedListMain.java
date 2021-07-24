package com.Algorithm.dataStructure;

// LinkedList 만들기 - 재귀함수 이용
class LinkedListNode {
    int data;
    LinkedListNode nextNode;

    public LinkedListNode(int data) {
        this.data = data;
    }
}

public class LinkedListMain {
    public static void main(String[] args) {
        // LinkedList
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.insertFirst(10);
        list.printList();
        list.insertMiddle(3, 11);
        list.insertLast(12);
        list.deleteMidder(4);
        list.deleteWithData(11);
    }
}

class LinkedList {
    LinkedListNode header;
    LinkedListNode current;

    void printList() {
        if (header == null) return;

        // if(??) current = header;

        if (header != null) {
            System.out.print(current.data + " ");
            current = current.nextNode;
            if (current.nextNode != null) printList();
        }
    }

    void add(int data) {
        LinkedListNode newNode = new LinkedListNode(data);

        // header == null 경우
        if (header == null) {
            header = newNode;
            return;
        }

        // current == null 경우
        if (current == null) current = header;

        if (current.nextNode != null) {
            current = current.nextNode;
            add(data);
        } else {
            current.nextNode = newNode;
            // 삭제 예정
            current = header;
        }
    }

    public void insertFirst(int data) {
        LinkedListNode newNode = new LinkedListNode(data);
        newNode.nextNode = header;
        header = newNode;
        // 삭제 예정
        current = newNode;
    }

    public void insertMiddle(int count, int data) {

    }

    public void insertLast(int data) {
    }

    public void deleteMidder(int data) {
    }

    public void deleteWithData(int data) {
    }
}

