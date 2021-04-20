package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_11048 {
	static int col, row;
	static int[][] map;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); 
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		map = new int[col][row];
		dp = new int[col][row];		
		
		for (int i = 0; i < col; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < row; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0]=map[0][0];
		for (int i = 1; i < col; i++) {
			dp[i][0]=dp[i-1][0]+map[i][0];
		}
		for (int i = 1; i < row; i++) {
			dp[0][i]=dp[0][i-1]+map[0][i];
		}
		for (int i = 1; i < col; i++) {
			for (int j = 1; j < row; j++) {
				dp[i][j]=map[i][j]+Math.max(dp[i-1][j-1], Math.max(dp[i][j-1], dp[i-1][j]));
			}
		}
		System.out.println(dp[col-1][row-1]);
	}
}
