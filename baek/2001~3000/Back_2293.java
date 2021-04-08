package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2293 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n =Integer.parseInt(st.nextToken());
		int k =Integer.parseInt(st.nextToken());
		
		//1~10까지
		int [] dp = new int[k+1];
		dp[0] = 1;
		int temp;
		for (int i = 0; i < n; i++) {
			temp = Integer.parseInt(br.readLine());
			for (int j = 1; j < k+1; j++) {
				if(j>=temp) dp[j] += dp[j-temp];
			}
		}
			System.out.println(dp[k]);
	}
}
