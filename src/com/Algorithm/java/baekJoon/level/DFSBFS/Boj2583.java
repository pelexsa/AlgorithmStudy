package com.Algorithm.java.baekJoon.level.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<Node> Q = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int t = 0; t < k; t++) {   // 여기 부분 학습 필요
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken()), x2 = n-Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken()), x1 = n-Integer.parseInt(st.nextToken());
            for (int i = x1; i < x2; i++)
                for (int j = y1; j < y2; j++)
                    board[i][j] = 1;
        }

        int count = 0; List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(vis[i][j] || board[i][j] == 1) continue;
                Q.add(new Node(i,j));
                vis[i][j] = true;
                count++;

                int width = 1;
                while (!Q.isEmpty()) {
                    Node cur = Q.poll();
                    for (int d = 0; d < 4; d++) {
                        int nx = cur.X + dx[d];
                        int ny = cur.Y + dy[d];
                        if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if(vis[nx][ny] || board[nx][ny] == 1) continue;
                        Q.add(new Node(nx, ny));
                        vis[nx][ny] = true;
                        width++;
                    }
                }
                list.add(width);
            }
        }
        Collections.sort(list);
        System.out.println(count);
        list.forEach(e -> System.out.print(e + " "));
    }

    static class Node {
        int X,Y;
        public Node (int X, int Y){
            this.X = X; this.Y = Y;
        }
    }
}