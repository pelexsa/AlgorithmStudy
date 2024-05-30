package com.Algorithm.java.baekJoon.dp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1463 {
	static long[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		arr = new long[n + 2];
		for (int i = 0; i < arr.length; i++) arr[i] = -1;

		System.out.println(recursion(n));
	}

	static long recursion(int n) {
		if (n == 1) return 0;
		if (arr[n] != -1) return arr[n];

		if (n % 6 == 0) {
			arr[n] = Math.min(recursion(n - 1), Math.min(recursion(n / 3), recursion(n / 2))) + 1;

		} else if (n % 3 == 0) {
			arr[n] = Math.min(recursion(n / 3), recursion(n - 1)) + 1;

		} else if (n % 2 == 0) {
			arr[n] = Math.min(recursion(n / 2), recursion(n - 1)) + 1;

		} else {
			arr[n] = recursion(n - 1) + 1;
		}

		return arr[n];
	}
}
