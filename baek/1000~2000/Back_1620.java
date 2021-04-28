package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Back_1620 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<Integer, String> po1 = new HashMap<Integer, String>(N);
		HashMap<String, Integer> po2 = new HashMap<String, Integer>(N);
		for (int i = 1; i <= N; i++) {
			String temp = br.readLine();
			po1.put(i, temp);
			po2.put(temp, i);
		}
		
		for (int i = 0; i < M; i++) {
			String temp = br.readLine();
			if(temp.charAt(0)<='Z' && temp.charAt(0)>='A') {
				sb.append(po2.get(temp)+"\n");
			}else {
				sb.append(po1.get(Integer.parseInt(temp))+"\n");
			}
		}
		
		System.out.println(sb);
	}
}
