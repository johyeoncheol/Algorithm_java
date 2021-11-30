package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_7569 {

	static int N, M, H , ans;
	static int[][][] arr;
	static int dx[] = { -1, 1, 0, 0, 0, 0 };
	static int dy[] = { 0, 0, -1, 1, 0, 0 };
	static int dz[] = { 0, 0, 0, 0, -1, 1 };
	static Queue<tomato> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		arr = new int[M][N][H];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < N; k++) {
					arr[j][k][i] = Integer.parseInt(st.nextToken());
					if (arr[j][k][i] == 1)
						q.add(new tomato(j, k, i));
				}
			}
		}
		bfs();
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < N; k++) {
					if(arr[j][k][i]==0) {
						System.out.println("-1");
						System.exit(0);
					}
					ans = Math.max(ans, arr[j][k][i]);
				}
			}
		}
		System.out.println(ans-1);
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			tomato t = q.poll();

			int x = t.x;
			int y = t.y;
			int z = t.z;
			
			for (int i = 0; i < 6; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				int zz = z + dz[i];
				
				if(xx>=0 && xx<M && yy>=0 && yy<N && zz>=0 && zz<H) {
					
					if(arr[xx][yy][zz]==0) {
						q.add(new tomato(xx,yy,zz));
						arr[xx][yy][zz]=arr[x][y][z]+1;
					}
				}
			}
		}
	}

	static class tomato {
		int x;
		int y;
		int z;

		public tomato(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}

	}
}
