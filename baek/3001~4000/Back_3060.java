package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_3060 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCase = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < testCase; tc++) {
			int N = Integer.parseInt(br.readLine());
			int ans = 1;
			int sum = 0;
			
			st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 6; i++) {
				sum+=Integer.parseInt(st.nextToken());
			}
			
			while(sum<=N) {
				sum*=4;
				ans++;
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
}
