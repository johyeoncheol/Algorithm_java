package com.back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_1535 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] life = new int[N+1];
		for (int i = 0; i < N; i++) {
			life[i+1]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int[] happy = new int[N+1];
		for (int i = 0; i < N; i++) {
			happy[i+1]=Integer.parseInt(st.nextToken());
		}
		
		int [] dp = new int[101];
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 0; j < 100; j++) {
				int lifesum = life[i]+99-j;
				if(lifesum<100) {
					dp[lifesum] = Math.max(dp[lifesum], dp[99-j]+happy[i]);
				}
			}
		}
		System.out.println(dp[99]);
	}
}
