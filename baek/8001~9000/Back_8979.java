package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Back_8979 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<nation> arr = new ArrayList<>();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr.add(new nation(n, g, s, b));
		}
		arr.add(new nation(0, -1, -1, -1));
		Collections.sort(arr);
		int ans =1;
		
		if(arr.get(0).n==K) {
			System.out.println(ans);
			System.exit(0);
		}
		for (int i = 1; i < N; i++) {
			if(arr.get(i).g==arr.get(i-1).g&&
					arr.get(i).s==arr.get(i-1).s&&
					arr.get(i).b==arr.get(i-1).b) {
			}else {
				ans=i+1;
			}
			
			if(arr.get(i).n==K) {
				break;
			}		
			
		}
		System.out.println(ans);
	}
	
	static class nation implements Comparable<nation>{
		int n;
		int g;
		int s;
		int b;
		public nation(int n, int g, int s, int b) {
			super();
			this.n = n;
			this.g = g;
			this.s = s;
			this.b = b;
		}
		@Override
		public int compareTo(nation o) {
			if(this.g==o.g) {
				if(this.s==o.s) {
					return o.b-this.b;
				}
				return o.s-this.s;
			}
			return o.g-this.g;
		}
		
	}
}
