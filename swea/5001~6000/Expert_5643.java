package com.Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert_5643 {
	static int N,M,map[][],remap[][];
	static int link,ans;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());
		
		
		for (int tc = 1; tc <=testCase; tc++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			map = new int[N+1][N+1];
			remap = new int[N+1][N+1];
			for (int i = 1; i <= M; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[x][y]=1;
				remap[y][x]=1;
			}
			ans=0;
			for (int i = 1; i <= N; i++) {
				link=0;
				visited = new boolean[N+1];
				dfs(i,map);
				visited = new boolean[N+1];
				dfs(i,remap);
				if(link==N-1)ans++;
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	private static void dfs(int cur,int[][] adj) {
		visited[cur] = true;
		// 나보다 큰 사람
		for (int i = 1; i <= N; i++) {
			if (adj[cur][i] == 1 && !visited[i]) {
				dfs(i,adj);
				link++;
			}
		}
	}

}


//package com.Expert;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Expert_5643 {
//	static int N,M,map[][];
//	static int link,ans;
//	static boolean[] visited;
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//
//		int testCase = Integer.parseInt(br.readLine());
//		
//		
//		for (int tc = 1; tc <=testCase; tc++) {
//			N = Integer.parseInt(br.readLine());
//			M = Integer.parseInt(br.readLine());
//			map = new int[N+1][N+1];
//			for (int i = 1; i <= M; i++) {
//				st = new StringTokenizer(br.readLine()," ");
//				int x = Integer.parseInt(st.nextToken());
//				int y = Integer.parseInt(st.nextToken());
//				map[x][y]=1;
//			}
//			ans=0;
//			for (int i = 1; i <= N; i++) {
//				link=0;
//				visited = new boolean[N+1];
//				dfsR(i);
//				visited = new boolean[N+1];
//				dfsL(i);
//				if(link==N-1)ans++;
//			}
//			System.out.println("#"+tc+" "+ans);
//		}
//	}
//	
//	private static void dfsR(int cur) {
//		visited[cur] = true;
//		// 나보다 큰 사람
//		for (int i = 1; i <= N; i++) {
//			if (map[cur][i] == 1 && !visited[i]) {
//				dfsR(i);
//				link++;
//			}
//		}
//	}
//	private static void dfsL(int cur) {
//		visited[cur] = true;
//		// 나보다 큰 사람
//		for (int i = 1; i <= N; i++) {
//			if (map[i][cur] == 1 && !visited[i]) {
//				dfsR(i);
//				link++;
//			}
//		}
//	}
//}

//package com.Expert;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Expert_5643 {
//	static int N,M,map[][];
//	static int link,ans;
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//
//		int testCase = Integer.parseInt(br.readLine());
//		
//		for (int tc = 1; tc <=testCase; tc++) {
//			N = Integer.parseInt(br.readLine());
//			M = Integer.parseInt(br.readLine());
//			map = new int[N+1][N+1];
//			for (int i = 1; i <= M; i++) {
//				st = new StringTokenizer(br.readLine()," ");
//				int x = Integer.parseInt(st.nextToken());
//				int y = Integer.parseInt(st.nextToken());
//				map[x][y]=1;
//			}
//			ans=0;
//			for (int i = 1; i <= N; i++) {
//				link=0;
//				bfs(i);
//				if(link==N-1)ans++;
//			}
//			System.out.println("#"+tc+" "+ans);
//		}
//	}
//	
//	private static void bfs(int k) {
//		Queue<Integer> q = new LinkedList<>();
//		boolean[] visited = new boolean[N+1];
//		q.add(k);
//		visited[k]=true;
//		//나보다 큰 사람
//		while(!q.isEmpty()) {
//			int temp = q.poll();
//			for (int i = 1; i <= N; i++) {
//				if(map[temp][i] == 1 && !visited[i]) {
//					q.add(i);
//					visited[i]= true;
//					link++;
//				}
//			}
//		}
//		visited = new boolean[N+1];
//		q.add(k);
//		visited[k]=true;
//		//나보다 작은 사람
//		while(!q.isEmpty()) {
//			int temp = q.poll();
//			for (int i = 1; i <= N; i++) {
//				if(map[i][temp] == 1 && !visited[i]) {
//					q.add(i);
//					visited[i]= true;
//					link++;
//				}
//			}
//		}
//	}
//}
