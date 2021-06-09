package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jungol_1339 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		if(N%2==0 || N<=0 || N>100) {
			System.out.println("INPUT ERROR");
			return;
		}
		char[][] arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j]=' ';
			}
		}
		char start='A';
		
		for (int i = N/2; i >= 0; i--) {
			for (int j = 0; j < N-(i*2); j++) {
				arr[i+j][i]=start;
				if (start == 'Z') {
					start = 'A';
					continue;
				}
				start++;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j]+" ");

			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
