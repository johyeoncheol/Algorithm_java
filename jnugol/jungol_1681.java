package com.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol_1681 {
	static int N,ans=Integer.MAX_VALUE;
	static int[][] map; 
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		visited = new boolean[N];
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0,0);
	}
	private static void dfs(int x, int count,int cost) {
		if(cost>=ans) {
			return;
		}
		if(count<N) {
			if(map[x][0]!=0) {
				ans = Math.min(ans, cost+map[x][0]);
				
			}
			return;
		}
		
		for(int i =1; i<N ; i++) {
			if(map[x][i] !=0 && !visited[i]) {
				visited[i] = true;
				dfs(i,count+1,map[x][i]+cost);
				visited[i] = false;
			}
		}
	}

}
