package com.Expert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert_4014 {
	static int N,X;
	static int map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < testCase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j]= Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#"+tc+" "+process());
		}
			
	}
	private static int process() {
		int count=0;
		for (int i = 0; i < N; i++) {
			if(makeRoadByRow(i)) ++count;
			if(makeRoadByCol(i)) ++count;
		}
		return count;
	}
	private static boolean makeRoadByRow(int i) {
		int beforeHeight = map[i][0];
		int size = 0;
		int j =0; // 탐색열 위치
		while(j<N) {
			if(beforeHeight == map[i][j]) {
				++size;
				++j;
			}else if(beforeHeight+1 == map[i][j]) { // 오르막 경사로 설치 가능한지 판단
				if(size<X) return false; // 경사로 설치 불가
				beforeHeight++;
				size=1;
				++j;
			}else if(beforeHeight-1 == map[i][j]) { // 내리막 경사로 설치 가능한지 판단
				int count=0;
				for (int k = j; k < N; k++) {
					if(map[i][k] !=beforeHeight-1) break;
					if(++count==X)break;
				}
				if(count<X) return false; // 경사로 설치 불가
				beforeHeight--;
				size = 0;
				j+=X;
			}else {
				return false;
			}
		}
		return true;
	}
	private static boolean makeRoadByCol(int i) {
		int beforeHeight = map[0][i];
		int size = 0;
		int j =0; // 탐색행 위치
		while(j<N) {
			if(beforeHeight == map[j][i]) {
				++size;
				++j;
			}else if(beforeHeight+1 == map[j][i]) { // 오르막 경사로 설치 가능한지 판단
				if(size<X) return false; // 경사로 설치 불가
				beforeHeight++;
				size=1;
				++j;
			}else if(beforeHeight-1 == map[j][i]) { // 내리막 경사로 설치 가능한지 판단
				int count=0;
				for (int k = j; k < N; k++) {
					if(map[k][i] !=beforeHeight-1) break;
					if(++count==X)break;
				}
				if(count<X) return false; // 경사로 설치 불가
				beforeHeight--;
				size = 0;
				j+=X;
			}else {
				return false;
			}
		}
		return true;
	}
}

//package com.Expert;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Expert_4014 {
//	static int N,X,ans;
//	static int [][]map;
//	static boolean[][] rVisited;
//	static boolean[][] cVisited;
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int testCase = Integer.parseInt(br.readLine());
//		
//		for (int tc = 1; tc <= testCase; tc++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			N = Integer.parseInt(st.nextToken());
//			X = Integer.parseInt(st.nextToken());
//			map = new int[N][N];
//			
//			for (int i = 0; i < N; i++) {
//				st = new StringTokenizer(br.readLine());
//				for (int j = 0; j < N; j++) {
//					map[i][j] = Integer.parseInt(st.nextToken());
//				}
//			}
//			
//			
//		}
//	}
//}
