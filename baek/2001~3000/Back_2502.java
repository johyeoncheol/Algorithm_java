package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2502 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr= new int[D];
		
		for (int i = 1; i < K/2; i++) {
			for (int j = i+1; j < K; j++) {
				arr[0]=i;
				arr[1]=j;
				for (int k = 2; k < D; k++) {
					arr[k]=arr[k-1]+arr[k-2];
				}
				
				if(arr[D-1]==K) {
					System.out.println(arr[0]);
					System.out.println(arr[1]);
					System.exit(0);
				}
			}
		}
	}

}
