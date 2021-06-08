package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//구구단
public class jungol_1291 {

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
			for (int i = 1; i <= 9; i++) {
				for (int j = input1; j >= input2; j--) {
					if(i*j<10) {
						sb.append(j+" * "+i+" =  "+i*j+"   ");
					}else {
						sb.append(j+" * "+i+" = "+i*j+"   ");
					}
				}
				sb.append("\n");
			}
		}else {
			for (int i = 1; i <= 9; i++) {
				for (int j = input1; j <= input2; j++) {
					if(i*j<10) {
						sb.append(j+" * "+i+" =  "+i*j+"   ");
					}else {
						sb.append(j+" * "+i+" = "+i*j+"   ");
					}
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
