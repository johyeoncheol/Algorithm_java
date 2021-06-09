package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class jungol_1314 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		char[][] arr = new char[N][N];
		char start = 'A';

		for (int i = 0; i <N; i++) {
			for (int j = 0; j <N; j++) {
				if(i%2==0) {					
					arr[j][i] = start;
				}else {
					arr[N-j-1][i] = start;
				}
				if (start == 'Z') {
					start = 'A';
					continue;
				}
				start++;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j] + " ");

			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
