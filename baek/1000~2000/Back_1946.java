package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_1946 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < testCase; tc++) {
			int N = Integer.parseInt(br.readLine());
			rank[] r = new rank[N];
			int min = Integer.MAX_VALUE;
			int ans = 0;
			for (int i = 0; i < N; i++) {
				st= new StringTokenizer(br.readLine());
				int first = Integer.parseInt(st.nextToken()); 
				int second = Integer.parseInt(st.nextToken()); 
				r[i] = new rank(first, second);
			}
			
			Arrays.sort(r);
			
			for (int i = 0; i < N; i++) {
				if(min>r[i].secR) {
					min=r[i].secR;
					ans++;
				}
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}

	static class rank implements Comparable<rank>{

		int firR;
		int secR;
		
		public rank(int firR, int secR) {
			super();
			this.firR = firR;
			this.secR = secR;
		}

		@Override
		public int compareTo(rank o) {
			return Integer.compare(this.firR, o.firR);
		}
		
	}
}
