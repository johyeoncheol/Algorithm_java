package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Back_2304 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<top> arr = new ArrayList<>();
		int ans=0;

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr.add(new top(x, y));
		}
		Collections.sort(arr);
		
		int maxX=0;

		//오른쪽에서 왼쪽으로
		top currenttop=arr.get(0);
		for (int i = 1; i < N; i++) {
			if(currenttop.y <= arr.get(i).y) {
				ans += (arr.get(i).x - currenttop.x) * currenttop.y;
				currenttop = arr.get(i);
				maxX = i;
			}
		}
		
		//왼쪽에서 오른쪽으로
		currenttop = arr.get(N-1);
		for (int i = 0; i < N-maxX; i++) {
			if(currenttop.y <= arr.get(N-i-1).y) {
				ans += (currenttop.x - arr.get(N-i-1).x ) * currenttop.y;
				currenttop = arr.get(N-i-1);
			}
		}
		ans += currenttop.y;
		System.out.println(ans);
	}
	
	static class top implements Comparable<top> {
		int x;
		int y;

		public top(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(top o) {
			// TODO Auto-generated method stub
			return this.x - o.x;
		}

	}
}
