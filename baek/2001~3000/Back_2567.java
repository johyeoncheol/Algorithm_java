package com.Back;

import java.util.Scanner;

/* https://www.acmicpc.net/problem/2567
 * */
public class Back_2567 {
	static String input = "4\r\n" + 
			"3 7\r\n" + 
			"5 2\r\n" + 
			"15 7\r\n" + 
			"13 14";

	public static void main(String[] args){
		Scanner sc = new Scanner(input);
		int TestCase = sc.nextInt();
		int[][] rect = new int[102][102];
		
		int dx[] = {-1,1,0,0};
		int dy[]= {0,0,-1,1};
		
		int sum = 0;

		for (int tc = 0; tc < TestCase; tc++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for (int i = 1; i <= 10; i++) {
				for (int j = 1; j <= 10; j++) {
					rect[x+i][y+j]=1;
				}
			}
		}
		
		for(int i = 1 ; i < 101;i++) {
			for(int j = 1 ; j < 101;j++) {
				if(rect[i][j]==1) {
					int x =0;
					int y =0;
					for(int k = 0 ; k < 4 ; k++) {
						x = dx[k]+i;
						y = dy[k]+j;
						if(rect[x][y]==0) {
							sum++;
						}
					}
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
///* https://www.acmicpc.net/problem/2567
// * */
//public class Back2567 {
//	static String input = "4\r\n" + 
//			"3 7\r\n" + 
//			"5 2\r\n" + 
//			"15 7\r\n" + 
//			"13 14";
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(input);
//		int TestCase = sc.nextInt();
//		int[][] rect = new int[100][100];
//		int CornerX[] = new int[TestCase*2];
//		int CornerY[] = new int[TestCase*2];
//		
//		int sum = 0;
//
//		for (int tc = 0; tc < TestCase; tc++) {
//			int x = sc.nextInt();
//			int y = sc.nextInt();
//			CornerX[tc*2]=x;
//			CornerX[tc*2+1]=x+10;
//			CornerY[tc*2]=y;
//			CornerY[tc*2+1]=y+10;
//			
//			for (int i = x; i < x + 10; ++i) {
//				for (int j = y; j < y + 10; ++j) {
//					rect[j][i]++;
//				}
//			}
//		}
//		
//		for(int tc = 0 ; tc< TestCase ;++tc){
//			for(int i = 0 ; i < 10 ; ++i) {
//				if(rect[CornerX[tc*2]+i][CornerY[tc*2+1]]==1) {
//					sum++;
//				}
//				if(rect[CornerX[tc*2]+i][CornerY[tc*2]]==1) {
//					sum++;
//				}
//				if(rect[CornerX[tc*2]][CornerY[tc*2]+i]==1) {
//					sum++;
//				}
//				if(rect[CornerX[tc*2+1]][CornerY[tc*2]+i]==1) {
//					sum++;
//				}
//			}
//		}
//		System.out.println(sum);
//	}
//
//}
//
