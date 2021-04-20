package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Back_3231 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		ArrayList<Integer> a = new ArrayList<Integer>();
		int ans=0;
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		a.add(arr[0]);
		for (int i = 1; i < N; i++) {
			if(a.contains(arr[i]-1)) {
				a.add(arr[i]);
			}else {
				ans++;
				a.add(arr[i]);
			}
		}
		System.out.println(ans);
	}
}


//시간초과 LIS로 풀어야 할거 같다는 판단은 했지만 빠르게 재귀로 풀어봄
//package com.Back;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Back_3231 {
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		int[] arr = new int[N];
//		int ans=0;
//		int num = 1;
//		for (int i = 0; i < N; i++) {
//			arr[i]=Integer.parseInt(br.readLine());
//		}
//		
//		while(true) {
//			if(num==N+1) break;
//			for (int i = 0; i < N; i++) {
//				if(arr[i]==num) num++;
//			}
//			ans++;
//		}
//		System.out.println(ans-1);
//	}
//}
