package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back_11725 {
	static int num;
	static ArrayList<Integer>[] tree; 
	static boolean [] isSelected;
	static int parent[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		num = Integer.parseInt(br.readLine());
		
		//연결
		tree = new ArrayList[num+1];
		isSelected = new boolean[num+1];
		parent = new int[num+1];
		
		for(int i=1;i<=num;i++) {
			tree[i] = new ArrayList<>();
		}
		for(int i = 1 ; i <num;i++) {
			st = new StringTokenizer(br.readLine());
			
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			tree[node1].add(node2);
			tree[node2].add(node1);
		}
		dfs(1);
		for(int i = 2; i <= num ; i++) {
			System.out.println(parent[i]);
		}
	}


	private static void dfs(int cnt) {
		isSelected[cnt] =true;
		for(int n: tree[cnt]) {
			if(!isSelected[n]) {
				parent[n] = cnt;
				dfs(n);
			}
		}
	}
}
