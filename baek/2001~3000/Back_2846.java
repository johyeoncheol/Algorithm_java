package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2846 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr =new int[N]; 
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int ans =0;
		int temp=0;
		for (int i = 1; i < N; i++) {
			if(arr[i-1]<arr[i]) {
				temp+= (arr[i]-arr[i-1]);
			}else {				
				temp=0;
			}
			ans = Math.max(temp, ans);
		}
		System.out.println(ans);
	}
}
