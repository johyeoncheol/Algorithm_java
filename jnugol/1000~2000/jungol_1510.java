package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class jungol_1510 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		ArrayList<Paper> pa = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int tmp1 = Integer.parseInt(st.nextToken());
			int tmp2 = Integer.parseInt(st.nextToken());
			if(tmp1>tmp2) {				
				pa.add(new Paper(tmp1, tmp2));
			}else{
				pa.add(new Paper(tmp2, tmp1));
			}
		}
		Collections.sort(pa);
		int ans=0;
		int[] dp = new int [N];
		for (int i = 0; i < N; i++) {
			Paper now = pa.get(i);
			for (int j = 0; j < i; j++) {
				Paper next = pa.get(j);
				if(now.lar>=next.lar && now.sma>=next.sma) {
					dp[i]=Math.max(dp[i],dp[j]);
				}
			}
			dp[i]++;
			ans=Math.max(ans, dp[i]);
		}
		
		System.out.println(ans);
		
	}
	
	static class Paper implements Comparable<Paper>{
		int lar;
		int sma;
		public Paper(int lar, int sma) {
			super();
			this.lar = lar;
			this.sma = sma;
		}
		@Override
		public int compareTo(Paper o) {
			if(this.lar==o.lar) {
				return this.sma-o.sma;
			}
			return this.lar-o.lar;
		}
	}
}
