package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back_16916 {
	static String S;
	static String P;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = br.readLine();
		P = br.readLine();
		KMP();
		System.out.println(ans);
	}

	private static void KMP() {
		int [] pi = getPi();
		int j = 0;
		for (int i = 0; i < S.length(); i++) {
			while(j>0 && S.charAt(i)!=P.charAt(j)) {
				j=pi[j-1];
			}
			if(S.charAt(i)==P.charAt(j)) {
				if(j==P.length()-1) {
					ans=1;
					break;
				}else {
					j++;
				}
			}
		}
	}

	private static int[] getPi() {
		int[] pi = new int[P.length()];
		int j = 0;
		for (int i = 1; i < P.length(); i++) {
			while(j>0 && P.charAt(i)!=P.charAt(j)) {
				j = pi[j-1];
			}
			if(P.charAt(i)==P.charAt(j)) {
				pi[i]=++j;
			}
		}
		return pi;
	}
}

//public class Back_16916 {
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String S = br.readLine();
//		String P = br.readLine();
//		StringBuilder sb = new StringBuilder(P);
//		int ans = 0;
//		for (int i = 0; i <= S.length()-P.length(); i++) {
//			if(S.substring(i, i+P.length()).equals(sb.toString())) {
//				ans = 1;
//				break;
//			}
//		}
//		System.out.println(ans);
//	}
//}
