package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back_2156 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] cups = new int[N];
		int [] dp = new int[N];
		
		for (int i = 0; i < cups.length; i++) {
			cups[i] = Integer.parseInt(br.readLine());
		}
		
		
		if(N>=1) {
			dp[0] = cups[0];
		}
		if(N>=2) {
			dp[1] = cups[0]+cups[1];
		}
		if(N>=3) {
			dp[2] = Math.max(cups[0] + cups[1], cups[1] + cups[2]);
		}			
		for (int i = 3; i < N; i++) {
			dp[i] = Math.max(dp[i-1], Math.max(dp[i-2]+cups[i], dp[i-3]+cups[i-1]+cups[i]));
		}
		System.out.println(dp[N-1]);
	}

}
