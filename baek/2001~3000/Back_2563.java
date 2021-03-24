package com.Back;

import java.util.Scanner;

public class Back_2563 {
	static String input = "3\r\n" + "3 7\r\n" + "15 7\r\n" + "5 2";

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		int TestCase = sc.nextInt();
		int[][] rect = new int[100][100];
		int minX = 100;
		int minY = 100;
		int maxX = 0;
		int maxY = 0;
		int sum = 0;

		for (int tc = 0; tc < TestCase; tc++) {
			int x = sc.nextInt();
			int y = sc.nextInt();

			if (minX > x) {
				minX = x;
			}
			if (minY > y) {
				minY = y;
			}
			if (maxX < x+10) {
				maxX = x+10;
			}
			if (maxY < y+10) {
				maxY = y+10;
			}

			for (int i = x; i < x + 10; ++i) {
				for (int j = y; j < y + 10; ++j) {
					rect[i][j]++;
				}
			}
		}
		for (int i = minX; i < maxX; i++) {
			for(int j = minY;j<maxY;j++) {
				if(rect[i][j]!=0) {
					sum++;
				}
			}
		}
		System.out.println(sum);
	}

}

//package com.Back;
//
//import java.util.Scanner;
//
//public class Back2563 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int TestCase = sc.nextInt();
//		int[][] rect = new int[100][100];
//		int sum = 0;
//
//		for (int tc = 0; tc < TestCase; tc++) {
//			int x = sc.nextInt();
//			int y = sc.nextInt();
//			for (int i = x; i < x + 10; ++i) {
//				for (int j = y; j < y + 10; ++j) {
//					rect[i][j]++;
//				}
//			}
//		}
//		for (int i = 0; i < 100; i++) {
//			for(int j = 0;j <100;j++) {
//				if(rect[i][j]!=0) {
//					sum++;
//				}
//			}
//		}
//		System.out.println(sum);
//	}
//
//}

