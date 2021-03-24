package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back_3040 {
	public static int arr[] = new int[9];
	public static int nums[] = new int[7];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dfs(0, 0);
	}

	public static void dfs(int cnt, int start) {
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += nums[i];
			}
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(nums[i]);

				}
				return;
			}
			return;
		}

		for (int i = start; i < 9; i++) {
			nums[cnt] = arr[i];
			dfs(cnt + 1, i + 1);

		}

	}
}



//package com.Back;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
////ÀÏ°ö ³­ÀïÀÌ
//public class Back_3040 {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int [] Person = new int[9];
//		int fake1=0,fake2=0;
//		int sum = 0;
//		for(int i = 0 ; i < Person.length; i++) {
//			Person[i]=sc.nextInt();
//			sum += Person[i];
//		}
//		Arrays.sort(Person);
//		for(int i = 0 ; i<Person.length;i++) {
//			for(int j = 1 ; j < 9;j++) {
//				if(Person[i]+Person[j]==sum-100) {
//					fake1=i;
//					fake2=j;
//					break;
//				}
//			}
//		}
//		for(int i = 0 ; i < Person.length;i++) {
//			if(i==fake1||i==fake2) {
//				continue;
//			}
//			System.out.println(Person[i]);
//		}
//		
//	}
//
//}
