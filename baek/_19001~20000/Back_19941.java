package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back_19941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[N];
		ArrayList<Integer> ham = new ArrayList<Integer>();
		int ans=0;
		
		String temp = br.readLine();
		for (int i = 0; i < N; i++) {
			if(temp.charAt(i)=='H') {
				ham.add(i);
				visited[i]=true;
			}
		}
		
		for (int i = 0; i < ham.size(); i++) {
			for (int j = ham.get(i)-K; j <= ham.get(i)+K; j++) {
				if(j<0 || j>=N)continue;
				if(visited[j]==false) {
					visited[j]=true;
					ans++;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
