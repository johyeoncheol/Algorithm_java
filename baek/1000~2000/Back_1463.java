package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//DP를 이용한 풀이
public class Back_1463 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		int [] D = new int[num+1];
		
		D[0] = 0;
		D[1] = 0;
		
		for(int i = 2; i <= num;i++) {
			D[i] = D[i-1]+1;
			if(i%2 == 0 && D[i] > D[i / 2] + 1) {
				D[i] = D[i/2]+1;
			}
			if(i%3 == 0 && D[i] > D[i / 3] + 1) {
				D[i] = D[i/3]+1;
			}
		}
		
		System.out.println(D[num]);
	}
}