package com.Algorithm.java.baekJoon.level.스택큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj3015 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long result = 0;
		Stack<Person> s = new Stack<>();

		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			Person c = new Person(input, 1);

			while (!s.isEmpty() && s.peek().height <= c.height) {
				Person top = s.pop();
				result += top.cnt;

				if (top.height == c.height) {
					c.cnt += top.cnt;
				}
			}

			if (!s.isEmpty()) {
				result++;
			}
			s.push(c);
		}

		System.out.println(result);
	}

	static class Person {
		int height;
		int cnt;

		public Person(int height, int cnt) {
			this.height = height;
			this.cnt = cnt;
		}
	}
}
