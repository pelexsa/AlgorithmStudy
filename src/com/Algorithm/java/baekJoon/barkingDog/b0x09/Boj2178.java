package com.Algorithm.java.baekJoon.barkingDog.b0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), ans = 0;
        int[][] board = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<Node> Q = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++)
                board[i][j] = Integer.parseInt(s.substring(j, j + 1));
        }

        Q.add(new Node(0, 0, 1));
        vis[0][0] = true;
        while (!Q.isEmpty()) {
            Node node = Q.poll();
            if (node.getX() == n - 1 && node.getY() == m - 1) {
                ans = node.getStep();
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = node.getX() + dx[i];
                int ny = node.getY() + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (vis[nx][ny] || board[nx][ny] == 0) continue;
                Q.add(new Node(nx, ny, node.getStep() + 1));
                vis[nx][ny] = true;
            }
        }

        System.out.println(ans);
        br.close();
    }

    static class Node {
        private int x;
        private int y;
        private int step;

        public Node(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }

        public int getX(){
            return x;
        }

        public int getY() {
            return y;
        }

        public int getStep() {
            return step;
        }
    }
}
