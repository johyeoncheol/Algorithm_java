package com.Expert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert_1953_2 {
	static int N,M,R,C,L,map[][],visited[][];
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
			//시간을 관리하기 위해서 boolean이 아닌 int형으로 관리
			visited = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					visited[i][j]= Integer.MAX_VALUE; //최소값 갱신위해 맥스값으로 초기화
				}
			}
			
			visited[R][C] = 1;
			dfs(R,C,1);
			System.out.println("#"+tc+" "+getCount());
		}
	}
	private static int getCount() {
		int count = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(visited[r][c]!=Integer.MAX_VALUE)++count;
			}
		}
		return count;
	}
	private static void dfs(int r, int c, int time) {
		visited[r][c] = time;
		if(time == L)return;
		
		//현 구조물의 타입으로 이동가능한 방향의 정보
		String info = type[map[r][c]];
		
		for (int d = 0,length = info.length(); d<length ; d++) {
			int dir = info.charAt(d)-'0';
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			if(nr>=0 && nr<N && nc>=0 && nc<M
					&& map[nr][nc]>0
					&& type[map[nr][nc]].contains(Integer.toString(3-dir))
					&& visited[nr][nc]>time) {
				visited[nr][nc]=time;
				dfs(nr,nc,time+1);
			}
		}
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
