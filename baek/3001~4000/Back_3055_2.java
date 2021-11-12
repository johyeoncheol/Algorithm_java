package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_3055_2 {
	static int R,C,cnt;
	static char[][] map;
	static Queue<point> q1 = new LinkedList<>();
	static Queue<point> q2 = new LinkedList<>();
	
	static boolean[][] check1;
	static boolean[][] check2;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		check1 = new boolean[R][C];
		check2 = new boolean[R][C];
		
		String tmp;
		for (int i = 0; i < R; i++) {
			tmp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = tmp.charAt(j);
				if(map[i][j]=='S') {
					q1.add(new point(i, j));
					check1[i][j]=true;
				}
				if(map[i][j]=='*') {
					q2.add(new point(i, j));
					check2[i][j]=true;
				}
			}
		}
		
		bfs();
		System.out.println(cnt);
	}
	
	private static void bfs() {
		while(true) {
			cnt++;
			
			for (int i = 0; i < q2.size(); i++) {
				point tmp = q2.poll();
				
				for (int j = 0; j < 4; j++) {
					int xx = tmp.x+dx[j];
					int yy = tmp.y+dy[j];
					
					if(xx>=0 && yy>=0 && xx<R && yy<C && !check2[xx][yy]) {
						if(map[xx][yy]=='.') {
							check2[xx][yy]=true;
							map[xx][yy]= '*';
							q2.add(new point(xx, yy));
						}
					}
				}
			}
			
			if(q1.size() == 0) {
				System.out.println("KAKTUS");
				System.exit(0);
			}
			
			for (int i = 0; i < q1.size(); i++) {
				point tmp = q1.poll();
				
				for (int j = 0; j < 4; j++) {
					int xx = tmp.x+dx[j];
					int yy = tmp.y+dy[j];
					
					if(xx>=0 && yy>=0 && xx<R && yy<C && !check1[xx][yy]) {
						if(map[xx][yy]=='D') {
							return;
						}
						
						if(map[xx][yy]=='.') {
							check1[xx][yy]=true;
							map[xx][yy]= 'S';
							q1.add(new point(xx,yy));
						}
					}
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
