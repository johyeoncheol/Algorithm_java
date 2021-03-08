package com.Expert;

import java.util.Arrays;
import java.util.Scanner;

public class Expert_1954 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // testcase 갯수

		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();// 배열의 크기
			int[][] map = new int[n][n];

			int cnt = 1; // 배열 각 칸에 넣을 숫자
			int dir = 1; // 진행방향값 1 or -1
			int x = 0, y = -1; // 시작점

			while (true) {
				// 우 -> 하 -> 좌 -> 상
		
				// 우
				for (int i = 0; i < n; i++) {
					y = y + dir;
					map[x][y] = cnt++;
				}
				n--; // 우 -> 하 , 좌 -> 상
				if (n == 0) break;
				// 하
				for (int i = 0; i < n; i++) {
					x = x + dir;
					map[x][y] = cnt++;
				}

				dir = dir * -1;
			}
			System.out.println("#"+tc);
			for(int i = 0 ; i < map.length;i++) {
				for(int j = 0 ; j < map.length;j++) {
					System.out.print(map[i][j]+" ");
				}
				System.out.println();
			}
		}

	}
}


//package com.Expert;
//
//import java.util.Scanner;
//
//public class Expert_1954 {
//
//	static String input="10\r\n" + 
//			"1\r\n" + 
//			"2\r\n" + 
//			"3\r\n" + 
//			"4\r\n" + 
//			"5\r\n" + 
//			"6\r\n" + 
//			"7\r\n" + 
//			"8\r\n" + 
//			"9\r\n" + 
//			"10";
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(input);
//		int TestCase = sc.nextInt();
//		
//		for(int tc = 1 ; tc <= TestCase;tc++) {
//			int Size = sc.nextInt();
//			int [][] Arr = new int[Size][Size];
//			int count =1;
//			int printSize=Size;
//
//			int COL =0;
//			int ROW =-1;
//			
//			int Corner=1;
//			
//			for(int i=0 ; i<Size;i++) {
//				for(int j = 0; j < printSize;j++) {
//					ROW += Corner;
//					Arr[COL][ROW]=count;
//					count++;
//				}
//				printSize--;
//				for(int j = 0 ; j <printSize;j++) {
//					COL += Corner;
//					Arr[COL][ROW]=count;
//					count++;
//				}
//				Corner *=-1; 
//			}
//			System.out.println("#"+tc);
//			for(int i = 0 ; i < Size;i++) {
//				for(int j = 0 ; j < Size;j++) {
//					System.out.print(Arr[i][j]+" ");
//				}
//				System.out.println();
//			}
//		}
//	}
//
//}
