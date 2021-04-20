package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_1245 {
	static int col, row,ans;
	static int[][] map;
	static boolean[][] visited;
	static boolean pick;
	//8방 탐색 
	static int dx[]= {-1,1,0,0,1,1,-1,-1};
	static int dy[]= {0,0,-1,1,1,-1,1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		map = new int[col][row];
		visited = new boolean[col][row];
		
		for (int i = 0; i < col; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < row; j++) {			
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if(!visited[i][j]) {
					pick=true;
					dfs(i,j);
					if(pick)ans++;
				}
			}
		}
		
		System.out.println(ans);
	}
	private static void dfs(int x, int y) {
		visited[x][y]=true;
		for (int k = 0; k < 8; k++) {
			int xx=x+dx[k];
			int yy=y+dy[k];
			if(xx<0||yy<0|| xx>=col|| yy>=row)continue;
			//꼭대기가 아니면 값을 더하지 않기 위해 사용
			if(map[xx][yy]>map[x][y])pick=false;
			if(!visited[xx][yy]&&map[xx][yy]==map[x][y]) {
				dfs(xx,yy);
			}
		}
	}

}
