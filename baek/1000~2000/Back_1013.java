package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back_1013 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String key = "(100+1+|01)+";
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			if(tmp.matches(key)) {
				sb.append("YES\n");
			}else {
				sb.append("NO\n");
			}
			
		}
		System.out.println(sb);
	}
}
