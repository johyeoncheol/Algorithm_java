package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Back_1446 {
	static int[] dp;
	static HashMap<Integer, List<int[]>> hm;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		hm = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int dis = Integer.parseInt(st.nextToken());
			
			if(!hm.containsKey(to)) {
				hm.put(to, new ArrayList<>());
			}
			hm.get(to).add(new int[] {from,dis});
		}
		
		dp = new int[D+1];
		
		System.out.println(dp(D));
	}

	private static int dp(int D) {
		if(D==0) {
			return 0;
		}
		if(dp[D]!=0) {
			return dp[D];
		}
		dp[D] = dp(D-1)+1;
		
		if(hm.containsKey(D)) {
			for (int[] root : hm.get(D)) {
				dp[D] = Math.min(dp[D], dp(root[0])+root[1]);
			}
		}
		
		return dp[D];
		
	}

}
