package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_4963 {
	static int[][] map;
	static boolean[][] visit;
	static int w, h;

	// 상 하 좌 우 , 좌상, 우상, 좌하, 우하
	static int[] dx = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dy = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int cnt = 0;

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0)
				break;

			map = new int[h + 1][w + 1];
			visit = new boolean[h + 1][w + 1];

			for (int i = 1; i <= h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					if (map[i][j] == 1 && !visit[i][j])
						cnt += dfs(i, j);
				}
			}
			System.out.println(cnt);
		}
	}
	private static int dfs(int i, int j) {
		visit[i][j] = true;
		for (int k = 0; k < 8; k++) {
			int x = dx[k] + i;
			int y = dy[k] + j;
			if (x > 0 && y > 0 && x <= h && y <= w) {
				if (map[x][y] == 1 && !visit[x][y])
					dfs(x, y);
			}
		}
		return 1;
	}
}
