package com.Algorithm.java.baekJoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj17298 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		int[] arr = new int[n];
		int[] result = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		while (n-- > 0) {
			int c = arr[n];

			while (!s.isEmpty() && s.peek() <= c) {
				s.pop();
			}

			result[n] = s.isEmpty() ? -1 : s.peek();
			s.push(c);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < result.length; i++) {
			sb.append(result[i]);
			if (i < result.length - 1) {
				sb.append(" ");
			}
		}

		System.out.println(sb);
	}
}