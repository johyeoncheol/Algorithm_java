package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back_1916 {
	static int N, M,start,end;
	static ArrayList<point>[] arr;
	static int dist[];
	static boolean visited[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = new ArrayList[N+1];
		dist = new int[N+1];
		visited = new boolean[N+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for (int i = 0; i < N+1; i++) {
			arr[i] = new ArrayList<>(); 
		}
		
		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int fee = Integer.parseInt(st.nextToken());
			arr[from].add(new point(to, fee));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		dijkstra();
		System.out.println(dist[end]);
	}
	private static void dijkstra() {
		PriorityQueue<point> pq = new PriorityQueue<>();
		pq.add(new point(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			point p = pq.poll();
			
			if(!visited[p.x]) {
				visited[p.x] = true;
				
				for(point tmp : arr[p.x]) {
					if(dist[p.x]+tmp.w<dist[tmp.x]) {
						dist[tmp.x] = dist[p.x] + tmp.w;
						pq.offer(new point(tmp.x, dist[tmp.x]));
					}
				}
			}

		}
	}
	static class point implements Comparable<point>{
		int x;
		int w;
		public point(int x, int w) {
			super();
			this.x = x;
			this.w = w;
		}
		@Override
		public int compareTo(point o) {
			return this.w - o.w;
		}
		
	}
	
}
