package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol_1341 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int input1=Integer.parseInt(st.nextToken());
		int input2=Integer.parseInt(st.nextToken());
		
		while(input1<2 || input1 >9 || input2 <2 || input2>9) {
			System.out.println("INPUT ERROR!");
			st = new StringTokenizer(br.readLine());
			input1=Integer.parseInt(st.nextToken());
			input2=Integer.parseInt(st.nextToken());
		}
		
		//앞의 숫자가 더 큰 경우
		if(input1>input2) {
			for (int j = input1; j >= input2; j--) {
				for (int i = 1; i <= 9; i++) {
					if(i*j<10) {
						sb.append(j+" * "+i+" =  "+i*j+"   ");
					}else {
						sb.append(j+" * "+i+" = "+i*j+"   ");
					}
					if(i%3==0) {
						sb.append("\n");
					}
				}
				sb.append("\n");
			}
		}else {
			for (int j = input1; j <= input2; j++) {
				for (int i = 1; i <= 9; i++) {
					if(i*j<10) {
						sb.append(j+" * "+i+" =  "+i*j+"   ");
					}else {
						sb.append(j+" * "+i+" = "+i*j+"   ");
					}
					if(i%3==0) {
						sb.append("\n");
					}
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
