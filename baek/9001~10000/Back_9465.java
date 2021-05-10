package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_9465 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		//테케 수 받기
		int testCase = Integer.parseInt(br.readLine());
		
		//테케 수 만큼 for문
		for (int tc = 0; tc < testCase; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			//처음에는 N개로 했는데,두칸 이전의 칸을 설정하기 위해서 1칸을 늘림
			//아니면 두번째 칸까지 미리 계산을 해놔야 한다.
			int[][] map = new int[2][N+1];
			int[][] dp = new int[2][N+1];
			
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			//첫번째는 빈칸 두번째 라인 부터 dp의 값을 만들어 준다.
			dp[0][1] += map[0][1];
			dp[1][1] += map[1][1];
			
			// 위 아래로 나눠서 점화식을 만들어 
			for (int i = 2; i <= N; i++) {
				dp[0][i]=Math.max(dp[1][i-1], dp[1][i-2])+map[0][i];
				dp[1][i]=Math.max(dp[0][i-1], dp[0][i-2])+map[1][i];
			}
			sb.append(Math.max(dp[0][N], dp[1][N])+"\n");
		}
		System.out.println(sb);
	}
}
