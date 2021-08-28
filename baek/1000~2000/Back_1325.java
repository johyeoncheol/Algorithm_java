package com.back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back_1325 {

	static int N,M;
	static ArrayList<Integer>[] list;
	static int[] arr;
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		arr = new int[N+1];
		
		for (int i = 0; i <= N; i++) {
			list[i]= new ArrayList<Integer>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
		}
		
		for (int i = 1; i <= N; i++) {
			visited=new boolean[N+1];
			dfs(i);
		}
		
		int max =0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, arr[i]);
		}
		for (int i = 1; i <= N; i++) {
			if(arr[i]==max) {
				sb.append(i+" ");
			}
		}
		System.out.println(sb);
	}
	private static void dfs(int i) {
		visited[i]=true;
		
		for (int tmp : list[i] ) {
			if(!visited[tmp]) {
				arr[tmp]++;
				dfs(tmp);
			}
		}
	}
}
