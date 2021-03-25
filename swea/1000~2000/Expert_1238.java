package com.Expert;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Expert_1238 {
	static int[][] map;
	static int N, ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			int start = sc.nextInt();

			map = new int[101][101];
			for (int i = 0; i < N / 2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				map[from][to] = 1;
			}

			System.out.println("#" + tc + " " + bfs(start));
		}
	}

	private static int bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] visited = new int[101]; // 정점의 방문 여부, 몇번째로 방문한 건지 그 값도 같이 저장
		int visitSeq = 0;

		q.offer(start);
		visited[start] = 1; // 시작 정점이니까

		while (!q.isEmpty()) {
			int current = q.poll(); // 시작 정점
			for (int i = 0; i < 101; i++) {
				if (map[current][i] == 1 && visited[i] == 0) {
					q.offer(i);
					visited[i] = visited[current] + 1;
				}
			}
			visitSeq = visited[current]; //
		}
		// visitSeq: 마지막으로 처리한 정점의 방문 순서 값이 저장되어 있음
		// 제일 큰 방문 횟수값을 가지고 있음..
		for (int i = 1; i < 101; i++) {
			if (visitSeq == visited[i]) {
				ans = (ans > i) ? ans : i;
			}
		}

		return ans;
	}
}

//package com.Expert;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Expert_1238 {
//	
//	static Queue<link> q = new LinkedList<link>();
//	static int startPoint ;
//	static boolean[][] visited = new boolean[100][100];
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		for (int tc = 0; tc < 10; tc++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int num = Integer.parseInt(st.nextToken());
//			startPoint = Integer.parseInt(st.nextToken());
//			
//			st=new StringTokenizer(br.readLine());
//			for (int i = 0; i < num/2; i++) {
//				int start = Integer.parseInt(st.nextToken());
//				int end = Integer.parseInt(st.nextToken());
//				q.offer(new link(start,end));
//			}
//			
//			bfs();	
//		}
//		
//	}
//	private static void bfs() {
//		
//	}
//
//}
//class link{
//	int start;
//	int end;
//	link(int start,int end){
//		this.start = start;
//		this.end = end;
//	}
//}
