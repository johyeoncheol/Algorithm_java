package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol_1303 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int col = Integer.parseInt(st.nextToken());
		int row = Integer.parseInt(st.nextToken());
		int start = 1;

		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				sb.append(start + " ");
				start++;
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
