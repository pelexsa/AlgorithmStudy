package com.Algorithm.java.baekJoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj11866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()),
			k = Integer.parseInt(st.nextToken()),
			c = 1;

		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		sb.append("<");

		for (int i = 1; i <= n; i++) {
			q.add(i);
		}

		while (!q.isEmpty()) {
			int t = q.poll();
			if (c++ == k) {
				c = 1;
				sb.append(t);
				if (!q.isEmpty()) {
					sb.append(", ");
				}
			} else {
				q.add(t);
			}
		}

		sb.append(">");
		System.out.println(sb);
	}
}
