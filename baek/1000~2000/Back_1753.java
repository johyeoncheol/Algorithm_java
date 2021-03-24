package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Back_1753 {
	static int pointNum,LineNum,startNum;
	static List<Node>[] list;
	static int[] dist;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		pointNum = Integer.parseInt(st.nextToken());
		LineNum = Integer.parseInt(st.nextToken());
		startNum = Integer.parseInt(br.readLine());
		
		list = new ArrayList[pointNum+1];
		dist = new int[pointNum+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < LineNum; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[start].add(new Node(end,weight));
		}
		dijkstra(startNum);
		
		for (int i = 1; i <= pointNum; i++) {
			if(dist[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(dist[i]);
			}
		}
	}

	private static void dijkstra(int s) {
		//제일 작은 간선 비용을 갖는 정점을 꺼내기 위해 각 정점을 q에 넣음
		PriorityQueue<Node> q = new PriorityQueue<>();
		boolean[] visited = new boolean[pointNum+1];
		q.add(new Node(s,0));
		dist[s] = 0;
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			int now = temp.next;
			
			if(visited[now] == true) continue;
			visited[now] = true;
			
			for (Node n : list[now]) {
				if(dist[n.next]>dist[now]+n.weight) {
					dist[n.next] = dist[now] + n.weight;
					q.add(new Node(n.next, dist[n.next]));
				}
			}
		}
	}
	//접점 정보를 저장한다.
	static class Node implements Comparable<Node> {
		int next,weight;
			
		public Node(int next, int weight) {
			super();
			this.next = next;
			this.weight = weight;
		}
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return weight-o.weight;
		}		
	}
}
