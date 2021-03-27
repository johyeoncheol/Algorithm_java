package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Back_14502 {

	static int row,col;
	static int map1[][];
	//원본을 바꾸지 않기 위한 복사본
	static int map2[][];
	static boolean visited[][];
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	
	static int ans=0;
	
	//바이러스 위치
	static ArrayList<point> virus= new ArrayList<>(); 

	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		map1 = new int[col][row];
		map2 = new int[col][row];
		visited = new boolean[col][row];
		
		for (int i = 0; i < col; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < row; j++) {
				map1[i][j]=Integer.parseInt(st.nextToken());
				if(map1[i][j]==2) {
					virus.add(new point(i, j));
				}
			}
		}
		combi(0);
		System.out.println(ans);
		
	}
	private static void combi(int cnt) {
		if(cnt==3) {

			for (int i = 0; i < col	; i++) {
				for (int j = 0; j < row; j++) {
					map2[i][j]=map1[i][j];
				}
			}
		
			for (int i = 0; i < virus.size(); i++) {
				dfs(virus.get(i).x,virus.get(i).y);
			}
			
			int temp=0;
			for (int i = 0; i < col; i++) {
				for (int j = 0; j < row; j++) {
					if(map2[i][j]==0) {
						temp++;
					}
				}
			}
			ans = temp>ans?temp:ans;
			return;
		}
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if(map1[i][j]==0) {
					map1[i][j]=1;
					combi(cnt+1);
					map1[i][j]=0;
				}
			}
		}
	}
	private static void dfs(int x, int y) {
		for (int k = 0; k < 4; k++) {
			int xx = x + dx[k];
			int yy = y + dy[k];
			if (xx >= 0 && xx < col && yy >= 0 && yy < row && map2[xx][yy] == 0) {
				map2[xx][yy] = 2;
				dfs(xx,yy);
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
