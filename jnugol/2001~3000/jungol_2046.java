package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol_2046 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		if (M == 1) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					sb.append(i + " ");
				}
				sb.append("\n");
			}
		} else if (M == 2) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (i % 2 == 1) {
						sb.append(j + " ");
					}else {
						sb.append((N+1-j) + " ");
					}
				}
				sb.append("\n");
			}
		} else {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					sb.append(i*j + " ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
