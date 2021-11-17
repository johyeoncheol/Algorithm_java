package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.StringTokenizer;

public class Back_14235 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a==0) {
				if(pq.size()==0) {
					sb.append("-1\n");
				}else {
					sb.append(pq.poll()+"\n");
				}
					
			}else {
				for (int j = 0; j < a; j++) {
					pq.add(Integer.parseInt(st.nextToken()));
				}
			}
		}
		System.out.println(sb);
	}
}
