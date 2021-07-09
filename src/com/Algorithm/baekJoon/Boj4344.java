package com.Algorithm.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj4344 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(bf.readLine());
        StringTokenizer st;

        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int arrCnt = Integer.parseInt(st.nextToken());
            int[] arr = new int[arrCnt];

            double sum = 0;
            double check = 0;

            for (int j = 0; j < arrCnt; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
            }

            for (int j = 0; j < arrCnt; j++) {
                if (arr[j] > sum / arrCnt) check++;
            }
            System.out.printf("%.3f%%\n", (check / arrCnt) * 100);
        }
    }
}
