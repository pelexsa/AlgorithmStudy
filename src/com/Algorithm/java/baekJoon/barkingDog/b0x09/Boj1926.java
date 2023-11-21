package com.Algorithm.java.baekJoon.barkingDog.b0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int num = 0, mx = 0, n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        boolean[][] check = new boolean[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Node> Q;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int idx = 0;
            while (st.hasMoreTokens())
                board[i][idx++] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0 || check[i][j]) continue;
                num++;
                check[i][j] = true;
                Q = new LinkedList<>();
                Q.add(new Node(i, j));
                int area = 1;

                while (!Q.isEmpty()) {
                    Node node = Q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = node.getX() + dx[k];
                        int ny = node.getY() + dy[k];
                        if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                        if(board[nx][ny] == 0 || check[nx][ny]) continue;
                        Q.add(new Node(nx, ny));
                        check[nx][ny] = true;
                        area++;
                    }
                }

                mx = Math.max(mx, area);
            }
        }

        System.out.println(num);
        System.out.println(mx);
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

