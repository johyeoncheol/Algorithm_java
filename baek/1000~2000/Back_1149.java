package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_1149 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int [][] costs = new int[num][3];
		int ans= Integer.MAX_VALUE;
		
		for (int i = 0; i < num; i++) {
			st= new StringTokenizer(br.readLine());
			int R = Integer.parseInt(st.nextToken());
			int G = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			costs[i][0] = R;
			costs[i][1] = G;
			costs[i][2] = B;
		}
		
		
		for (int i = 1; i < num; i++) {
			//첫번째를 빨간색을 선택한 경우
			costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
			costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
			costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);				
		}
		
		if(ans>costs[num-1][0]) {
			ans=costs[num-1][0];
		}
		if(ans>costs[num-1][1]) {
			ans=costs[num-1][1];
		}
		if(ans>costs[num-1][2]) {
			ans=costs[num-1][2];
		}
		System.out.println(ans);
	}
}
