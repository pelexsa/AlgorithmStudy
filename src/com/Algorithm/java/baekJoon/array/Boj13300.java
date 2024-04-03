package com.Algorithm.java.baekJoon.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj13300 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()), ans = 0;
        int[] arr = new int[12];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken()), y = Integer.parseInt(st.nextToken());
            arr[(y - 1) * 2 + s]++;
        }

        for (int a : arr)
            ans += (int) Math.ceil((double) a / k);

        System.out.println(ans);
        br.close();
    }
}