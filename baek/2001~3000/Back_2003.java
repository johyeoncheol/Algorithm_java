package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2003 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine().trim());

		int N = Integer.parseInt(st.nextToken());// 수열의 길이. N개의 수로 된 수열
		int M = Integer.parseInt(st.nextToken());// 만들어야 되는 합

		st = new StringTokenizer(br.readLine().trim());
		int[] numbers = new int[N];
		
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		//
		int start = 0;
		int end =0;
		int sum =0;
		int count=0;
		
		while(true) {
			if(sum<M) { // 5미만인 경우
				if(end>=N)break;
				sum += numbers[end++];
			}else { // 
				sum-=numbers[start++];
			}
			
			if(sum==M) {
				count++;
			}
		}
		System.out.println(count);
	}
}
