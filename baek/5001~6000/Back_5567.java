package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_5567 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st;
		//친구간의 관계 표시를 위한 배열
		boolean [][] arr = new boolean[N+1][N+1];
		//누가 오는 동기 인지 표시 하기 위한 배열
		boolean[] visited = new boolean[N+1];
		int ans=0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = true;
			arr[b][a] = true;
		}
		
		for (int i = 2; i <=N; i++) {
			//친구인 경우
			if(arr[1][i]== true) {
				if(!visited[i]) {
					ans ++;
					visited[i]=true;
				}
				
				// 친구의 친구인 경우 찾기
				for (int j = 2; j <=N; j++) {
					if(arr[i][j]==true && !visited[j]) {
						ans ++;
						visited[j]=true;
					}
				}
			}
		}
		System.out.println(ans);
	}

}
