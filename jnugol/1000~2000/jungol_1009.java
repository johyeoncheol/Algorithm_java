package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class jungol_1009 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N="";
		while(true) {
			N=br.readLine();
			if(N.length()==1 && N.charAt(0)-'0'==0) {
				break;
			}
			int temp=0;
			boolean flag = false;
			for (int i = N.length()-1; i >=0 ; i--) {
				if(flag==false && N.charAt(i)-'0'==0) {
					continue;
				}
				flag=true;
				temp += N.charAt(i)-'0';
				System.out.print(N.charAt(i));
			}
			System.out.print(" "+temp+"\n");
		}
	}
}
