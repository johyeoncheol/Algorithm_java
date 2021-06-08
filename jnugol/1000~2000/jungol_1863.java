package com.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol_1863 {
	
	static int[] parents;
	static int[] cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		
		parents = new int[N+1];
		cnt = new int[N+1];
		
		for (int i = 0; i < N; i++) {
			parents[i]=i;
		}
		
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			union(a,b);
		}
		
		int ans=0;
		for (int i = 1; i <=N ; i++) {
			if(parents[i]==i) {
				ans++;
			}
		}
		System.out.println(ans);
	}
	
	static int find(int a) {
		if(parents[a] == a) {
			return a;
		}
		//return findSet(parents[a]); // path compression 전
		return parents[a] = find(parents[a]); // path compression 후
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(cnt[aRoot]<cnt[bRoot]) {
			parents[aRoot] = bRoot;
		}
		else {
			parents[bRoot] = aRoot;
			if(cnt[aRoot]==cnt[bRoot]) {
				cnt[aRoot]++;
			}
		}
	}
}
