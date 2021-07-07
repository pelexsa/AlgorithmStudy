package com.Algorithm.baekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1546 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(bf.readLine());
        int max = -100;
        double sum = 0.0;

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        for (int i = 0; i < cnt; i++) {
            int value = Integer.parseInt(st.nextToken());
            if(value > max) max = value;
            sum += value;
        }
        System.out.println(((sum/max)*100)/cnt);
    }
}
