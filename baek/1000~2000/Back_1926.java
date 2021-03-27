package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_1926 {
	static int row, col;
	static int map[][];
	static boolean visited[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int ans1 = 0;
	static int ans2 = 0;
	static int tempans2 = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());

		map = new int[col][row];
		visited = new boolean[col][row];

		for (int i = 0; i < col; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < row; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					tempans2 = 1;
					ans1++;
					bfs(i, j);
					ans2 = ans2 < tempans2 ? tempans2 : ans2;
				}
			}
		}
		System.out.println(ans1);
		System.out.println(ans2);
	}

	private static void bfs(int x, int y) {
		Queue<point> q  = new LinkedList<>();
		q.add(new point(x, y));
		visited[x][y]=true;
		
		while(!q.isEmpty()) {
			point temp = q.poll();
			for (int k = 0; k < 4; k++) {
				int xx = temp.x + dx[k];
				int yy = temp.y + dy[k];
				
				if(xx>=0 && yy>=0 && yy<row && xx<col &&!visited[xx][yy] && map[xx][yy]==1) {
					tempans2++;
					visited[xx][yy]=true;
					q.add(new point(xx, yy));
				}
			}
		}
	}
	
	static class point{
		int x;
		int y;
		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
}
//package com.Back;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Back_1926 {
//		static int row , col;
//		static int map [][];
//		static boolean visited[][];
//		static int dx[] = {-1,1,0,0};
//		static int dy[] = {0,0,-1,1};
//		static int ans1 =0;
//		static int ans2 =0;
//		static int tempans2=0;
//		
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		col = Integer.parseInt(st.nextToken());
//		row = Integer.parseInt(st.nextToken());
//		
//		map = new int[col][row];
//		visited = new boolean[col][row];
//		
//		for (int i = 0; i < col; i++) {
//			st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < row; j++) {
//				map[i][j]=Integer.parseInt(st.nextToken());
//			}
//		}
//		
//		for (int i = 0; i < col; i++) {
//			for (int j = 0; j < row; j++) {
//				if(!visited[i][j] && map[i][j]==1) {
//					tempans2=1;
//					ans1++;
//					dfs(i,j);
//					ans2 = ans2<tempans2?tempans2:ans2;
//				}
//			}
//		}
//		System.out.println(ans1);
//		System.out.println(ans2);
//	}
//	private static void dfs(int x, int y) {
//		visited[x][y]=true;
//		for (int k = 0; k < 4; k++) {
//			int xx = x + dx[k];
//			int yy = y + dy[k];
//			
//			if(xx>=0 && yy>=0 && yy<row && xx<col &&!visited[xx][yy] && map[xx][yy]==1) {
//				tempans2++;
//				dfs(xx,yy);
//			}
//		}
//	}
//	
//}
