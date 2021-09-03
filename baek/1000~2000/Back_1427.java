package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Back_1427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tmp = br.readLine();
		Integer arr[] = new Integer[tmp.length()];
		for (int i = 0; i < tmp.length(); i++) {
			arr[i]=tmp.charAt(i)-'0';
		}
		Arrays.sort(arr,Collections.reverseOrder());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			sb.append(arr[i]);
		}
		System.out.println(sb);
	}
}
