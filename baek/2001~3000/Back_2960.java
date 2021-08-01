package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2960 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[N + 1];
		boolean flag = false;

		int t = 0;
		for (int i = 2; i <= N; i++) {
			if(flag==true)break;
			for (int j = i; j <= N; j+=i) {
				if(visited[j]==false) {
					t++;
					visited[j]=true;
				}
				
				if(t==K) {
					System.out.println(j);
					flag = true;
					break;
				}
			}
		}
	}
}
