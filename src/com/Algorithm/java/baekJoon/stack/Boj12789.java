package com.Algorithm.java.baekJoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    br.readLine();
	    String r = func(br);
		System.out.print(r);
    }

    static String func(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    Queue<Integer> q = new LinkedList<>();
	    Stack<Integer> s = new Stack<>();
		while(st.hasMoreTokens())
			q.add(Integer.parseInt(st.nextToken()));

	    int seq = 1;
		while(!q.isEmpty()){
			s.push(q.poll());
			while (!s.isEmpty() && seq == s.peek()) {
				s.pop();
				seq++;
			}
		}

	    return s.isEmpty() ? "Nice" : "Sad";
    }
}