package com.Algorithm.java.baekJoon.barkingDog.array0x03;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3273 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), idx = 0, ans = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[n];
		while (st.hasMoreTokens())
			arr[idx++] = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(br.readLine());
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == x) {
					ans++;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}