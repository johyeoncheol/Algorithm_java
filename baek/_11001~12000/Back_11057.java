package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back_11057 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int [N][10];
		int ans=0;
		
		//1의 자리가 0~9인 경우 까지
		for (int i = 0; i <= 9; i++) {
			dp[0][i]=1;
		}
		

		for (int i = 1; i <N; i++) { //자릿수 
			for (int j = 0; j <= 9; j++) { //0~9까지 각 자리의 올수 있는 경우의 수
				for (int k = 0; k <=j; k++) {
					dp[i][j] +=dp[i-1][k]; // 10의 일의 자릿수는 0~9의 값을 다 더한 것입니다. 
				}
				dp[i][j]%=10007;
			}
		}
		
		for (int i = 0; i < 10; i++) {
			ans += dp[N-1][i];
		}
		System.out.println(ans%10007);
	}

}
