package com.Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert_8382 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			int ans =0;
			
			int difX = Math.abs(startX-endX);
			int difY = Math.abs(startY-endY);			
			
			if(difX<difY) {
				int temp = difX;
				difX = difY;
				difY = temp;
			}
			
			ans+=difY*2;
			if(difX==difY) {
				sb.append("#"+tc+" "+ans+"\n");
				continue;
			}
			
			if((difX-difY)%2==0) {
				ans+=2*(difX-difY);
			}else {
				ans+=2*(difX-difY)-1;
			}
			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}

}
