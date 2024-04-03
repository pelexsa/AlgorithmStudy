package com.Algorithm.java.baekJoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++)
            System.out.println(ps(br.readLine()));
    }

    static String ps(String input) {
        Stack<Character> S = new Stack<>();
        char[] arr = input.toCharArray();
        for (char c : arr)
            if (')' == c){
                if(S.isEmpty())
                    return "NO";
                else
                    S.pop();
            } else {
                S.push(c);
            }
        return S.isEmpty()?"YES":"NO";
    }
}