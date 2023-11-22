package com.Algorithm.java.baekJoon.barkingDog.b0x09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj7576 {
    /**
     * 하루 지남 -> 익은 토마토 인접한 토마토 익음
     * 입력
     * M 가로 N세로
     *
     * 출력
     * 모든 토마토 익을때까지 날짜
     * 익음 : 0, 익지 않음 : -1
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

