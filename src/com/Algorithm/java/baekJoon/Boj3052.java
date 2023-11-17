package com.Algorithm.java.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj3052 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10];
        int[] arr2 = new int[10];
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        for (int i = 0; i< arr.length; i++){
            arr2[i] = arr[i]%42;
        }





    }
}
