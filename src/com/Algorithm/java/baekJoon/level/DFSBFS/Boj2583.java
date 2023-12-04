package com.Algorithm.java.baekJoon.level.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<Node> Q = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int t = 0; t < k; t++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken()), x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken()), x2 = Integer.parseInt(st.nextToken());

            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    board[i][j] = 1;
                    vis[i][j] = true;
                }
            }
        }

        int ans = 0;
        for (int i=0; i<vis.length; i++) {
            for (int j=0; j<vis[i].length; j++) {
                if(!vis[i][j]){
                    Q.add(new Node(i,j));
                    vis[i][j] = true;
                    ans++;
                }

                while (!Q.isEmpty()) {
                    Node cur = Q.poll();
                    for (int d = 0; d < 4; d++) {
                        int nx = cur.X + dx[d];
                        int ny = cur.Y + dy[d];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if(vis[i][j]) continue;
                        Q.add(new Node(nx, ny));
                        vis[nx][ny] = true;
                    }
                }
            }
        }

        System.out.println(ans);
    }

    static class Node {
        int X,Y;
        public Node (int X, int Y){
            this.X = X; this.Y = Y;
        }
    }
}