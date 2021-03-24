package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Back_17836 {
	static int Row , Col, timer, ans=Integer.MAX_VALUE;
	static int[][] map;
	static boolean [][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue<per> q = new LinkedList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Row = Integer.parseInt(st.nextToken());
		Col = Integer.parseInt(st.nextToken());
		timer = Integer.parseInt(st.nextToken());
		
		map = new int[Row][Col];
		visited = new boolean[Row][Col];
		
		for (int i = 0; i < Row; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < Col; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		q.add(new per(0, 0, 0));
		bfs();
		System.out.println(ans<=timer ? ans :"Fail");
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			per p = q.poll();
			if(p.x == Row-1 && p.y==Col-1) {
				ans = Math.min(ans, p.step);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int xx = p.x+dx[i];
				int yy = p.y+dy[i];
				if(xx>=0&&yy>=0 && xx<Row &&yy<Col &&map[xx][yy]!=1) {
					if(!visited[xx][yy]) {
						visited[xx][yy]=true;
						q.add(new per(xx,yy,p.step+1));
						if(map[xx][yy]==2) {
							ans =(Row-xx)+(Col-yy)+p.step-1;
						}
					}
				}
			}
		}
	}
}

class per{
	int x, y,step;
	
	per(int x,int y,int step){
		this.x=x;
		this.y=y;
		this.step=step;
	}
}
