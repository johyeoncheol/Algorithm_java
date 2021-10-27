package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_4796 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int cnt = 0;
		while(true) {
			cnt++;
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			if(L==0&&P==0&&V==0) {
				break;
			}
			int tmp = V/P;
			int tmp2 = V%P;
			
			sb.append("Case "+cnt+": "+(tmp*L+Math.min(tmp2, L))+"\n");			
		}
		System.out.println(sb);
	}

}
