package com.Algorithm.java.baekJoon.level.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj4179 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Node> Q1 = new LinkedList<>(); // 불
        int[][] dist1 = new int[n][m];
        Queue<Node> Q2 = new LinkedList<>(); // 지훈
        int[][] dist2 = new int[n][m];

        for (int i = 0; i < n; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                dist1[i][j] = -1;
                dist2[i][j] = -1;
                board[i][j] = arr[j];

                if (arr[j] == 'F') {
                    Q1.add(new Node(i, j));
                    dist1[i][j] = 0;
                }
                if (arr[j] == 'J') {
                    Q2.add(new Node(i, j));
                    dist2[i][j] = 0;
                }
            }
        }

        while (!Q1.isEmpty()) {
            Node cur = Q1.poll();
            for(int i=0; i<4; i++){
                int nx = cur.X + dx[i];
                int ny = cur.Y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(dist1[nx][ny] >= 0 || board[nx][ny] == '#') continue;
                dist1[nx][ny] = dist1[cur.X][cur.Y] + 1;
                Q1.add(new Node(nx, ny));
            }
        }

        while (!Q2.isEmpty()) {
            Node cur = Q2.poll();
            for(int i=0; i<4; i++){
                int nx = cur.X + dx[i];
                int ny = cur.Y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    System.out.println(dist2[cur.X][cur.Y] + 1);
                    return;
                }
                if(dist2[nx][ny] >= 0 || board[nx][ny] == '#') continue;
                if(dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[cur.X][cur.Y]+1) continue;
                dist2[nx][ny] = dist2[cur.X][cur.Y] + 1;
                Q2.add(new Node(nx, ny));
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    static class Node {
        int X, Y;

        public Node(int X, int Y) {
            this.X = X;
            this.Y = Y;
        }
    }
}