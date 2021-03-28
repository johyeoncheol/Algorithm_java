package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2468 {

	static int N,min=Integer.MAX_VALUE,max=0,ans=0,tans;
	static int map[][];
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				max= map[i][j]>max?map[i][j]:max;
				min= map[i][j]<min?map[i][j]:min;
			}
		}
		
		for (int k = min-1; k < max; k++) {
			visited = new boolean[N][N];
			tans=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j] && map[i][j] > k) {
						tans++;
						dfs(i, j,k);
					}
				}
			}
			ans= ans>tans?ans:tans;
		}
		System.out.println(ans);
	}
	private static void dfs(int x, int y,int top) {
		visited[x][y]=true;
		
		for (int k = 0; k < 4; k++) {
			int xx = x+dx[k];
			int yy = y+dy[k];

			if(xx<0||xx>=N || yy<0 || yy>=N)continue;
			if(!visited[xx][yy] && map[xx][yy]>top) {
				dfs(xx,yy,top);
			}
		}
	}
}
