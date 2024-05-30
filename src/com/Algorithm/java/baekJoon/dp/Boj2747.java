package com.Algorithm.java.baekJoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2747 {
	static long[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new long[n + 2];
		for (int i = 0; i < arr.length; i++)
			arr[i] = -1;

		System.out.println(fibo(n));
	}

	static long fibo(int n) {
		if(n==0) return 0;
		if(n==1) return 1;

		if (arr[n] == -1) arr[n] = fibo(n - 1) + fibo(n - 2);
		return arr[n];
	}
}
