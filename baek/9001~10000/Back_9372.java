package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_9372 {
	static int N,M,ans;
	static boolean visited[];
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int tc = 0; tc < testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			ans = 0;
			
			arr = new int[N+1][N+1];
			visited = new boolean[N+1];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				arr[a][b]=1;
				arr[b][a]=1;
			}
			
			bfs();
			sb.append(ans-1+"\n");
		}
		System.out.println(sb);
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1]=true;
		while(!q.isEmpty()) {
			ans++;
			int tmp = q.poll();
			for (int i = 1; i <= N; i++) {
				if(arr[tmp][i]!=0 && !visited[i]) {
					visited[i]=true;
					q.add(i);
				}
			}
		}
	}
}
