package com.Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert_2115 {
	static int N,M,C;
	static int[][] map;
	static int[][] bottle;
	static boolean[][] visited;
	static int aSum,bSum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			bottle = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("#"+tc+" "+processCombination());
		}
	}
	private static int processCombination() {
		int result =0, aBenefit =0,bBenefit =0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= N-M; j++) { // 첫열부터 연속된 M개 채취가 가능한 열까지, 일꾼 A의 선택
				
				//선택된 M개 벌통에서 얻을 수 있는 최대 이익
				maxSum =0;
				makeMaxSubset(i, j, 0, 0, 0);
				aBenefit = maxSum;
				
				maxSum = 0;
				bBenefit = 0;
				//일꾼 B의 선택
				//일꾼A와 같은 행에 뒷쪽 열에서 선택
				for (int j2 = j+M; j2 <= N-M; j2++) {
					makeMaxSubset(i, j2, 0, 0, 0);
					if(bBenefit<maxSum) bBenefit = maxSum;
				}
				
				// 일꾼A의 다음행부터 선택
				for (int i2 = i+1; i2 < N; i2++) {
					for (int j2 = 0; j2 <= N-M; j2++) {
						makeMaxSubset(i2, j2, 0, 0, 0);
						if(bBenefit < maxSum) bBenefit = maxSum;
					}
				}
				
				if(result<aBenefit + bBenefit) result = aBenefit+bBenefit;
			}
		}
		return result;
	}
	
	private static int maxSum=0;
	private static void makeMaxSubset(int i,int j,int cnt,int sum,int powerSum) {
		
		if(sum>C)return;
		// 마지막 원소까지 다 부분집합에 고려해봤다면
		if(cnt==M) {
			if(maxSum<powerSum) maxSum = powerSum;
			return;
		}
		// 선택
		makeMaxSubset(i,j+1,cnt+1,sum+map[i][j],powerSum+(map[i][j]*map[i][j]));
		// 비 선택
		makeMaxSubset(i,j+1,cnt+1,sum,powerSum);
	}
}



//package com.Expert;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Expert_2115 {
//	static int N,M,C;
//	static int[][] map;
//	static int[][] bottle;
//	static boolean[][] visited;
//	static int aSum,bSum;
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		
//		int testCase = Integer.parseInt(br.readLine());
//		for (int tc = 1; tc <= testCase; tc++) {
//			st = new StringTokenizer(br.readLine());
//			N = Integer.parseInt(st.nextToken());
//			M = Integer.parseInt(st.nextToken());
//			C = Integer.parseInt(st.nextToken());
//			map = new int[N][N];
//			bottle = new int[N][N];
//			
//			for (int i = 0; i < N; i++) {
//				st = new StringTokenizer(br.readLine());
//				for (int j = 0; j < N; j++) {
//					map[i][j] = Integer.parseInt(st.nextToken());
//				}
//			}
//			
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N-M+1; j++) {
//					makeA(i,j);
//				}
//			}
//			
//		}
//	}
//	private static void makeA(int i, int j) {
//		visited=new boolean[N][N];
//		for (int k = 0; k < M; k++) {
//			visited[i][j+k]=true;
//			aSum+=map[i][j+k]*map[i][j+k];
//		}
//		makeB();
//	}
//	private static void makeB() {
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N-M+1; j++) {
//			}
//		}
//	}
//}
