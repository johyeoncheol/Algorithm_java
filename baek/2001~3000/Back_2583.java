package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back_2583 {
	static int col,row,N,area;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	
	static PriorityQueue<Integer> ans = new PriorityQueue<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuffer sb = new StringBuffer();
		
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[col][row];
		visited = new boolean[col][row];
		for (int k = 0; k < N; k++) {
			st = new StringTokenizer(br.readLine());
			int startY = Integer.parseInt(st.nextToken());
			int startX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			for (int i = startX; i < endX; i++) {
				for (int j = startY; j < endY; j++) {
					map[i][j]=1;
				}
			}
		}
		
		int count=0;
		for (int i = 0; i < col; i++) {	
			for (int j = 0; j < row; j++) {
				if(map[i][j]==0) {
					area=0;
					count++;
					dfs(i,j);
					ans.add(area);
				}
			}
		}
		
		sb.append(count+"\n");
		while(!ans.isEmpty()) {
			sb.append(ans.poll()+" ");
		}
		System.out.println(sb);
	}

	private static void dfs(int x, int y) {
		map[x][y]=1;
		area++;
		
		for (int k = 0; k < 4; k++) {
			int xx = x + dx[k];
			int yy = y + dy[k];
			
			if(xx<0 || xx>=col || yy<0 || yy>=row)continue;
			if(map[xx][yy]==0) {
				dfs(xx,yy);
			}
		}
	}

}
