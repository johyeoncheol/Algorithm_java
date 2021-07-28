package com.back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back_5052_1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		for (int tc= 0; tc < testCase; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] st = new String[N];

			for (int i = 0; i < N; i++) {
				st[i] =  br.readLine();
			}
			
			Arrays.sort(st);
			boolean ans = false;
			for (int i = 1; i < N ; i++) {
				if(st[i-1].length()>st[i].length()) {
					String tmp = st[i-1].substring(0, st[i].length());
					if(tmp.equals(st[i])) {
						ans=true;
						break;
					}					
				}else if(st[i-1].length()<st[i].length()) {
					String tmp = st[i].substring(0, st[i-1].length());
					if(tmp.equals(st[i-1])) {
						ans=true;
						break;
					}	
				}else {
					if(st[i-1].equals(st[i])) {
						ans=true;
						break;
					}
				}
			}
			
			if(ans==true) {
				sb.append("NO\n");
			}else {
				sb.append("YES\n");
			}
		}
		System.out.println(sb);
	}
}
