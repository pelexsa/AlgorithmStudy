//package com.Algorithm.java.dataStructure.Tree;
//
//class TreeNode {
//    int data;
//    TreeNode leftTreeNode;
//    TreeNode rightTreeNode;
//
//    public TreeNode(int data) {
//        this.data = data;
//    }
//}
//
//public class Tree {
//
//    /*public static void main(String[] args) {
//        int[] TreeNodeData = {6, 11, 3, 10, 2, 5};
//        TreeNode root = null;
//
//        for (int i = 0; i < TreeNodeData.length; i++) {
//            if(root == null){
//                root = new TreeNode(TreeNodeData[i]);
//            }else{
//                searchTreeNode(root, TreeNodeData[i]);
//            }
//        }
//        print(root);
//    }*/
//
//    /**
//     * 노드 생성
//     * null 반환
//     * TreeNode.data > newData 왼쪽 삽입
//     * TreeNode.data < newData 오른쪽 삽입
//     */
//    static void createTreeNode(TreeNode TreeNode, int newData){
//        if(TreeNode == null) return;
//        if(TreeNode.data > newData){
//            TreeNode newTreeNode = new TreeNode(newData);
//            TreeNode.leftTreeNode = newTreeNode;
//        }
//        if(TreeNode.data < newData){
//            TreeNode newTreeNode = new TreeNode(newData);
//            TreeNode.rightTreeNode = newTreeNode;
//        }
//    }
//
//    /**
//     * 도착한 곳이 null 경우에는 값을 insert
//     * -> 왼쪽인지 오른쪽인지 확인
//     * 왼쪽이라면 부모노드의 왼쪽에 넣어줌
//     * 오른쪽이라면 부모노드의 오른쪽에 넣어줌
//     * 도착한 곳의 데이터 > 입력할 데이터 -> 왼쪽 탐색
//     * 도착한 곳의 데이터 < 입력할 데이터 -> 오른쪽 탐색
//     */
//    static void searchTreeNode(TreeNode TreeNode, int newData) {
//        if (TreeNode == null) {
//            return;
//        }
//
//        //왼쪽으로 간 경우
//        if (TreeNode.data > newData) {
//            // 값이 없으면 insert
//            if (TreeNode.leftTreeNode == null) {
//                createTreeNode(TreeNode, newData);
//            } else {
//                // 값이 있으면 왼쪽 탐색
//                searchTreeNode(TreeNode.leftTreeNode, newData);
//            }
//        }
//
//        //오른쪽으로 간 경우
//        if (TreeNode.data < newData) {
//            // 값이 없으면 insert
//            if (TreeNode.rightTreeNode == null) {
//                createTreeNode(TreeNode, newData);
//            } else {
//                // 값이 있으면 오른쪽 탐색
//                searchTreeNode(TreeNode.rightTreeNode, newData);
//            }
//        }
//    }
//
//    /**
//     * 출력 -> 왼 -> 오
//     */
//    static void print(TreeNode TreeNode){
//        System.out.println(TreeNode.data);
//        if(TreeNode.leftTreeNode != null) print(TreeNode.leftTreeNode);
//        if(TreeNode.rightTreeNode != null) print(TreeNode.rightTreeNode);
//    }
//
//}
