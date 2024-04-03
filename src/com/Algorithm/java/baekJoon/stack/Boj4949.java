package com.Algorithm.java.baekJoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            if(".".equals(input)) break;
            System.out.println(func(input));
        }
    }

    static String func(String input) {
        Stack<Character> S = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(' || c == '[') {
                S.push(c);
            } else if (c == ')' || c == ']') {
                if (S.isEmpty())
                    return "no";
                char cur = S.pop();
                if (c == ')' && cur != '(')
                    return "no";
                if (c == ']' && cur != '[')
                    return "no";
            }
        }
        if (!S.isEmpty()) return "no";
        return "yes";
    }
}
