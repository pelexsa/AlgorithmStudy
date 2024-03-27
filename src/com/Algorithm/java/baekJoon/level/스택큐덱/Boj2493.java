package com.Algorithm.java.baekJoon.level.스택큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj2493 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Stack<int[]> s = new Stack<>();
		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			int[] c = new int[]{Integer.parseInt(st.nextToken()), i};

			while (!s.isEmpty()) {
				int[] t = s.peek();

				if (c[0] < t[0]) {
					list.add(t[1]);
					break;
				} else {
					s.pop();
				}
			}

			if (s.isEmpty()) {
				list.add(0);
			}
			s.push(c);

		}

		StringBuilder sb = new StringBuilder();
		for (int a : list) {
			sb.append(a);
			if (list.size() > 1) {
				sb.append(" ");
			}
		}
		System.out.println(sb);
	}
}
