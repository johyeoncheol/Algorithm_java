package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Back_2210 {

	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	static int[][] map;
	static List<String> list = new ArrayList<String>(); 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[5][5];
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(i,j,0,map[i][j]+"");
			}
		}
		System.out.println(list.size());
	}

	private static void dfs(int x, int y, int d,String s) {
		if(d==6) {
			if(!list.contains(s)) { 				
				list.add(s);
			}
			return;
		}
		for (int k = 0; k < 4; k++) {
			int xx = x+dx[k];
			int yy = y+dy[k];
			if(xx<0 || xx>=5 || yy<0 || yy>=5)continue;
			dfs(xx,yy,d+1,s+map[x][y]);
		}
	}
}
