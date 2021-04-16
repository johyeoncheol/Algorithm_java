package com.Expert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Expert_1953 {
	static int N,M,R,C,L,map[][];
	static int[] dr= {-1,0,0,1};
	static int[] dc= {0,-1,1,0};
	static String[] type= {
			null,
			"0312", // 1: 상하좌우
			"03", //2: 상하
			"12", //3: 좌우
			"02", //4: 상우
			"32", //5: 하우 
			"31", //6: 하좌
			"01" //7: 좌하
	};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testCase; tc++) {
			st  = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("#"+tc+" "+bfs());
		}
	}
	private static int bfs() {
		int result = 0, time=1;
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M];
		
		queue.offer(new int[] {R,C});
		visited[R][C] = true;
		++result;
		
		while(time++<L) {
			int size = queue.size();
			while(size-->0) { // 동시간대 처리
				int[] current = queue.poll();
				int r = current[0];
				int c = current[1];
				String info = type[map[r][c]];
				
				for (int d = 0,length = info.length(); d<length ; d++) {
					int dir = info.charAt(d)-'0';
					int nr = r + dr[dir];
					int nc = c + dc[dir];
					
					if(nr>=0 && nr<N && nc>=0 && nc<M
							&& map[nr][nc]>0
							&& type[map[nr][nc]].contains(Integer.toString(3-dir))
							&& !visited[nr][nc]) {
						queue.offer(new int[] {nr,nc});
						visited[nr][nc] = true;
						++result;
					}
				}
			}
		}
		return result;
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
//public class Expert_1953 {
//	static int col, row , x, y, ans,T;
//	static int[][] map;
//	static boolean [][] visited;
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		int testCase = Integer.parseInt(br.readLine());
//		for (int tc = 0; tc < testCase; tc++) {
//			st  = new StringTokenizer(br.readLine());
//			col = Integer.parseInt(st.nextToken());
//			row = Integer.parseInt(st.nextToken());
//			
//			map = new int[col][row];
//			visited = new boolean[col][row];
//			
//			x = Integer.parseInt(st.nextToken());
//			y = Integer.parseInt(st.nextToken());
//			T = Integer.parseInt(st.nextToken());
//			
//			for (int i = 0; i < col; i++) {
//				st = new StringTokenizer(br.readLine());
//				for (int j = 0; j < row; j++) {
//					map[i][j]=Integer.parseInt(st.nextToken());
//				}
//			}
//			
//			bfs();
//		}
//	}
//	private static void bfs() {
//		Queue<point> q = new LinkedList<>();
//		q.add(new point(x, y));
//		ans++;
//		while(!q.isEmpty()) {
//			point temp = q.poll();
//			int x = temp.x;
//			int y = temp.y;
//			
//		}
//	}
//	static class point{
//		int x;
//		int y;
//		public point(int x, int y) {
//			super();
//			this.x = x;
//			this.y = y;
//		}
//		
//	}
//}
