package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back_2839 {
	static int num;
	static int sum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		num = Integer.parseInt(br.readLine());
		sum = -1;
		
		// 5로 나눈 몫보다 작은 값이 가질수 있는 5를 가질수 있는 범위이다.
		for (int i = num/5; i >= 0; i--) {
			//나누어 떨어지는 경우
			if((num-i*5)%3==0) {
				sum=i+(num-i*5)/3;
				break;
			}
		}
		System.out.println(sum);
	}
}
