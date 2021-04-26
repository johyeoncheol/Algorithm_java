package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 고민 하다가 블로그 참고해서 만듬
// 다리의 갯수가 3이상이면 -1을 출력
public class Back_15684 {
	static int N,M,H;
	static int[][]map;
	static int ans;
	static boolean finish = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 세로선, 가로선, 놓을 수 있는 위치
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			//오른쪽으로  가는 경우 
			map[x][y]=1;
			//왼쪽으로 가는 경우
			map[x][y+1]=2;
		}
		//다리를 놓을 수 있는 갯수는 3번
		for (int i = 0; i <= 3; i++) {
			ans = i;
			combi(1,0);
			if(finish) break;
		}
		System.out.println(finish?ans:-1);
	}
	
	private static void combi(int x, int cnt) {
		if(finish) return;
		if(ans==cnt) {
			if(check()) finish = true;
			return;
		}
		for (int i = x; i <=H; i++) {
			for (int j = 1; j < N; j++) {
				if(map[i][j]==0 & map[i][j+1]==0) {
					map[i][j]=1;
					map[i][j+1]=2;
					combi(i,cnt+1);
					map[i][j]=0;
					map[i][j+1]=0;
				}
			}
		}
	}

	private static boolean check() {
		for (int i = 1; i <= N; i++) {
			int xx = 1;
			int yy = i;
			
			for (int j = 0; j < H; j++) {
				if(map[xx][yy]==1)yy++;
				else if(map[xx][yy]==2)yy--;
				xx++;
			}
			if(yy != i ) return false;
		}
		return true;
	}
}
