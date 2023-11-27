package com.Algorithm.java.baekJoon.level.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
                if('G'==c){
                    // 적록색맹은 board2에 추가
                }
            }
        }
        br.close();
        System.out.println(bfs(n, board1));
        System.out.println(bfs(n, board2));
    }

    static int bfs(int n, char[][] board) {
        boolean[][] vis = new boolean[n][n];

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Node> Q = new LinkedList<>();


        return 0;
    }

    static class Node {
        int X, Y;
        Node(int X, int Y) {
            this.X = X;
            this.Y = Y;
        }
    }
}