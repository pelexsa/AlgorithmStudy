package com.Algorithm.java.baekJoon.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11328 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++)
            System.out.println(strfry(br.readLine()));
    }

    static String strfry(String input) {
        StringTokenizer st = new StringTokenizer(input, " ");
        String s1 = st.nextToken(), s2 = st.nextToken();
        int[][] arr = new int[2][26];

        for(int i=0; i<s1.length(); i++)
            arr[0][s1.charAt(i) - 'a']++;

        for(int i=0; i<s2.length(); i++)
            arr[1][s2.charAt(i) - 'a']++;

        for(int i=0; i<26; i++)
            if(arr[0][i] != arr[1][i])
                return "Impossible";

        return "Possible";
    }
}