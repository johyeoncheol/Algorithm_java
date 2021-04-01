package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_7576 {
	static int col, row,ans=0;
	static int[][] map;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static Queue<point> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[col][row];
		
		for (int i = 0; i < col; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < row; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					q.add(new point(i, j, 0));
				}
			}
		}
		bfs();
		
		if(check()) {
			System.out.println(ans);
		}else {
			System.out.println(-1);
		}
	}
	private static boolean check() {
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if(map[i][j]==0) {
					return false;
				}
			}
		}
		return true;
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			point temp = q.poll();
			ans=temp.day;
			for (int k = 0; k < 4; k++) {
				int xx= temp.x+dx[k];
				int yy= temp.y+dy[k];
				
				if(xx<0 || xx>=col || yy<0 || yy>=row)continue;
				if(map[xx][yy]==0) {
					map[xx][yy]=1;
					q.add(new point(xx, yy, ans+1));
				}
			}
		}
	}
	static class point{
		int x;
		int y;
		int day;
		public point(int x, int y,int day) {
			super();
			this.x = x;
			this.y = y;
			this.day=day;
		}
		
	}
}
