package com.back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_2206 {
	static int N,M,ans=Integer.MAX_VALUE;
	static int[][] map;
	static int visited[][];
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new int[N][M];
		
		String tmp;
		for (int i = 0; i < N; i++) {
			tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j]= tmp.charAt(j)-'0';
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		
		bfs();
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0, 1, 0));
		visited[0][0] = 0;
		
		while(!q.isEmpty()) {
			
			Point p = q.poll();
			
			if(p.x == N-1 && p.y == M-1) {
				ans = p.move;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int xx = p.x + dx[i];
				int yy = p.y + dy[i];
				
				if(xx<0 || xx>=N || yy<0 || yy>=M) continue;
				
				if(visited[xx][yy]<=p.des) continue;
				
				if(map[xx][yy]==0) {
					visited[xx][yy] = p.des;
					q.add(new Point(xx, yy, p.move+1, p.des));
				}else {
					if(p.des==0) {
						visited[xx][yy]=p.des+1;
						q.add(new Point(xx, yy, p.move+1, p.des+1));
					}
				}
			}
		}
	}
	static class Point{
		int x;
		int y;
		int move;
		int des;
		public Point(int x, int y, int move, int des) {
			super();
			this.x = x;
			this.y = y;
			this.move = move;
			this.des = des;
		}
	}
}
