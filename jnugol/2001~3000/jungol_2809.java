package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class jungol_2809 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] arr= new int[10000];
		int cnt = 0;
		int N = Integer.parseInt(br.readLine());
		int M = (int)Math.sqrt(N);
		for (int i = 1; i <= M; i++) {
			if(N%i==0) {
				arr[cnt++]=i;
				//25일때 5가 두개 들어가는 것을 방지
				if(N/i !=i) {
					arr[cnt++] = (int)N/i;
				}
			}
		}
		
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]==0)continue;
			System.out.print(arr[i]+" ");
		}
	}
}
