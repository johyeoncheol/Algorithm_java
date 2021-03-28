package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_10026 {
	static int N,ans1=0,ans2=0;
	static char[][] map;
	static boolean[][] visited;
	static int []dx= {-1,1,0,0};
	static int []dy= {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = 0; j < N; j++) {
				map[i][j]=s.charAt(j);
			}
		}
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					ans1++;
					dfs(i,j);				
				}
			}
		}
		
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]=='G') {
					map[i][j]='R';
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					ans2++;
					dfs(i,j);				
				}
			}
		}
		System.out.println(ans1+" "+ans2);
	}
	private static void dfs(int x, int y) {
		visited[x][y]=true;
		for (int k = 0; k < 4; k++) {
			int xx = x + dx[k];
			int yy = y + dy[k];
			if(xx<0 || xx>=N || yy<0 || yy>=N)continue;
			if(!visited[xx][yy] && map[x][y]==map[xx][yy]) {
				dfs(xx,yy);
			}
		}
	}
}
