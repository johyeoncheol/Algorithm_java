package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_16942 {

	// 우 하 좌 상
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int rotate = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];

		// 값 받아오기
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int rotaGroup = N > M ? M : N;

		for (int i = 0; i < rotate; i++) {
			for (int j = 0; j < rotaGroup / 2; j++) {
				int x = j;
				int y = j;

				int temp = map[x][y];

				int dir = 0;
				while (dir < 4) {
					int xx = x + dx[dir];
					int yy = y + dy[dir];
					if(xx>=j && xx<N-j && yy>=j && yy<M-j) {
						map[x][y] = map[xx][yy];
						x = xx;
						y = yy;
					}else {
						dir++;
					}
				}
				map[j+1][j] = temp;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}


//package com.Back;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Back_16942 {
//
//	// 우 하 좌 상
//	static int[] dx = { 0, 1, 0, -1 };
//	static int[] dy = { 1, 0, -1, 0 };
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//
//		int rotate = Integer.parseInt(st.nextToken());
//		int[][] map = new int[N][M];
//
//		// 값 받아오기
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < M; j++) {
//				map[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//
//		int rotaGroup = N > M ? M : N;
//
//		for (int i = 0; i < rotate; i++) {
//			for (int j = 0; j < rotaGroup / 2; j++) {
//				int x = j;
//				int y = j;
//
//				int temp = map[x][y];
//
//				int dir = 0;
//				while (dir < 4) {
//					int xx = x + dx[dir];
//					int yy = y + dy[dir];
//					if(xx>=j && xx<N-j && yy>=j && yy<M-j) {
//						map[x][y] = map[xx][yy];
//						x = xx;
//						y = yy;
//					}else {
//						dir++;
//					}
//				}
//				map[j+1][j] = temp;
//			}
//		}
//
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j]+" ");
//			}
//			System.out.println();
//		}
//	}
//}
