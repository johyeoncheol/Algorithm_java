package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_1600 {

	static int N,row,col;
	static int [][] map;
	static boolean[][][] visited;
	
	//상상좌,상상우,상좌좌,상우우,....
	static int[] hx= {-2,-2,-1,-1,1,1,2,2};
	static int[] hy= {-1,1,-2,2,-2,+2,-1,+1};
	//상 하 좌 우
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[col][row];
		visited = new boolean [col][row][N+1];
		
		for (int i = 0; i < col; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < row; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
				
		bfs();
	}

	private static void bfs() {
		Queue<monkey> q = new LinkedList<>();
		q.add(new monkey(0,0,0,0));
		while(!q.isEmpty()) {
			for (int t = 0; t < q.size(); t++) {
				monkey mon = q.poll();
				if(mon.x == col-1 && mon.y==row-1) {
					System.out.println(mon.time);
					return;
				}
				//개로 이동을 해야 하는 경우
				for (int i = 0; i < 4; i++) {
					int xx = mon.x+dx[i];
					int yy = mon.y+dy[i];
					if(xx<0 || xx>=col || yy<0 || yy>=row || map[xx][yy]!=0 ) continue;
					if(!visited[xx][yy][mon.cnt]) {
						visited[xx][yy][mon.cnt]=true;
						q.add(new monkey(xx, yy,mon.time+1, mon.cnt));
					}
				}
				//말로 이동 가능한 경우
				if(mon.cnt+1<=N) {					
					for (int i = 0; i < 8; i++) {
						int xx = mon.x+hx[i];
						int yy = mon.y+hy[i];
						if(xx<0 || xx>=col || yy<0 || yy>=row || map[xx][yy]!=0 ) continue;
						if(!visited[xx][yy][mon.cnt+1]) {
							visited[xx][yy][mon.cnt+1]=true;
							q.add(new monkey(xx, yy,mon.time+1 ,mon.cnt+1));
						}
					}
				}
			}
		}
		System.out.println(-1);
	}

	static class monkey{
		int x;
		int y;
		int time;
		int cnt;
		public monkey(int x, int y,int time, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.time = time;
			this.cnt = cnt;
		}
	}
}
