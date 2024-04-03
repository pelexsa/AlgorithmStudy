package com.Algorithm.java.baekJoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj6198 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long result = 0;
		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < n; i++) {
			int c = Integer.parseInt(br.readLine());
			while (!s.isEmpty() && s.peek() <= c) {
				s.pop();
			}

			if (!s.isEmpty()) {
				result += s.size();
			}
			s.push(c);
		}
		System.out.println(result);
	}
}
