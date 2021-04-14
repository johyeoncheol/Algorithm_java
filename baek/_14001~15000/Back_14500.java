package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_14500 {

	static int C, R, ans=0;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[C][R];
		visited = new boolean[C][R];

		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < R; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				dfs(i, j, 0, 0);
				other(i,j);
			}
		}
		System.out.println(ans);
	}

	private static void other(int x, int y) {
		int wing =4;
		int min = Integer.MAX_VALUE;
		int sum = map[x][y];
		for (int k = 0; k < 4; k++) {
			int xx = x+dx[k];
			int yy = y+dy[k];
			
			if(wing<=2)return;
			
			if(xx<0 || xx>=C || yy<0 || yy>=R) {
				wing--;
				continue;
			}
			min = Math.min(min, map[xx][yy]);
			sum = sum + map[xx][yy];
		}
		if(wing == 4) {
			sum = sum - min;
		}
		ans = Math.max(ans, sum); 
	}

	private static void dfs(int x, int y, int depth, int sum) {
		if (depth == 4) {
			ans = Math.max(ans, sum);
			return;
		}

		for (int k = 0; k < 4; k++) {
			int xx = x + dx[k];
			int yy = y + dy[k];
			if (xx < 0 || yy < 0 || xx >= C || yy >= R) {				
				continue;
			}
			if (visited[xx][yy]) {				
				continue;
			}
			visited[xx][yy] = true;
			dfs(xx, yy, depth + 1, sum + map[xx][yy]);
			visited[xx][yy] = false;
		}
	}

}
