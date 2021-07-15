package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_7562 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int strx,stry,endx,endy;
	static int[] dx = {-2,-1,2,1,2,1,-2,-1};
	static int[] dy = {1,2,1,2,-1,-2,-1,-2};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < testCase; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			
			st =new StringTokenizer(br.readLine());
			strx = Integer.parseInt(st.nextToken());
			stry = Integer.parseInt(st.nextToken());
			
			st =new StringTokenizer(br.readLine());
			endx = Integer.parseInt(st.nextToken());
			endy = Integer.parseInt(st.nextToken());
			bfs();
			System.out.println(map[endx][endy]);
		}
	}

	private static void bfs() {
		Queue<point> q= new LinkedList<>();
		q.add(new point(strx, stry));
		visited[strx][stry]=true;
		while(!q.isEmpty()) {
			point temp = q.poll();
			int x = temp.x;
			int y = temp.y;
			if(x==endx && y==endy) {
				break;
			}
			for (int i = 0; i < 8; i++) {
				int xx = x+dx[i];
				int yy = y+dy[i];
				if(xx>=0 && xx<N && yy>=0 && yy<N&&!visited[xx][yy]) {
					q.add(new point(xx,yy));
					visited[xx][yy]=true;
					map[xx][yy]=map[x][y]+1;
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
