package com.Algorithm.java.baekJoon.level.스택큐덱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj10773 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine()), ans = 0;
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < k; i++) {
            int a = Integer.parseInt(br.readLine());
            if (a == 0) s.pop();
            else s.push(a);
        }

        for(Integer a : s)
            ans += a;

        System.out.println(ans);
    }
}
