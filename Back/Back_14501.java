//package com.Back;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Back_14501 {
//
//	static int N;
//	static int[][] day;
//	static int max = 0;
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		StringTokenizer st;
//
//		N = Integer.parseInt(br.readLine());
//
//		day = new int[N][2];
//
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//
//			day[i][0] = Integer.parseInt(st.nextToken());
//			day[i][1] = Integer.parseInt(st.nextToken());
//		}
//
//		DFS(0, 0);
//
//		System.out.println(max);
//	}
//
//	static void DFS(int d, int money) {
//		if (d >= N) {
//			max = Math.max(max, money);
//			return;
//		}
//
//		int work = d + day[d][0];
//		if(work <= N) {
//			DFS(work, money + day[d][1]);
//		} else {
//			DFS(work, money);
//		}
//		
//		DFS(d+1, money);
//	}
//
//}


package com.Back;
//동적 계획법 DP 문제
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_14501 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N + 2];
		int[] P = new int[N + 2];
		int[] dp = new int[N + 2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = N; i > 0; i--) {
			int day = i + T[i]; // i번째 날의 상담기간

			if (day <= N + 1)
				dp[i] = Math.max(P[i] + dp[day], dp[i + 1]);
			else // 상담일 초과
				dp[i] = dp[i + 1];
		}

		System.out.println(dp[1]);
	}
}