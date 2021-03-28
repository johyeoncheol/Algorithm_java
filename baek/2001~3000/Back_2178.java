package com.Back;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_2178 {
	static int map[][];
	static int row , col;
	static int []dx = {-1,1,0,0};
	static int []dy = {0,0,-1,1};
	static boolean visited[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		map = new int[col][row];
		visited = new boolean[col][row];
		
		for (int i = 0; i < col; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			for (int j = 0; j < row; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}	
		bfs();
		System.out.println(map[col-1][row-1]);
	}
	private static void bfs() {
		Queue<point> q = new LinkedList<>();
		q.add(new point(0, 0));
		visited[0][0]=true;
		while(!q.isEmpty()) {
			point temp = q.poll();
			for (int k = 0; k < 4; k++) {
				int xx = temp.x + dx[k];
				int yy = temp.y + dy[k];
				
				if(xx<0 || yy<0 || xx>=col || yy>=row) continue;
				if(!visited[xx][yy] && map[xx][yy]==1) {
					visited[xx][yy]=true;
					map[xx][yy]=map[temp.x][temp.y]+1;
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
