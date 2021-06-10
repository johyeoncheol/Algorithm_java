package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jungol_1430 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N1 = Integer.parseInt(br.readLine());
		int N2 = Integer.parseInt(br.readLine());
		int N3 = Integer.parseInt(br.readLine());
		int [] arr = new int[10];
		
		int temp = N1 * N2 * N3;
		String temp2 = String.valueOf(temp);
		for (int i = 0; i < temp2.length(); i++) {
			arr[temp2.charAt(i)-'0']++;
		}
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]+"\n");
		}
		System.out.println(sb);
	}
}
