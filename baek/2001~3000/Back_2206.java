package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_2206 {
	static int N,M,arrSize,ans=Integer.MAX_VALUE;
	static boolean visited[][][];
	static int map[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static ArrayList<point> arr = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j]= tmp.charAt(j)-'0';
				if(map[i][j]==1) {
					arr.add(new point(i, j,0));
				}
			}
		}
		
		visited = new boolean[N][M][arr.size()];
		
		for (int i = 0; i < arr.size(); i++) {
			arrSize=i;
			map[arr.get(i).x][arr.get(i).y]=0;
			bfs();
			map[arr.get(i).x][arr.get(i).y]=1;
		}
		if(ans==Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {			
			System.out.println(ans);
		}
	}

	private static void bfs() {
		Queue<point> q = new LinkedList<>();
		visited[0][0][arrSize] = true;
		q.add(new point(0,0,1));
		while(!q.isEmpty()) {
			point p = q.poll();
			if(p.x==N-1&&p.y==M-1) {
				ans=Math.min(ans, p.cnt);
				break;
			}
			
			for(int k = 0;k<4;k++) {
				int xx = dx[k]+p.x;
				int yy = dy[k]+p.y;
				if(xx<0||xx>=N||yy<0||yy>=M)continue;
				if(map[xx][yy]==0&&!visited[xx][yy][arrSize]) {
					q.add(new point(xx,yy,p.cnt+1));
				}
					
			}
		}
	}

	static class point{
		int x;
		int y;
		int cnt;
		public point(int x, int y,int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt=cnt;
		}
		
	}
}
