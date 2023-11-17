package com.Algorithm.java.baekJoon.barkingDog.array0x03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj1475 {
    /**
     * 0 ~ 9 숫자 하나씩 (6, 9 뒤집어서 사용 가능)
     * 100만 n log n
     * 필요한 세트 최소 개수
     * 9999 2
     */

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        for (char c : br.readLine().toCharArray()) {
            if(c == '9') c = '6';
            arr[c - '0']++;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int tmp;
            if (i == 6) tmp = (arr[i] + 1) / 2;
            else tmp = arr[i];
            if(max < tmp) max = tmp;
        }

        System.out.println(max);
        br.close();
    }
}