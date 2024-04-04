package com.Algorithm.java.baekJoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1629 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long c = Long.parseLong(st.nextToken());

		System.out.println(pow(a, b, c));
	}

	static long pow(long a, long b, long c) {
		if (b == 0) return 1;
		if (b == 1) return a % c;

		long var = pow(a, b / 2, c);
		var = var * var % c;
		if (b % 2 == 0) return var;
		return var * (a % c) % c;
	}
}
