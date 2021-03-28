package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_1932 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < i+1; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
			}
		}	
		
		int temp=0;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i+1; j++) {
				if(j==0) {
					map[i][j]+=map[i-1][j];
				}else if(i==j) {
					map[i][j]+=map[i-1][j-1];
				}
				else {
					map[i][j]+=Math.max(map[i-1][j-1], map[i-1][j]);
				}
				temp = Math.max(temp, map[i][j]);
			}
		}
		System.out.println(temp);
	}

}
