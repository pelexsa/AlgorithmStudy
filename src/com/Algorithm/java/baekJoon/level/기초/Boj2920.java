package com.Algorithm.java.baekJoon.level.기초;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2920 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = "12345678";
		String b = "87654321";
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		while (st.hasMoreTokens()) sb.append(st.nextToken());
		String ans = sb.toString();
		if(ans.equals(a)) System.out.println("ascending");
		else if(ans.equals(b)) System.out.println("descending");
		else System.out.println("mixed");
		br.close();
	}
}