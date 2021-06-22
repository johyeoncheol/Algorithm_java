package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

public class jungol_1219 {

	static int R, C, Paper, N,maxHeight;
	static ArrayList<point> arr = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Paper = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		if (N == 0) {
			System.out.println(0);
			System.exit(1);
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			maxHeight = Math.max(x, maxHeight);
			arr.add(new point(y));
		}
		Collections.sort(arr);
		int right = 1000000;
		int left = maxHeight;
		while(left<right) {
			int middle = (left+right)/2;
			if(avail(middle)<=Paper) {
				right=middle;
			}else {
				left = middle+1;
			}
		}
		System.out.println(left);
	}

	private static int avail(int width) {
		int prev = -1;
		int ret = 0;
		for (int i = 0; i < arr.size(); i++) {
			if(prev==-1) {
				prev = arr.get(i).y;
				ret++;
			}else if(prev+width<=arr.get(i).y) {
				prev = arr.get(i).y;
				ret++;
			}
		}
		return ret;
	}

	static class point implements Comparable<point> {
		int y;

		public point(int y) {
			super();
			this.y = y;
		}

		@Override
		public int compareTo(point o) {

			return this.y - o.y;

		}
	}
}
