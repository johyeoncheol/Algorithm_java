package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_1260 {
	static int pointNum,num,startPoint;
	static boolean[][] adjMatrix;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		pointNum = Integer.parseInt(st.nextToken());
		adjMatrix = new boolean[pointNum][pointNum];
		num= Integer.parseInt(st.nextToken());
		startPoint = Integer.parseInt(st.nextToken());
		visited = new boolean[pointNum];
		
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[to-1][from-1] = adjMatrix[from-1][to-1] =true;
		}
		
		dfs(startPoint-1);
		System.out.println();
		visited = new boolean[pointNum];
		bfs();
	}

	private static void dfs(int current) {
		visited[current] = true;
		System.out.print(current+1+" ");
		for(int i = 0 ; i < pointNum;i++) {
			if(adjMatrix[current][i]&&!visited[i] ) {
				dfs(i);
			}
		}
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		//탐색 시작 정점
		int start = startPoint;
		queue.offer(start-1);
		visited[start-1] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current+1+" ");
			
			//인접정점 탐색
			for (int i = 0; i < pointNum; i++) {
				if(adjMatrix[current][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
}
