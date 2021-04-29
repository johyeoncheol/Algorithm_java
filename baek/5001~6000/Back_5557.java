package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_5557 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		//범위를 정해줬습니다 0~20까지
		//조건에 보면 2^63-1
		long[][] dp = new long[N-1][21];
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		dp[0][arr[0]]=1;
		for (int i = 1; i < N-1; i++) {
			for (int j = 0; j < 21; j++) {
				if(dp[i-1][j]!=0) {
					if(j+arr[i]<=20) dp[i][j+arr[i]] +=dp[i-1][j];					
					if(j-arr[i]>=0) dp[i][j-arr[i]] +=dp[i-1][j];					
				}
			}
		}
		System.out.println(dp[N-2][arr[N-1]]);
	}

}
