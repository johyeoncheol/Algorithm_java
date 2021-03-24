//package com.Back;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//import com.Back.Back_2667.point;
//
//public class Back_1012 {
//	static int width, height,N,ans;
//	static int [][] map;
//	static boolean[][] visited;
//	static int dx[] = {-1,1,0,0};
//	static int dy[] = {0,0,-1,1};
//	
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int testCase = Integer.parseInt(br.readLine());
//		StringBuilder sb = new StringBuilder();
//		
//		for (int tc = 0; tc < testCase; tc++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			width = Integer.parseInt(st.nextToken());
//			height = Integer.parseInt(st.nextToken());
//			N = Integer.parseInt(st.nextToken());
//			map = new int[height][width];
//			visited = new boolean[height][width];
//			
//			for (int i = 0; i < N; i++) {
//				st = new StringTokenizer(br.readLine());
//				int x = Integer.parseInt(st.nextToken());
//				int y = Integer.parseInt(st.nextToken());
//				map[y][x]=1;
//			}
//			
//			for (int i = 0; i < height; i++) {
//				for (int j = 0; j < width; j++) {
//					if(map[i][j]==1 && !visited[i][j]) {
//						ans++;
//						bfs(i,j);
//					}
//				}
//			}
//			sb.append(ans+"\n");
//			ans=0;
//		}
//		System.out.println(sb);
//	}
//
//	private static void bfs(int i, int j) {
//		Queue<point> q = new LinkedList<>();
//		//첫 시작 넣고 방문 처리
//		q.add(new point(i,j));
//		visited[i][j]=true;
//		
//		while(!q.isEmpty()) {
//			point temp= q.poll();
//			for (int k = 0; k < 4; k++) {
//				int x = temp.x + dx[k];
//				int y = temp.y + dy[k];
//				if(x>=0 && y>=0 && x<height&& y<width) {
//					if(map[x][y] ==1 && !visited[x][y]) {
//						q.add(new point(x, y));
//						visited[x][y]=true;
//					}
//				}
//			}
//		}
//	}
//
//}

package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_1012 {
	static int width, height,N,ans;
	static int [][] map;
	static boolean[][] visited;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 0; tc < testCase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			width = Integer.parseInt(st.nextToken());
			height = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			map = new int[height][width];
			visited = new boolean[height][width];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x]=1;
			}
			
			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width; j++) {
					if(map[i][j]==1 && !visited[i][j]) {
						ans++;
						dfs(i,j);
					}
				}
			}
			sb.append(ans+"\n");
			ans=0;
		}
		System.out.println(sb);
	}
	
	private static void dfs(int i, int j) {
		visited[i][j]=true;
		for (int k = 0; k < 4; k++) {
			int x = i+dx[k];
			int y = j+dy[k];
			
			if(x>=0 && x<height && y>=0 && y<width) {
				if(map[x][y]==1&&!visited[x][y]) {
					dfs(x,y);
				}
			}
		}
	}
	
}
