package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Back_1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Set<String> set = new HashSet<String>();
		ArrayList<String> arr = new ArrayList<String>();
		
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		Collections.sort(arr);
		
		for (int i = 0; i < M; i++) {
			String tmp = br.readLine();
			if(set.contains(tmp)) {
				arr.add(tmp);
			}
		}
		Collections.sort(arr);
		System.out.println(arr.size());
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}
}
