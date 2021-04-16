package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_14503 {
	static int R,C,x,y,dir;
	static int [][] map;
	static boolean [][] visited;
	static int ans =0; 
	//북 동 남 서
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new boolean[R][C];
		
		st = new StringTokenizer(br.readLine());
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		dir = Integer.parseInt(st.nextToken());
		
		// 맵 입력
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		clean(x,y,dir);
		System.out.println(ans);
	}
	private static void clean(int x,int y,int dir) {
		boolean sign = false;
		
		if(!visited[x][y]) {
			ans++;
			visited[x][y]=true;
		}
		
		for (int k = 0; k < 4; k++) {
			int xx = x + dx[(dir+3)%4];
			int yy = y + dy[(dir+3)%4];
			
			if(map[xx][yy]==0 && !visited[xx][yy]) {
				clean(xx,yy,(dir+3)%4);
				sign=true;
				break;
			}
			dir = (dir+3)%4;
		}
		
		if(sign==false) {
			int xx = x+dx[(dir+2)%4];
			int yy = y+dy[(dir+2)%4];
			
			if(map[xx][yy]==0) {
				clean(xx,yy,dir);
			}
		}
	}

}
