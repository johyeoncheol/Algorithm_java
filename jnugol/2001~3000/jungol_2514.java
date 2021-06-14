package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jungol_2514 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		int ans1 = 0;
		int ans2 = 0;
		for (int i = 0; i < temp.length()-2; i++) {
			if(temp.charAt(i)=='K') {
				if(temp.charAt(i+1)=='O'&& temp.charAt(i+2)=='I') {
					ans1++;
				}
			}else if(temp.charAt(i)=='I') {
				if(temp.charAt(i+1)=='O'&& temp.charAt(i+2)=='I') {
					ans2++;
				}
			}
		}
		System.out.println(ans1);
		System.out.println(ans2);
	}
}
