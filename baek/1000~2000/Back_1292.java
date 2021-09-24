package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_1292 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int [] arr = new int[1001];
		boolean flag = true;
		
		int k = 1;
		for (int i = 1; i < 1001; i++) {
			if(k==1001) break; 
			for (int j = 0; j < i; j++) {
				if(k==1001) break; 
				arr[k]=i;
				k++;
			}
		}
		
		int sum = 0;
		for (int i = A; i <= B; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}
}
