package com.Algorithm.java.baekJoon.level.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj10026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] board1 = new char[n][n], board2 = new char[n][n];
        for (int i=0; i<n; i++) {
            String input = br.readLine();
            for(int j=0; j<input.length(); j++){
                char c = input.charAt(j);
                board1[i][j] = c;
                if('G'==c)
                    c = 'R';
                board2[i][j] = c;
            }
        }
        br.close();
        System.out.println(bfs(n, board1));
        System.out.println(bfs(n, board2));
    }

    static int bfs(int n, char[][] board) {
        boolean[][] vis = new boolean[n][n];
        Queue<Node> Q = new LinkedList<>();
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        int ans = 0;

        for (int i=0; i<board.length; i++) {
            for (int j=0; j < board[i].length; j++) {
                if (vis[i][j]) continue;
                vis[i][j] = true;
                Q.add(new Node(i, j));
                ans++;
                while(!Q.isEmpty()) {
                    Node cur = Q.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = cur.X + dx[k];
                        int ny = cur.Y + dy[k];
                        if (nx<0 || nx>=n || ny<0 || ny>=n) continue;
                        if (vis[nx][ny] || board[cur.X][cur.Y] != board[nx][ny]) continue;
                        vis[nx][ny] = true;
                        Q.add(new Node(nx, ny));
                    }
                }

            }
        }
        return ans;
    }

    static class Node {
        int X, Y;
        Node(int X, int Y) {
            this.X = X;
            this.Y = Y;
        }
    }
}