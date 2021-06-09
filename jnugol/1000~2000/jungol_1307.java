package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jungol_1307 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		char [][] arr = new char[N][N];
		char start='A';
		
		for (int i = N-1; i >= 0; i--) {
			for (int j = N-1; j >=0; j--) {
				arr[j][i]=start;
				if(start=='Z') {
					start='A';
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
