package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_18429 {
	static int N,K,ans;
	static int weight[];
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		weight = new int[N];
		visited= new boolean[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			weight[i]=Integer.parseInt(st.nextToken());
		}
		perm(0,0);
		System.out.println(ans);
	}

	private static void perm(int cnt,int totalweight) {
		if(totalweight<0)return;
		if(cnt==N) {
			ans++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if(visited[i])continue;
			visited[i]=true;
			perm(cnt+1, totalweight+weight[i]-K);
			visited[i]=false;
		}
	}
}
