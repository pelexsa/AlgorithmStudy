package com.Algorithm.java.baekJoon.level.DFSBFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken()), h = Integer.parseInt(st.nextToken());

        int[][][] board = new int[101][101][101];
        int[][][] dist = new int[101][101][101];
        Queue<Node> Q = new LinkedList<>();

        int[] dx = {0, 0, 1, 0, -1, 0};
        int[] dy = {0, 0, 0, 1, 0, -1};
        int[] dz = {-1, 1, 0, 0, 0, 0};

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    board[j][k][i] = tmp;
                    dist[j][k][i]  = -1;

                    if(tmp == 1){
                        Q.add(new Node(j,k,i));
                        dist[j][k][i] = 0;
                    }
                }
            }
        }

        while(!Q.isEmpty()){
            Node cur = Q.poll();
            for(int i=0; i<6; i++){
                int nx = cur.X + dx[i];
                int ny = cur.Y + dy[i];
                int nz = cur.Z + dz[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h) continue;
                if (board[nx][ny][nz] != 0 || dist[nx][ny][nz] > -1) continue;
                Q.add(new Node(nx,ny,nz));
                dist[nx][ny][nz] = dist[cur.X][cur.Y][cur.Z] + 1;
            }
        }

        int result = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board[j][k][i] > -1 && dist[j][k][i] == -1) {
                        System.out.println("-1");
                        return;
                    }
                    result = Math.max(result, dist[j][k][i]);
                }
            }
        }

        System.out.println(result);
    }

    static class Node {
        int X,Y,Z;
        public Node (int X, int Y, int Z){
            this.X = X; this.Y = Y; this.Z = Z;
        }
    }
}