package com.Algorithm.java.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Stack {

    private static int[] stack;
    private static int index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        StringTokenizer stringTokenizer;

        int testNum = Integer.parseInt(bufferedReader.readLine());
        stack = new int[testNum];

        while (testNum-- > 0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

            switch (stringTokenizer.nextToken()) {

                case "push":
                    push(Integer.parseInt(stringTokenizer.nextToken()));
                    break;
                case "pop":
                    stringBuilder.append(pop()).append("\n");
                    break;
                case "size":
                    stringBuilder.append(size()).append("\n");
                    break;
                case "empty":
                    stringBuilder.append(empty()).append("\n");
                    break;
                case "top":
                    stringBuilder.append(top()).append("\n");
                    break;
            }

        }

        System.out.println(stringBuilder);
    }

    public static void push(int num) {
        stack[index] = num;
        index++;
    };

    public static int pop() {
        if (empty() == 1) {
            return -1;
        } else {
            int res = stack[index - 1];
            stack[index - 1] = 0;
            index--;
            return res;

        }
    };

    public static int size() {
        return index;
    };

    public static int empty() {
        if (index <= 0) {
            return 1;
        } else {
            return 0;
        }
    };

    public static int top() {
        if (empty() == 1) {
            return -1;
        } else {
            return stack[index - 1];
        }
    };
}
