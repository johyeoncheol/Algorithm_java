package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol_1214 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long[] H = new long[N+2];
		
		for (int i = 1; i < N+1; i++) {
			H[i]=Integer.parseInt(st.nextToken());
		}
		Long R, L,ans=(long) 0;
		for (int i = 1; i < N+1; i++) {
			R=(long) 0;
			L=(long) 0;
			//오른쪽 비교
			for (int j = i+1; j < H.length; j++) {
				if(H[i]>H[j]) {
					R=H[i] *(j-i);
					break;
				}
			}
			//왼쪽
			for (int j = i-1; j > 0; j--) {
				if(H[i]>H[j]) {
					 L=H[i]*(i-1-j);
					 break;
				}
			}
			ans = Math.max(ans, R+L);
		}
		System.out.println(ans);
	}
}
