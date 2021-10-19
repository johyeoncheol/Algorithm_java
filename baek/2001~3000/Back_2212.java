package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Back_2212 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int[] dif = new int[N-1];
		int ans=0;
		
		if(K>=N) {
			System.out.println(0);
			return;
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i <N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(arr);
		
		for(int i = 0 ; i < N-1;i++) {
			dif[i] = arr.get(i+1)-arr.get(i);
		}
		Arrays.sort(dif);
		for(int i = 0 ; i < N-K;i++) {
			ans+=dif[i];
		}
		System.out.println(ans);
		
	}
}
