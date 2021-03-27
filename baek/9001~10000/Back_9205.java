package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_9205 {
	static int N;
	static point[] p;
	static boolean[] visited;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < testCase; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			p = new point[N+2];
			visited = new boolean[N+2];
			
			for (int i = 0; i < N+2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				p[i] = new point(x, y);
			}
			
			bfs();
		}
		System.out.println(sb);
	}

	private static void bfs() {
		Queue<point> q = new LinkedList<>();
		q.add(p[0]);
		
		while(!q.isEmpty()) {
			point temp = q.poll();
			if(temp.x==p[N+1].x && temp.y==p[N+1].y) {
				sb.append("happy\n");
				return;
			}
			for (int i = 1; i < N+2; i++) {
				if(visited[i]==true) continue;
				if(Math.abs(temp.x-p[i].x)+Math.abs(temp.y-p[i].y)<=1000) {
					q.add(p[i]);
					visited[i]=true;
				}
			}
		}
		sb.append("sad\n");
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
