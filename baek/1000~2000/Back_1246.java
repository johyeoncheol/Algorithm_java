package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Back_1246 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M =Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		for (int i = 0; i < M; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(arr);
		
		int ans = 0;
		int max = 0;
		
		for (int i = 0; i < M; i++) {
			int tmp = arr.get(i);
			int tmpsum = 0;
			
			if(M-i<N) {
				tmpsum = tmp * (M-i);
			}else {
				tmpsum = tmp * N;
			}
			
			if(tmpsum>max) {
				max = tmpsum;
				ans = tmp;
			}
		}
		System.out.println(ans + " "+ max);
	}
}
