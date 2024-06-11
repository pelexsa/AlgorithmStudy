package com.Algorithm.java.baekJoon.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제 : [5014] 스타트링크
 * URL : https://www.acmicpc.net/problem/5014
 */
public class Boj5014 {
    static int[] mv = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int[] vis = new int[n + 1];
        Arrays.fill(vis, -1);
        int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
        mv[0] = Integer.parseInt(st.nextToken());
        mv[1] = Integer.parseInt(st.nextToken()) * -1;
        System.out.println(bfs(vis, start, end, n));
    }

    static String bfs(int[] vis, int start, int end, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = 0;

        while (!q.isEmpty()) {
            int c = q.poll();
            if(c == end) return String.valueOf(vis[c]);
            for (int i = 0; i < mv.length; i++) {
                int nx = c + mv[i];
                if(nx > n || nx < 1 || vis[nx] != -1) continue;
                q.add(nx);
                vis[nx] = vis[c] + 1;
            }
        }

        return "use the stairs";
    }

}