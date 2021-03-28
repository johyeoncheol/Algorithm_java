package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Back_2631 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [] arr = new int[N];
		int [] dp = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		for (int i = 0; i < N; i++) {
			dp[i]=1;
			for (int j = 0; j < i; j++) {
				if(arr[j]<arr[i]&&dp[j]+1>dp[i]) {
					dp[i]=dp[j]+1;
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(N-dp[N-1]);
	}

}
