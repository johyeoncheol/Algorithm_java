package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class jungol_1370 {
	static ArrayList<meet> meeting = new ArrayList<jungol_1370.meet>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			meeting.add(new meet(num, start, end));
		}
		Collections.sort(meeting);
		ArrayList<meet> avail = new ArrayList<meet>();
		avail.add(meeting.get(0));
		for (int i = 1; i < N; i++) {
			if(meeting.get(i).start>=avail.get(avail.size()-1).end) {
				avail.add(meeting.get(i));
			}
		}
		System.out.println(avail.size());
		for (int i = 0; i < avail.size(); i++) {
			System.out.print(avail.get(i).num+" ");
		}
	}
	
	static class meet implements Comparable<meet>{
		int num;
		int start;
		int end;
		public meet(int num, int start, int end) {
			super();
			this.num = num;
			this.start = start;
			this.end = end;
		}
		@Override
		public int compareTo(meet o) {
			// TODO Auto-generated method stub
			return this.end - o.end;
		}
		
	}
}
