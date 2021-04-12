package com.Expert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Expert_1251 {
	private static int N;
	private static long[][] adjMatrix;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= testCase; tc++) {
			N = Integer.parseInt(br.readLine());
			adjMatrix = new long[N][N];
			//x좌표
			int x[] = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			//y좌표
			int y[] = new int[N];
			for (int i = 0; i < N; i++) {
				y[i] = Integer.parseInt(st.nextToken());
			}
			
			//인접행렬 구성
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adjMatrix[i][j]= adjMatrix[j][i] = getDistance(x[i], x[j], y[i], y[j]);
				}
			}
			double E = Double.parseDouble(br.readLine());
			System.out.println("#"+tc+" "+Math.round(makeMST()*E));
		}
	}
	private static long makeMST() {
		long [] minEdge = new long[N];
		boolean[] visited = new boolean[N];
		
		Arrays.fill(minEdge, Long.MAX_VALUE);
		
		//임의의 정점을 시작점으로 만듦
		minEdge[0] = 0;
		
		PriorityQueue<Vertex> queue = new PriorityQueue<>();
		queue.offer(new Vertex(0, minEdge[0]));
		
		long result = 0; //최소신장트리 비용
		int cnt = 0; // 정점 개수
		
		while(true) {
			//2.1 신장트리에 포함되지 않은 정점중 최소간선비용의 정점 선택
			Vertex minVertex = queue.poll();
			if(visited[minVertex.no]) continue;
			
			// 2.2 신장트리에 포함시킴
			visited[minVertex.no] = true;
			result += minVertex.cost;
			if(++cnt ==N) break;
			
			// adjMatrix[minNo][i]!=0 모든 선이 연결되어 있기 때문에 연결성 여부를 확인할 필요는 없다.
			for (int i = 0; i < N; i++) {
				if(!visited[i] && minEdge[i] > adjMatrix[minVertex.no][i] ) {
					minEdge[i] = adjMatrix[minVertex.no][i];
					queue.offer(new Vertex(i,minEdge[i]));
				}
			}
		}
		return result;
	}
	static long getDistance(int x1,int x2,int y1,int y2) {
		return (long)(Math.pow(x1-x2, 2)+Math.pow(y1-y2,2));
	}
	static class Vertex implements Comparable<Vertex>{
		int no;
		long cost;
		
		public Vertex(int no, long cost) {
			super();
			this.no = no;
			this.cost = cost;
		}

		@Override
		public int compareTo(Vertex o) {
			return Long.compare(this.cost, o.cost);
		}
	}
}


/* 최소 신장 트리
 * 정점 : 섬
 * 간선 : 해저 터널
 * 
 * 1. 입력으로 들어오는 섬의 좌료를 이용하여 간선비용 계산
 * 2. MST 알고리즘 적용
 * PRIM: 정점을 중심으로 풀어나가는 알고리즘
 *  - 인접행렬 : 밀집 그래프  V
 *  - 인접리스트 : 최소 그래프  
 * Kruskal: 간선중심 - 간선리스트
 * 
 * 그래프 자료 구조
 * 1. 입접행렬
 * 2. 인접리스트
 * 3. 간선리스트
 * */

/* 해저 터널의 길이
 * 해저터널길이^2 * E
 * 100만 ^2 -> long자료형을 이용
 * */


//Prim을 이용한 풀이 PQ X
//package com.Expert;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//
//public class Expert_1251 {
//	private static int N;
//	private static long[][] adjMatrix;
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int testCase = Integer.parseInt(br.readLine());
//		
//		for (int tc = 1; tc <= testCase; tc++) {
//			N = Integer.parseInt(br.readLine());
//			adjMatrix = new long[N][N];
//			//x좌표
//			int x[] = new int[N];
//			StringTokenizer st = new StringTokenizer(br.readLine()," ");
//			for (int i = 0; i < N; i++) {
//				x[i] = Integer.parseInt(st.nextToken());
//			}
//			//y좌표
//			int y[] = new int[N];
//			for (int i = 0; i < N; i++) {
//				y[i] = Integer.parseInt(st.nextToken());
//			}
//			
//			//인접행렬 구성
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					adjMatrix[i][j]= adjMatrix[j][i] = getDistance(x[i], x[j], y[i], y[j]);
//				}
//			}
//			double E = Double.parseDouble(br.readLine());
//			System.out.println("#"+tc+" "+Math.round(makeMST()*E));
//		}
//	}
//	private static long makeMST() {
//		long [] minEdge = new long[N];
//		boolean[] visited = new boolean[N];
//		
//		Arrays.fill(minEdge, Long.MAX_VALUE);
//		
//		//임의의 정점을 시작점으로 만듦
//		minEdge[0] = 0;
//		
//		long result = 0; //최소신장트리 비용
//		int cnt = 0; // 정점 개수
//		
//		while(true) {
//			//2.1 신장트리에 포함되지 않은 정점중 최소간선비용의 정점 선택
//			long min = Long.MAX_VALUE;
//			int minNo =0;
//			for (int i = 0; i < N; i++) {
//				if(!visited[i] && min>minEdge[i]) {
//					minNo = i;
//					min = minEdge[i];
//				}
//			}
//			
//			// 2.2 신장트리에 포함시킴
//			visited[minNo] = true;
//			result += min;
//			if(++cnt ==N) break;
//			
//			// adjMatrix[minNo][i]!=0 모든 선이 연결되어 있기 때문에 연결성 여부를 확인할 필요는 없다.
//			for (int i = 0; i < N; i++) {
//				if(!visited[i] && minEdge[i] > adjMatrix[minNo][i] ) {
//					minEdge[i] = adjMatrix[minNo][i];
//				}
//			}
//		}
//		return result;
//	}
//	static long getDistance(int x1,int x2,int y1,int y2) {
//		return (long)(Math.pow(x1-x2, 2)+Math.pow(y1-y2,2));
//	}
//	
//}



