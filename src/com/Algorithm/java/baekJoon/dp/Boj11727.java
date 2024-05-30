package com.Algorithm.java.baekJoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11727 {
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		dp = new int[n + 2];
		for (int i = 0; i < n + 2; i++) dp[i] = -1;

		System.out.println(rec(n) % 10007);
	}

	static int rec(int n) {
		if (n == 1) return 1;
		if (n == 2) return 3;
		if (dp[n] != -1) return dp[n];

		dp[n] = (rec(n-1) + 2 * rec(n-2)) % 10007;
		return dp[n];
	}
}
