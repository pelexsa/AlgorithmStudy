package com.Algorithm.java.baekJoon.level.집합과맵;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj10815 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            int t = Integer.parseInt(st.nextToken());
            map.put(t, map.getOrDefault(t + 1, 1));
        }

        br.readLine();
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            if(map.containsKey(Integer.parseInt(st.nextToken())))
                sb.append(1).append(' ');
            else
                sb.append(0).append(' ');
        }

        System.out.println(sb);
        br.close();
    }
}
