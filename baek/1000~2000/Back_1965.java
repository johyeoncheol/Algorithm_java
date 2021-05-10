package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//최장 증가 수열을 구하는 문제... LIS
public class Back_1965 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		
		int[] arr = new int[N+1];
		int[] dp = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < dp.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			dp[i]=1;
			for (int j = 1; j < i; j++) {
				//arr[j]<arr[i] 크기가 크면 j의 dp와 비교 대상이 될 수 있다.
				//그러나 dp[i]<dp[j]+1을 통해서 이전에 이미 더 큰 갯수를 받아서 진행을 했다면
				//이 또한 걸러준다.
				if(arr[j]<arr[i] && dp[i]<dp[j]+1) {
					dp[i] = dp[j] +1;
				}
			}
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
}
