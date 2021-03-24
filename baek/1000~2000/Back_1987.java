package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_1987 {
	
		static int R,C;
		static char[][] map;
		//ABCDE FGHIJ KLMNO PQRST UVWXY Z 26개
		static boolean[] visited = new boolean[26];
		static int [] dx = {-1,1,0,0};
		static int [] dy = {0,0,-1,1};
		static int cnt ;
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map = new char[R][];
		
		for (int i = 0; i < R; i++) {
			map[i]=br.readLine().toCharArray();
		}
		
		//0,0부터 시작 , 0회
		dfs(0,0,0);
		System.out.println(cnt);
	}

	private static void dfs(int x, int y, int count) {
		if(visited[map[x][y]-'A']) {
			//Max값 
			cnt = cnt>count?cnt:count;
			return;
		}
		//방문 한 곳은 true
		visited[map[x][y]-'A']=true;
		
		for (int i = 0; i < 4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			
			if(xx>=0 && yy>=0 &&xx<R && yy<C) {
				dfs(xx,yy,count+1);
			}
		}
		
		visited[map[x][y]-'A']=false;
	}

}
