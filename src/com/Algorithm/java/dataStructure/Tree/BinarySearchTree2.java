package com.Algorithm.java.dataStructure.Tree;

import java.util.Arrays;

/**
 * 이진 탐색 트리 (배열 구현) 탐색 : 재귀 시간 복잡도 : 추가 O(n) 공간 복잡도 : 배열 구현은 인덱스 값이 아닌 경우 공간이 비어, 입력값에 따른 공간 복잡도 확인
 * 필요
 */
public class BinarySearchTree2 {

	public static void main(String[] args) {
		int parentNodeIdx = 1;

		BinaryTree binaryTree = new BinaryTree(10);
		binaryTree.setRoot(1);
		binaryTree.add(1, 2, true);
		binaryTree.add(1, 3, false);
		binaryTree.add(2, 4, true);
		binaryTree.add(2, 5, false);
		binaryTree.add(3, 6, true);
		binaryTree.add(3, 7, false);
		binaryTree.printTree();
		System.out.println(binaryTree.preorder(parentNodeIdx));
		System.out.println(binaryTree.inorder(parentNodeIdx));
		System.out.println(binaryTree.postorder(parentNodeIdx));
	}

	static class BinaryTree {

		int[] tree;
		int size;

		public BinaryTree(int capacity) {
			tree = new int[capacity + 1];
			Arrays.fill(tree, -1);
			size = capacity;
		}

		public void setRoot(int value) {
			tree[1] = value;
		}

		// root index를 0으로 잡는 경우 왼쪽 노드 : 오른쪽 노드 (parentIndex * 2 + 1 : parentIndex * 2 + 2)
		// root index를 1으로 잡는 경우 왼쪽 노드 : 오른쪽 노드 (parentIndex * 2 : parentIndex * 2 + 1)
		void add(int parentIndex, int value, boolean isLeft) {
			int childIndex = isLeft ? parentIndex * 2 : parentIndex * 2 + 1;

			if (childIndex <= size) {
				tree[childIndex] = value;
			} else {
				System.out.println("Index out of bounds for child");
			}
		}

		public void printTree() {
			StringBuilder sb = new StringBuilder();
			sb.append("tree : ");

			for (int i = 1; i <= size; i++) {
				if (tree[i] != -1) {
					sb.append(tree[i]).append(" ");
				}
			}
		}

		String preorder(int idx) {
			int[] nodes = this.tree;
			if (nodes.length <= idx || nodes[idx] == -1) {
				return "";
			}

			return nodes[idx] + " " + preorder(idx * 2) + preorder(idx * 2 + 1);
		}

		String inorder(int idx) {
			int[] nodes = this.tree;
			if (nodes.length <= idx || nodes[idx] == -1) {
				return "";
			}

			return inorder(idx * 2) + nodes[idx] + " " + inorder(idx * 2 + 1);
		}

		String postorder(int idx) {
			int[] nodes = this.tree;
			if (nodes.length <= idx || nodes[idx] == -1) {
				return "";
			}

			return postorder(idx * 2) + postorder(idx * 2 + 1) + nodes[idx] + " ";
		}
	}

}