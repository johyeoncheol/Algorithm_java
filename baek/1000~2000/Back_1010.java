package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_1010 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] dp = new int[30][30];
		for (int i = 0; i < 30; i++) {
			dp[i][i]=1;
			dp[i][0]=1;
		}
		for (int i = 2; i < 30; i++) {
			for (int j = 1; j < 30; j++) {
				dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
			}
		}
		
		int testCase = Integer.parseInt(br.readLine());
		
		int N,M;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			sb.append(dp[M][N]+"\n");
		}
		System.out.println(sb);
	}
}
