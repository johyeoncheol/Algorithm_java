package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_1495 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+1];
		boolean[][] dp = new boolean[N+1][M+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		dp[0][S]=true;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j <=M; j++) {
				if(dp[i-1][j]) {
					if(j+arr[i]<=M) {
						dp[i][j+arr[i]]=true;
					}
					if(j-arr[i]>=0) {
						dp[i][j-arr[i]]=true;
					}
				}
			}
		}
		
		int ans=-1;
		for (int i = 0; i <= M; i++) {
			if(dp[N][i]) {
				ans = Math.max(ans, i);
			}
		}
		
		System.out.println(ans);
	}

}
