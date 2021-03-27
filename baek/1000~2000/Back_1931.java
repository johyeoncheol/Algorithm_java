package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_1931 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		time[] t = new time[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			t[i] = new time(start, end);
		}
		Arrays.sort(t);
		
		int cnt = 0;
		int end = 0;
		
		for (int i = 0; i < N; i++) {
			if(t[i].start>=end) {
				end = t[i].end;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	static class time implements Comparable<time>{
		int start;
		int end;

		public time(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(time o) {
			if(this.end==o.end) {
				return this.start - o.start;
			}else {				
				return this.end - o.end;		
			}
		}
	}
}
