package com.back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back_10974 {
	static int N;
	static boolean[] visited;
	static int[] temp,arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		temp = new int[N];
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			temp[i] = i+1;
		}
		
		perm(0);
	}

	private static void perm(int depth) {
		if(depth == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i]) {
				continue;
			}
			visited[i] = true;
			arr[depth] = temp[i];
			perm(depth+1);
			visited[i]=false;
		}
	}
}
