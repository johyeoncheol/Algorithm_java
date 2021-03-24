package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_10163 {
	static int [][] map = new int[101][101];
	static int num;
	static int result[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		result = new int[num];
		
		for (int t = 1; t <= num; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int width=Integer.parseInt(st.nextToken());
			int height=Integer.parseInt(st.nextToken());
			
			for (int i = y; i < height+y; i++) {
				for (int j = x; j < width+x; j++) {
					map[i][j]=t;
				}
			}
		}
		
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(map[i][j]!=0) {
					result[map[i][j]-1]++;
				}
			}
		}
		for(int ans : result) {
			System.out.println(ans);
		}
		
	}

}


//package com.Back;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Back_10163 {
//	static int [][] map = new int[101][101];
//	static int num;
//	
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		num = Integer.parseInt(br.readLine());
//		
//		for (int t = 1; t <= num; t++) {
//			StringTokenizer st = new StringTokenizer(br.readLine());
//			int x = Integer.parseInt(st.nextToken());
//			int y = Integer.parseInt(st.nextToken());
//			int width=Integer.parseInt(st.nextToken());
//			int height=Integer.parseInt(st.nextToken());
//			
//			for (int i = y; i < height+y; i++) {
//				for (int j = x; j < width+x; j++) {
//					map[i][j]=t;
//				}
//			}
//		}
//		
//		for (int t = 1; t <= num; t++) {
//			int count=0;
//			for (int i = 0; i < 101; i++) {
//				for (int j = 0; j < 101; j++) {
//					if(map[i][j]==t) {
//						count++;
//					}
//				}
//			}
//			System.out.println(count);
//		}
//		
//		
//	}
//
//}
