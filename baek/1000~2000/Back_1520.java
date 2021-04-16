package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_1520 {
	static int row,col;
	static int[][] map;
	static int[][] dp;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		
		map = new int[col][row];
		dp = new int[col][row];
		for (int i = 0; i < col; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < row; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
				dp[i][j]=-1;
			}
		}

		System.out.println(dfs(0,0));
	}
	private static int dfs(int x, int y) {
		if(x==col-1 && y==row-1) {
			return 1;
		}
		if(dp[x][y]!=-1) return dp[x][y];
		
		dp[x][y]=0;
		for (int k = 0; k < 4; k++) {
			int xx = x+dx[k];
			int yy = y+dy[k];
			if(xx<0||yy<0||xx>=col||yy>=row)continue;
			if(map[x][y]>map[xx][yy]) {
				dp[x][y]+=dfs(xx,yy);
			}
		}
		
		return dp[x][y];
	}

}


//package com.Back;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Back_1520 {
//	static int row,col,ans=0;
//	static int[][] map;
//	static int[] dx = {-1,1,0,0};
//	static int[] dy = {0,0,-1,1};
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		col = Integer.parseInt(st.nextToken());
//		row = Integer.parseInt(st.nextToken());
//		
//		map = new int[col][row];
//		for (int i = 0; i < col; i++) {
//			st= new StringTokenizer(br.readLine());
//			for (int j = 0; j < row; j++) {
//				map[i][j]= Integer.parseInt(st.nextToken());
//			}
//		}
//		
//		dfs(0,0);
//		System.out.println(ans);
//	}
//	private static void dfs(int x, int y) {
//		if(x==col-1 && y==row-1) {
//			ans++;
//			return;
//		}
//		for (int k = 0; k < 4; k++) {
//			int xx = x+dx[k];
//			int yy = y+dy[k];
//			if(xx<0||yy<0||xx>=col||yy>=row)continue;
//			if(map[x][y]>map[xx][yy]) {
//				dfs(xx,yy);
//			}
//		}
//	}
//
//}
