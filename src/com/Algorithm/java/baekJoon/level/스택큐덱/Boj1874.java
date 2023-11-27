package com.Algorithm.java.baekJoon.level.스택큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(seq(n, br));
    }

    static String seq(int n, BufferedReader br) throws IOException {
        Stack<Integer> S = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int max = 0;
        for (int i = 0; i<n; i++) {
            int x = Integer.parseInt(br.readLine());
            while (max < x) {
                S.push(++max);
                sb.append('+');
                sb.append('\n');
            }
            if (x != S.pop()) return "NO";
            sb.append('-');
            sb.append('\n');
        }
        return sb.toString();
    }
}
