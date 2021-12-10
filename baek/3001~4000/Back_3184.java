package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_3184 {
	static int R,C,tSheep,tWolf;
	static char[][] map;
	static boolean[][] visited;
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j]=tmp.charAt(j);
			}
		}
		
		visited = new boolean[R][C];
		
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(!visited[i][j]&&map[i][j]!='#') {
					bfs(i,j);
				}
				
			}
		}
		System.out.println(tSheep +" "+tWolf);
	}
	private static void bfs(int i, int j) {
		Queue<point> q = new LinkedList<>();
		q.add(new point(i, j));
		visited[i][j] = true;
		int sheep = 0;
		int wolf = 0;
		
		while(!q.isEmpty()) {
			point p = q.poll();
			if(map[p.x][p.y] == 'o') {
				sheep++;
			}else if(map[p.x][p.y]=='v') {
				wolf++;
			}
			for (int k = 0; k < 4; k++) {
				int xx = p.x + dx[k];
				int yy = p.y + dy[k];
				
				if(xx<0 ||xx>=R ||yy<0 || yy<=C || visited[xx][yy] || map[xx][yy]=='#')continue;
				q.add(new point(xx, yy));
				visited[xx][yy]=true;
			}
		}
		if(sheep > wolf) {
			tSheep += sheep;
		}else {
			tWolf += wolf;
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
