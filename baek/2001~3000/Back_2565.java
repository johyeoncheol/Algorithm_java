package com.Back;

import java.util.Arrays;
import java.util.Scanner;

public class Back_2565 {	
	
	static String src = "8\r\n" + 
			"1 8\r\n" + 
			"3 9\r\n" + 
			"2 2\r\n" + 
			"4 1\r\n" + 
			"6 4\r\n" + 
			"10 10\r\n" + 
			"9 7\r\n" + 
			"7 6";
	
	static class Point implements Comparable<Point>{
		int no, val;

		public Point(int idx, int val) {		
			this.no = idx;
			this.val = val;
		}

		@Override
		public int compareTo(Point o) {
			return this.no - o.no;
		}		
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
	//	s = new Scanner(src);
		int N = s.nextInt();
		
		Point[] arr = new Point[N];//data
		int[] LIS = new int[N]; //n번째 값까지 고려했을 때의 최장길이		
		
		for (int i = 0; i < N; i++) {
			arr[i] = new Point(s.nextInt(), s.nextInt());			
		}
		
		Arrays.sort(arr);		
		
		Arrays.fill(LIS, 1);		
		for (int i = 0; i < N; i++) {			
			for (int j = 0; j < i; j++) {				
				if(arr[j].val < arr[i].val) {
					LIS[i] = Math.max(LIS[i], LIS[j] + 1);
				}
			}			
		}	
		Arrays.sort(LIS);		
		System.out.println(N - LIS[N-1]);
	}
}