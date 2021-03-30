package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back_10844 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Num = Integer.parseInt(br.readLine());
		long [][] dp = new long[Num+1][10] ;
		
		for (int i = 1; i < 10; i++) {
			dp[1][i]=1;
		}
		
		for (int i = 2; i <= Num; i++) {
			for (int j = 0; j < 10; j++) {
				if(j==0) dp[i][j] =dp[i-1][j+1]%1000000000;
				else if(j==9) dp[i][j] = dp[i-1][j-1]%1000000000;
				else dp[i][j] = (dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
			}
		}
		
		long sum=0;
		for (int i = 0; i < 10; i++) {
			sum+=dp[Num][i];
		}
		System.out.println(sum %1000000000);
	}

}
