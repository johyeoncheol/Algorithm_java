package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Back_2566 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		ArrayList<link> al = new ArrayList<link>();
		int ans1=0;
		int ans2=0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			al.add(new link(A, B));
		}
		for (int i = 0; i < N; i++) {

		}
	}

	static class link{
		int A;
		int B;
		public link(int A, int B) {
			super();
			this.A = A;
			this.B = B;
		}
		
	}
}
