package com.Algorithm.dataStructure.Tree;

class Node {
    int data;
    Node leftNode;
    Node rightNode;

    public Node(int data) {
        this.data = data;
    }
}

public class BinarySearchTreeMain {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insertNode(3);
        tree.insertNode(2);
        tree.insertNode(5);
        tree.insertNode(6);
        tree.insertNode(9);
        tree.insertNode(7);
        tree.insertNode(4);
        tree.printNode();
        tree.searchNode(11);
    }
}

class BinarySearchTree {
    Node root;

    void printNode() {
        if (root == null)
            return;

        Node currentNode = root;

        preOrderPrint(currentNode);
        System.out.println();
    }

    void preOrderPrint(Node currentNode) {
        System.out.printf("%d ", currentNode.data);
        if (currentNode.leftNode != null) {
            preOrderPrint(currentNode.leftNode);
        }
        if (currentNode.rightNode != null) {
            preOrderPrint(currentNode.rightNode);
        }
    }

    /*
     * while문을 이용한 insert
     */
//	void insertNode(int data) {
//		Node newNode = new Node(data);
//
//		if (root == null) {
//			root = newNode;
//			return;
//		}
//
//		Node currentNode = root;
//		while (true) {
//			if (currentNode.data > data) {
//				if (currentNode.leftNode == null) {
//					currentNode.leftNode = newNode;
//					break;
//				} else {
//					currentNode = currentNode.leftNode;
//				}
//			}
//
//			if (currentNode.data < data) {
//				if (currentNode.rightNode == null) {
//					currentNode.rightNode = newNode;
//					break;
//				} else {
//					currentNode = currentNode.rightNode;
//				}
//			}
//		}
//
//		if (currentNode.data < data) {
//			currentNode.rightNode = newNode;
//		}
//	}

    /*
     * 재귀를 이용한 insert
     */
    void insertNode(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }
        Node currentNode = root;
        insertNodeFunction(currentNode, newNode);
    }

    void insertNodeFunction(Node currentNode, Node newNode) {
        if (currentNode.data > newNode.data) {
            if (currentNode.leftNode != null) {
                insertNodeFunction(currentNode.leftNode, newNode);
            } else {
                currentNode.leftNode = newNode;
            }
        }

        if (currentNode.data < newNode.data) {
            if (currentNode.rightNode != null) {
                insertNodeFunction(currentNode.rightNode, newNode);
            } else {
                currentNode.rightNode = newNode;
            }
        }
    }

    /*
     * while문 이용 탐색
     */
//	boolean searchNode(int data) {
//		Node currentNode = root;
//		while (currentNode != null) {
//			if (currentNode.data == data) {
//				System.out.println(data + ", 해당 하는값 존재");
//				return true;
//			}
//			if (currentNode.data > data) {
//				currentNode = currentNode.leftNode;
//			}
//
//			if (currentNode.data < data) {
//				currentNode = currentNode.rightNode;
//			}
//		}
//		System.out.println(data + ", 해당 하는값 없음");
//		return false;
//	}

    // 재귀 이용 탐색
    boolean searchNode(int data) {
        Node currentNode = root;
        searchNodeFunction(currentNode, data);
        return true;
    }

    boolean searchNodeFunction(Node currentNode, int data) {
        if(currentNode.data == data) {
            System.out.println(data + ", 해당 하는 값 존재");
            return true;
        }
        if (currentNode.data > data) {
            if(currentNode.leftNode == null) {
                System.out.printf("검색한 값이 존재하지 않습니다.");
            }else {
                searchNodeFunction(currentNode.leftNode,data);
            }
        }

        if (currentNode.data < data) {
            if(currentNode.rightNode == null) {
                System.out.printf("검색한 값이 존재하지 않습니다.");
            }else {
                searchNodeFunction(currentNode.rightNode,data);
            }
        }
        return false;
    }
}