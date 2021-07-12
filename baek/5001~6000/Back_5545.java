package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Back_5545 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int dP = Integer.parseInt(st.nextToken());
		int tP = Integer.parseInt(st.nextToken());
		int sum = Integer.parseInt(br.readLine());
		int ans = sum/dP;
		ArrayList<Integer> t  = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			t.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(t,Comparator.reverseOrder());
		
		for (int i = 0; i < t.size(); i++) {
			sum+=t.get(i);
			int temp =sum/((i+1)*tP + dP ); 
			if(temp<ans)break;
			ans = temp;
		}
		System.out.println(ans);
	}
}
