package com.Algorithm.java.baekJoon.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken()), ans = 0;
        int[][] board = new int[n][m];
        int[][] vis = new int[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Node> Q = new LinkedList<>();

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                vis[i][j] = -1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int idx = 0;
            while (st.hasMoreTokens()) {
                int tmp = Integer.parseInt(st.nextToken());
                board[i][idx] = tmp;
                if (tmp == 1) {
                    Q.add(new Node(i, idx));
                    vis[i][idx] = 0;
                }
                idx++;
            }
        }

        while (!Q.isEmpty()) {
            Node cur = Q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.getX() + dx[i], ny = cur.getY() + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(vis[nx][ny] >= 0 || board[nx][ny] == -1) continue;
                Q.add(new Node(nx, ny));
                vis[nx][ny] = vis[cur.getX()][cur.getY()] + 1;
            }
        }

        for (int i = 0; i < vis.length; i++) {
            if(ans == -1) break;
            for (int j = 0; j < vis[i].length; j++) {
                if(board[i][j] == -1) continue;
                if (vis[i][j] == -1) {
                    ans = -1;
                    break;
                }
                ans = Math.max(ans, vis[i][j]);
            }
        }

        System.out.println(ans);
        br.close();
    }

    static class Node {
        private int x;
        private int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }
}

