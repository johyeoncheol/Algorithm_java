package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_13300 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [][] person = new int [2][7];
		int ans =0;
		int num = Integer.parseInt(st.nextToken());
		int maxPer = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			person[gender][grade]++;
		}
		
		for (int i = 0; i < 2; i++) {
			for (int j = 1; j <= 6; j++) {
				if(person[i][j]>0 && person[i][j]%maxPer==0) {
					ans += person[i][j]/maxPer;
				}else if(person[i][j]>0){
					ans += person[i][j]/maxPer+1;
				}
				
			}
		}
		System.out.println(ans);
	}
}
