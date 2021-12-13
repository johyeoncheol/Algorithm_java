package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back_1439 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		int[] count = new int[2];
		char tmp = arr[0];
		
		count[tmp-'0']++;
		for (int i = 1; i < arr.length; i++) {
			if(tmp !=arr[i]) {
				count[arr[i]-'0']++;
				tmp = arr[i];
			}
		}
		
		System.out.println(Math.min(count[0], count[1]));
	}
}
