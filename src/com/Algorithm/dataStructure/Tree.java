package com.Algorithm.dataStructure;

class Node {
    int data;
    Node leftNode;
    Node rightNode;

    public Node(int data) {
        this.data = data;
    }
}

public class Tree {

    public static void main(String[] args) {
        int[] nodeData = {6, 11, 3, 10, 2, 5};
        Node root = null;

        for (int i = 0; i < nodeData.length; i++) {
            if(root == null){
                root = new Node(nodeData[i]);
            }else{
                searchNode(root, nodeData[i]);
            }
        }
        print(root);
    }
    /**
     * 노드 생성
     * null 반환
     * node.data > newData 왼쪽 삽입
     * node.data < newData 오른쪽 삽입
     */
    static void createNode(Node node, int newData){
        if(node == null) return;
        if(node.data > newData){
            Node newNode = new Node(newData);
            node.leftNode = newNode;
        }
        if(node.data < newData){
            Node newNode = new Node(newData);
            node.rightNode = newNode;
        }
    }

    /**
     * 도착한 곳이 null 경우에는 값을 insert
     * -> 왼쪽인지 오른쪽인지 확인
     * 왼쪽이라면 부모노드의 왼쪽에 넣어줌
     * 오른쪽이라면 부모노드의 오른쪽에 넣어줌
     * 도착한 곳의 데이터 > 입력할 데이터 -> 왼쪽 탐색
     * 도착한 곳의 데이터 < 입력할 데이터 -> 오른쪽 탐색
     */
    static void searchNode(Node node, int newData) {
        if (node == null) {
            return;
        }

        //왼쪽으로 간 경우
        if (node.data > newData) {
            // 값이 없으면 insert
            if (node.leftNode == null) {
                createNode(node, newData);
            } else {
                // 값이 있으면 왼쪽 탐색
                searchNode(node.leftNode, newData);
            }
        }

        //오른쪽으로 간 경우
        if (node.data < newData) {
            // 값이 없으면 insert
            if (node.rightNode == null) {
                createNode(node, newData);
            } else {
                // 값이 있으면 오른쪽 탐색
                searchNode(node.rightNode, newData);
            }
        }
    }

    /**
     * 출력 -> 왼 -> 오
     */
    static void print(Node node){
        System.out.println(node.data);
        if(node.leftNode != null) print(node.leftNode);
        if(node.rightNode != null) print(node.rightNode);
    }

}
