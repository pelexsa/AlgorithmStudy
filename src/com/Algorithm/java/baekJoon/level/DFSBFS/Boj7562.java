package com.Algorithm.java.baekJoon.level.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(bfs(n, br));
        }
    }

    static int bfs(int n, BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int a1 = Integer.parseInt(st.nextToken()), a2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int b1 = Integer.parseInt(st.nextToken()), b2 = Integer.parseInt(st.nextToken());
        if(a1 == b1 && a2 == b2)
            return 0;

        int[][] vis = new int[n][n];
        int[] dx = {2, 2, 1, -1, -2, -2, 1, -1};
        int[] dy = {1, -1, 2, 2, 1, -1, -2, -2};

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                vis[i][j] = -1;

        Queue<Node> Q = new LinkedList<>();
        Q.add(new Node(a1, a2));
        vis[a1][a2] = 0;

        while(!Q.isEmpty()){
            Node cur = Q.poll();
            for(int i=0; i<8; i++){
                int nx = cur.X + dx[i];
                int ny = cur.Y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if(vis[nx][ny] >= 0) continue;
                if(nx == b1 && ny == b2)
                    return vis[cur.X][cur.Y] + 1;
                Q.add(new Node(nx, ny));
                vis[nx][ny] = vis[cur.X][cur.Y] + 1;
            }
        }
        return 0;
    }

    static class Node {
        int X,Y;
        public Node (int x,int y){
            X = x;
            Y = y;
        }
    }
}