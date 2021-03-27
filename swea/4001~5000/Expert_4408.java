package com.Expert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Expert_4408 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= testCase; tc++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[]arr = new int[201];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int temp1 = Integer.parseInt(st.nextToken());
				int temp2 = Integer.parseInt(st.nextToken());
				int x = Math.min(temp1, temp2);
				int y = Math.max(temp1, temp2);
				if(x%2==1) {
					x=x+1;
				}
				if(y%2==1) {
					y=y+1;
				}
				for (int j = x/2; j <= y/2; j++) {
					arr[j]++;
				}
			}
			Arrays.sort(arr);
			sb.append("#"+tc+" "+arr[200]+"\n");
		}
		System.out.println(sb);
	}
}
