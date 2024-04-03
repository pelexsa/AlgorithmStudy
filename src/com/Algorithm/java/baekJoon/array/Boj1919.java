package com.Algorithm.java.baekJoon.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1919 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[2][26];
        String s1 = br.readLine(), s2 = br.readLine();
        br.close();

        for(int i=0; i<s1.length(); i++)
            arr[0][s1.charAt(i) - 'a']++;

        for(int i=0; i<s2.length(); i++)
            arr[1][s2.charAt(i) - 'a']++;

        int ans = 0;
        for (int i = 0; i < 26; i++)
            ans += Math.abs(arr[0][i] - arr[1][i]);
        System.out.println(ans);
    }
}