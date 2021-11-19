package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back_1913 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];

		int a = N / 2;
		int b = N / 2;
		int l = 1;
		int n = 1;

		while (true) {
			for (int i = 0; i < l; i++) {
				arr[a][b] = n++;
				a--;
			}
			if ((n - 1) == N * N)break;
			for (int i = 0; i < l; i++) {
				arr[a][b] = n++;
				b++;
			}
			l++;
			for (int i = 0; i < l; i++) {
				arr[a][b] = n++;
				a++;
			}
			for (int i = 0; i < l; i++) {
				arr[a][b] = n++;
				b--;
			}
			l++;
		}
		StringBuilder sb = new StringBuilder();

		int x = 0;
		int y = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(arr[i][j] + " ");
				if(K == arr[i][j]) {
					x = i+1;
					y = j+1;
				}
			}
			sb.append("\n");
		}
		sb.append(x+" "+y);
		System.out.println(sb);
	}

}
