package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_1697 {
	
	static int N,K,ans;
	static int[] visited = new int[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		if(N==K) {
			System.out.println(0);
			System.exit(0);
		}
		
		bfs();
		System.out.println(visited[K]);
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		while(!q.isEmpty()) {
			int n = q.poll();
			if(n==K)break;
			if(n>0 && visited[n-1]==0) {
				q.add(n-1);
				visited[n-1]=visited[n]+1;
			}
			if(n<100000 && visited[n+1]==0) {
				q.add(n+1);
				visited[n+1] = visited[n]+1;
			}
			if(n*2<=100000 && visited[n*2]==0) {
				q.add(n*2);
				visited[n*2] = visited[n]+1;
			}
		}
	}

}
