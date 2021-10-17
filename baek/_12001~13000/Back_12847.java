package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_12847 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken());
		
		long arr[] = new long[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			arr[i]=arr[i-1]+Integer.parseInt(st.nextToken());
		}
		
		long max = 0;
		
		for (int i = M; i < N+1; i++) {
			max = max>arr[i]-arr[i-M]?max:arr[i]-arr[i-M];
		}
		System.out.println(max);
	}
}
