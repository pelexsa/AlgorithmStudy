package com.Algorithm.java.baekJoon.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        int[] vis = new int[100001];
        int[] dx = {1, -1, 2};
        for (int i = 0; i < 100001; i++)
            vis[i] = -1;
        Queue<Integer> Q = new LinkedList<>();
        Q.add(n); vis[n] = 0;

        while(!Q.isEmpty()){
            int cur = Q.poll();
            if(cur==k) {
                System.out.println(vis[cur]);
                return;
            }
            for(int i=0; i<3; i++){
                int nx;
                if(i < 2) nx = cur + dx[i];
                else nx = cur * dx[i];
                if(nx < 0 || nx > 100000 || vis[nx] > 0) continue;
                Q.add(nx);
                vis[nx] = vis[cur] + 1;
            }
        }
    }
}