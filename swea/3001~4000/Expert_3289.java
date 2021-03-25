package com.Expert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Expert_3289 {
	static int N,M;
	static int [] parents; //대표자 배열
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCaset = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <=testCaset ; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parents = new int[N+1];
			
			int command,a,b;
			//각 원소별 대표자 값 지정
			Arrays.fill(parents, -1); // make-set
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				command = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				switch(command) {
				case 0:
					union(a,b);
					break;
				case 1:
					sb.append(find(a) == find(b) ? "1" : "0");
					break;
				}
			}
		}
	}
	private static int find(int a) {
		if(parents[a] == -1) return a;
		return parents[a]= find(parents[a]);
	}
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}
}
