package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_2636 {

	static int row,col,cheCount=0;
	static int map[][];
	static boolean visited[][];
	//걸린시간 직전 갯수
	static int ans1=0,ans2=0;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		
		map = new int[col][row];
		
		
		for (int i = 0; i < col; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < row; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1)cheCount++;
			}
		}
		while(true) {
			if(cheCount==0) {
				break;
			}
			visited = new boolean[col][row];
			ans1++;
			ans2= cheCount;
			melChe();
		}
		System.out.println(ans1);
		System.out.println(ans2);
	}

	private static void melChe() {
		Queue<point> q = new LinkedList<>();
		q.add(new point(0,0));
		visited[0][0] = true;
		while(!q.isEmpty()) {
			point temp = q.poll();
			for (int k = 0; k < 4; k++) {
				int xx = temp.x+dx[k];
				int yy = temp.y+dy[k];
				if(xx>=0 && yy>=0 && xx<col&& yy<row && !visited[xx][yy]) {
					visited[xx][yy] = true;
					if(map[xx][yy] ==0 ) {
						q.add(new point(xx, yy));	
					}else {
						cheCount--;
						map[xx][yy] = 0;
					}
				}
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
