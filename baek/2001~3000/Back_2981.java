package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back_2981 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int tempGcd = arr[1] - arr[0];
		
		for (int i = 2; i < N; i++) {
			tempGcd = gcd(tempGcd,arr[i]-arr[i-1]);
		}
		
		for (int i = 2; i <=tempGcd ; i++) {
			if(tempGcd % i ==0) {
				sb.append(i+" ");
			}
		}
		System.out.println(sb);
	}

	private static int gcd(int a, int b) {
		while(b>0) {
			int tmp = a % b;
			a = b;
			b = tmp;
		}
		return a;
	}
}

//package com.Back;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Back_2981 {
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int N = Integer.parseInt(br.readLine());
//		int[] arr = new int[N];
//		int max=0;
//		for (int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//			if(max<arr[i])max=arr[i];
//		}
//		
//		for (int M = 2; M < max; M++) {
//			int temp = arr[0]%M;
//			boolean flag = false;
//			for (int i = 1; i < N; i++) {
//				if(temp!=(arr[i]%M)) {
//					flag = true;
//					break;
//				}
//			}
//			if(flag==false) {				
//				sb.append(M+" ");
//			}
//		}
//		System.out.println(sb);
//	}
//
//}
