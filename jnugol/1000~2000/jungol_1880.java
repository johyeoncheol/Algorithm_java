package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jungol_1880 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] key = br.readLine().toCharArray();
		char[] enc = br.readLine().toCharArray();
		
		for (int i = 0; i < enc.length; i++) {
			if(enc[i]==' ') {
				sb.append(' ');
			}else if(enc[i]>=65 && enc[i]<=90) {
				//대문자의 경우 소문자 보다 32 작다
				enc[i]+=32;
				sb.append((char)(key[enc[i]-97]-32));
			}else {
				//소문자의 경우
				sb.append(key[enc[i]-97]);
			}
		}
			System.out.println(sb);
	}
}
