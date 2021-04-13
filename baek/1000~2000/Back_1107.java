package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_1107 {
	static int G,N,ans;
	static boolean[] broken;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		G = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		broken = new boolean[10];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			broken[temp] = true;
		}
		
		ans = Math.abs(G-100);
		
		for (int i = 0; i < 1000000; i++) {
			int len = chk(i);
			
			if(len !=0) {
				int cnt = Math.abs(i-G);
				if(ans>len+cnt) {
					ans = len+cnt;
				}
			}
		}
		System.out.println(ans);
	}
	private static int chk(int i) {
		
		if(i==0) {
			if(broken[0]) {				
				return 0;
			}
			else {				
				return 1;
			}
		}
		
		int len = 0;
		while(i>0) {
			if(broken[i%10]) {
				return 0;
			}
			len++;
			i /=10;
		}	
		return len;
	}
}
