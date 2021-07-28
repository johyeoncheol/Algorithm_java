package com.back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Back_5052 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < testCase; tc++) {
			int N = Integer.parseInt(br.readLine());
			boolean ans=false;
			ArrayList<num> arr = new ArrayList<num>();
			for (int i = 0; i < N; i++) {
				String tmp = br.readLine();
				arr.add(new num(tmp));
			}
			Collections.sort(arr);
			
			for (int i = 1; i < N; i++) {
				if(arr.get(i).num.startsWith(arr.get(i-1).num)) {
					ans =true;
					break;
				}
			}
			if(ans==true) {
				sb.append("NO\n");
			}else {				
				sb.append("YES\n");
			}
		}
		System.out.println(sb);
	}
	
	static class num implements Comparable<num> {
		String num;
		public num(String num) {
			super();
			this.num = num;
		}
		@Override
		public int compareTo(num o) {
			return this.num.compareTo(o.num);
		}

	}
}
