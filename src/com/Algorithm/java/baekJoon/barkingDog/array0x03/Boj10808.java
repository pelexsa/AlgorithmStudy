package com.Algorithm.java.baekJoon.barkingDog.array0x03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Boj10808 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] cArr = br.readLine().toCharArray();
        int[] arr = new int[26];
        for(char c : cArr)
            arr[c-'a']++;
        StringBuilder sb = new StringBuilder();
        for(int a : arr)
            sb.append(a).append(' ');
        System.out.println(sb);
        br.close();
    }
}