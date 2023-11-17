package com.Algorithm.java.baekJoon.level.level14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1269 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        Set<Integer> a = new HashSet<>(), b = new HashSet<>();

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++)
            a.add(Integer.valueOf(st.nextToken()));

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < m; i++)
            b.add(Integer.valueOf(st.nextToken()));

        a.retainAll(b);
        System.out.println(n + m - 2 * a.size());
        br.close();
    }
}
