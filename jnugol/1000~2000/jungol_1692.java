package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jungol_1692 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N1 = Integer.parseInt(br.readLine());
		int N2 = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int temp = N2%10;
		
		sb.append(N1*temp+"\n");
		
		temp = N2%100;
		temp = temp/10;
		sb.append(N1*temp+"\n");
		
		temp = N2/100;
		sb.append(N1*temp+"\n");
		sb.append(N1*N2);
		System.out.println(sb);
	}
}
