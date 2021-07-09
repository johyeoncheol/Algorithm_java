package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_11501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < testCase; tc++) {
			int cnt = Integer.parseInt(br.readLine());
			long[] sto = new long[cnt];
			long max = 0;
			long ans=0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < cnt; i++) {
				sto[i]=Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= cnt; i++) {
				if(sto[cnt-i]>max) {
					max = sto[cnt-i];
				}else {
					ans+=(max-sto[cnt-i]);
				}
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb);
	}
}
