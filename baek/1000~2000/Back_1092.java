package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Back_1092 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(arr,Collections.reverseOrder());
		
		int M = Integer.parseInt(br.readLine());
		ArrayList<Integer> box = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(box,Collections.reverseOrder());
		
		if(arr.get(0)<box.get(0))System.out.println("-1");
		else {
			int time = 0;
			while(!box.isEmpty()) {
				int idx = 0;
				for (int i = 0; i < arr.size();) {
					if(idx == box.size())break;
					else if(arr.get(i) >= box.get(idx)) {
						box.remove(idx);
						i++;
					}
					else idx++;
				}
				time++;
			}
			System.out.println(time);
		}
		
	}
}
