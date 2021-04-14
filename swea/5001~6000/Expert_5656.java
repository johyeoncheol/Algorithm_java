package com.Expert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert_5656 {

	static int T,C,R,cnt;
	static int ans;
	static int[] pick;
	static int[][] map;
	static int[][] copy;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			T = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;
			
			
			map = new int[C][R];
			copy = new int[C][R];
			for (int i = 0; i < C; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < R; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]!=0) cnt++;
				}
			}
			for (int i = 0; i < C; i++) {
				pick[0] = i;
				combi(i,0);
			}		
		}
	}
	private static void combi(int start,int depth) {
		if(depth == T-1) {
			copy();
			for (int i = 0; i < T; i++) {
				drop(pick[i]);
				fall();
			}
		}
		for (int i = 0; i < R; i++) {
			pick[depth+1] = i;
			combi(i,depth+1);
		}
	}
	private static void fall() {
		// TODO Auto-generated method stub
		
	}
	private static void drop(int col) {
		for (int i = 0; i < C; i++) {
			if(copy[i][col]>0) {
			}
		}
	}
	private static void copy() {
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				copy[i][j] = map[i][j];
			}
		}
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
