package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_17144 {
	static int C, R, T, AirC;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	
	// 미세먼지 위치를 담는 배열리스트
	static Queue<point> arr = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[C][R];

		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < R; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					// 아래에 있는 공기청정기 위치 확인
					AirC = i;
				}
			}
		}

		for (int i = 0; i < T; i++) {
			// 미세먼지 갯수 확인 (값을 받아올때 하면 시간이 지날때 또다시 구현해야 하기 때문에 의미 없음...)
			addDust();
			// 미세먼지 확산
			spread();
			// 방향 돌려가며 공기청정기 돌려주기
			airCondi();
		}

		int ans=0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				if (map[i][j] >0) {					
					ans += map[i][j];
				}
			}
		}
		System.out.println(ans);
	}

	private static void addDust() {
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				if (map[i][j] == -1 || map[i][j] == 0)
					continue;
				// 미세먼지 모두 담기
				arr.add(new point(i, j, map[i][j]));
			}
		}
	}

	private static void spread() {
		while (!arr.isEmpty()) {
			point temp = arr.poll();
			if (temp.w < 5)
				continue;
			int dust = temp.w / 5;
			// 확산한 방향의 갯수 체크
			int cnt = 0;
			for (int k = 0; k < 4; k++) {
				int xx = temp.x + dx[k];
				int yy = temp.y + dy[k];
				if (xx < 0 || xx >= C || yy < 0 || yy >= R || map[xx][yy] == -1)
					continue;
				map[xx][yy] += dust;
				++cnt;
			}
			map[temp.x][temp.y] -= dust * cnt;
		}
	}

	private static void airCondi() {
		int firAir = AirC - 1;
		int secAir = AirC;
		// 위에 있는 공기 청정기
		for (int i = firAir - 1; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}
		for (int i = 0; i < R - 1; i++) {
			map[0][i] = map[0][i + 1];
		}
		for (int i = 0; i < firAir; i++) {
			map[i][R - 1] = map[i + 1][R - 1];
		}
		for (int i = R - 1; i > 1; i--) {
			map[firAir][i] = map[firAir][i - 1];
		}
		map[firAir][1] = 0;

		// 아래에 있는 공기 청정기
		for (int i = secAir + 1; i < C - 1; i++) {
			map[i][0] = map[i + 1][0];
		}
		for (int i = 0; i < R - 1; i++) {
			map[C - 1][i] = map[C - 1][i + 1];
		}
		for (int i = C - 1; i > secAir; i--) {
			map[i][R - 1] = map[i - 1][R - 1];
		}
		for (int i = R - 1; i > 1; i--) {
			map[secAir][i] = map[secAir][i - 1];
		}
		map[secAir][1] = 0;
	}

	static class point {
		int x;
		int y;
		int w;

		public point(int x, int y, int w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}
}
