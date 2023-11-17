package com.Algorithm.java.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Queue {

    private static int[] queue = new int[10001];
    private static int firstIndex = 0;
    private static int lastIndex = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        StringTokenizer stringTokenizer;
        int testNum = Integer.parseInt(bufferedReader.readLine());

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
                case "front":
                    stringBuilder.append(front()).append("\n");
                    break;
                case "back":
                    stringBuilder.append(back()).append("\n");
                    break;
            }

        }

        System.out.println(stringBuilder);
    }

    // 정수 X를 큐에 넣는 연산
    public static void push(int num) {
        queue[lastIndex] = num;
        lastIndex++;
    };

    // 큐에서 firstIndex 값을 빼고 출력, 없을 경우 -1
    public static int pop() {
        if (empty() == 1) {
            return -1;
        } else {
            int res = queue[firstIndex];
            queue[firstIndex] = 0;
            firstIndex++;
            return res;
        }
    };

    // 큐 정수의 개수 출력
    public static int size() {
        return lastIndex-firstIndex;
    };

    // 큐가 비어 있는지 확인
    public static int empty() {
        if (firstIndex == lastIndex) {
            return 1;
        } else {
            return 0;
        }
    };

    // 큐에서 맨앞 값 출력
    public static int front() {
        if (empty() == 1) {
            return -1;
        } else {
            return queue[firstIndex];
        }
    };

    // 큐에서 맨뒤 값 출력
    public static int back() {
        if (empty() == 1) {
            return -1;
        } else {
            return queue[lastIndex-1];
        }
    };
}