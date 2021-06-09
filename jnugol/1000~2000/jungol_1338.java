package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jungol_1338 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		char[][] arr = new char[N][N];
		char start = 'A';

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j]=' ';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j =N-1 ; j >=i ; j--) {
				arr[N-j-1+i][j] = start;
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
