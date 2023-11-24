package com.Algorithm.java.baekJoon.barkingDog.b0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] board, vis;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Node> Q = new LinkedList<>();
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine()," ");
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            board = new int[51][51]; vis = new int[51][51];

            for(int j=0; j<k; j++){
                st = new StringTokenizer(br.readLine()," ");
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                board[x][y] = 1;
            }

            int ans = 0;
            for (int a=0; a<n; a++) {
                for (int b=0; b<m; b++) {
                    if(vis[a][b] > 0 || board[a][b] == 0) continue;
                    Q.add(new Node(a,b));
                    vis[a][b] = 1;
                    ans++;
                    while(!Q.isEmpty()){
                        Node cur = Q.poll();
                        for(int c=0; c<4; c++){
                            int nx = cur.X + dx[c];
                            int ny = cur.Y + dy[c];
                            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                            if(vis[nx][ny] > 0 || board[nx][ny] == 0) continue;
                            Q.add(new Node(nx, ny));
                            vis[nx][ny] = vis[cur.X][cur.Y] + 1;
                        }
                    }
                }
            }
            System.out.println(ans);
        }
        br.close();
    }

    static class Node {
        int X, Y;
        Node(int X, int Y) {
            this.X = X;
            this.Y = Y;
        }
    }
}