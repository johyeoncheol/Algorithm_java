package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2616 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N+1];
		int sum[] = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			sum[i]=sum[i-1]+arr[i];
		}
		
		int cnt = Integer.parseInt(br.readLine());
		int dp[][] = new int[4][N+1];
		
		for (int i = 1; i < 4; i++) {
			for (int j = i*cnt; j <=N; j++) {
				dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-cnt]+(sum[j]-sum[j-cnt]));
			}
		}
		System.out.println(dp[3][N]);
	}
}
