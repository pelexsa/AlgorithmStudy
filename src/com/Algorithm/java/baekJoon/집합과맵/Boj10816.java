package com.Algorithm.java.baekJoon.집합과맵;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj10816 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Map<Integer, Integer> map = new HashMap<>();
        while (st.hasMoreTokens()) {
            int t = Integer.parseInt(st.nextToken());
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        br.readLine();
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            sb.append(map.getOrDefault(Integer.parseInt(st.nextToken()), 0)).append(' ');
        }

        System.out.println(sb);
        br.close();
    }
}