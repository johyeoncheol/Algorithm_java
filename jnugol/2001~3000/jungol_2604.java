package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jungol_2604 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		int ans =10;
		
		for (int i = 0; i < temp.length()-1; i++) {
			if(temp.charAt(i)==temp.charAt(i+1)) {
				ans=ans+5;
			}else {
				ans=ans+10;
			}
		}
		System.out.println(ans);
	}

}
