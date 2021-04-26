package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_1194 {
	static int N, M;
	static char[][] map;
	static point me;
	static boolean [][][] visited; // r,c 위치에 k의 상태로 방문 여부
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][64];
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j]=temp.charAt(j);
				
				if(map[i][j]=='0') me = new point(i,j,0,0);
			}
		}
		bfs();
		
	}
	private static void bfs() {
		Queue<point> q = new LinkedList<>();
		q.add(new point(me.x,me.y,me.k,me.cnt));
		visited[me.x][me.y][0] =true;
		while(!q.isEmpty()) {
			point temp = q.poll();
			int x = temp.x;
			int y = temp.y;
			int cnt = temp.cnt;
			int key = temp.k;
			
			//1에 도착을 한경우-> 종료조건
			if (map[x][y] == '1') {
				System.out.println(cnt);
				return;
			}
			
			for (int k = 0; k < 4; k++) {
				int xx = x + dx[k];
				int yy = y + dy[k];
				if(xx<0 || yy<0 || xx>=N || yy>=M ) continue;
				if(map[xx][yy]=='#' || visited[xx][yy][key]) continue;
				if(map[xx][yy]>='a' && map[xx][yy]<='f') {
					int tkey = (1<<(map[xx][yy]-'a')) | key;
					
					if(!visited[xx][yy][tkey]) {
						visited[xx][yy][tkey] = true;
						visited[xx][yy][key] = true;
						q.add(new point(xx, yy, tkey, cnt+1));
					}
				}else if(map[xx][yy] >= 'A' && map[xx][yy] <= 'F' ) {
					int door = (1<<(map[xx][yy])-'A') & key;
					
					if(door>0) {
						visited[xx][yy][key] = true;
						q.add(new point(xx, yy, key, cnt+1));
					}
				}else {
					visited[xx][yy][key] = true;
					q.add(new point(xx, yy, key, cnt+1));
				}
			}
		}
		System.out.println(-1);
	}
	static class point{
		int x;
		int y;
		int k;
		int cnt;
		public point(int x, int y, int k,int cnt) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt=cnt;
		}
		
	}
}
