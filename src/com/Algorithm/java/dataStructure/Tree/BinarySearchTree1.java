package com.Algorithm.java.dataStructure.Tree;

/**
 * 이진 탐색 트리 (Node 구현)
 * 탐색 : 재귀
 * 부모 노드보다 작은 경우 -> 왼쪽 추가
 * 부모 노드보다 큰 경우 -> 오른쪽 추가
 *
 * 순회
 * 전위 순회 : 부모 노드 -> 왼쪽 자식 노드 -> 오른쪽 자식 노드
 * 중위 순회 : 왼쪽 자식 노드 -> 부모 노드 -> 오른쪽 자식 노드
 * 후위 순회 : 왼쪽 자식 노드 -> 오른쪽 자식 노드 -> 부모 노드
 */
public class BinarySearchTree1 {

	public static void main(String[] args) {
		Node root = new Node(20);
		root.add(10);
		root.add(30);
		root.add(5);
		root.add(15);
		root.add(25);
		root.add(35);
		root.add(3);
		root.add(7);
		root.add(13);
		root.add(18);
		root.add(23);
		root.add(28);
		root.add(33);
		root.add(37);

		root.printTraversal("preorder");
		root.printTraversal("inorder");
		root.printTraversal("postorder");
	}

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int input) {
			this.data = input;
		}

		void add(int value) {
			if (this.data > value) {
				if (this.left == null) {
					this.left = new Node(value);
				} else {
					this.left.add(value);
				}

			} else if (this.data <= value) {
				if (this.right == null) {
					this.right = new Node(value);
				} else {
					this.right.add(value);
				}

			}
		}

		void printTraversal(String type) {
			System.out.println("====== " + type + " ======");
			System.out.print(type + " : ");

			if ("preorder".equals(type))
				preorder();
			else if ("inorder".equals(type))
				inorder();
			else if ("postorder".equals(type))
				postorder();

			System.out.printf("\n\n");
		}

		void preorder() {
			System.out.print(this.data + " ");

			if (this.left != null) {
				this.left.preorder();
			}

			if (this.right != null) {
				this.right.preorder();
			}
		}

		void inorder() {
			if (this.left != null) {
				this.left.inorder();
			}

			System.out.print(this.data + " ");

			if (this.right != null) {
				this.right.inorder();
			}
		}

		void postorder() {
			if (this.left != null) {
				this.left.postorder();
			}

			if (this.right != null) {
				this.right.postorder();
			}

			System.out.print(this.data + " ");
		}
	}
}