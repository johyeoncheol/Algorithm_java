package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol_2811 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb= new StringBuilder();
		
		for (int i = 0; i < 5; i++) {
			int temp=Integer.parseInt(st.nextToken());
			if(temp==1) {
				sb.append("number one"+"\n");
				continue;
			}
			int sq = (int)Math.sqrt(temp);
			if(temp<2) {
				sb.append("prime number"+"\n");
				continue;
			}
			boolean flag=false;
			for (int j = 2; j <= sq; j++) {
				if(temp%j==0) {
					sb.append("composite number"+"\n");
					flag=true;
					break;
				}
			}
			if(flag==false) {
				sb.append("prime number"+"\n");
				continue;
			}
		}
		System.out.println(sb);
	}
}
 