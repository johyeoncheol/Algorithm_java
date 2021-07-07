package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Back_1302 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String,Integer> hm = new HashMap<String, Integer>();
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			if(hm.containsKey(tmp)) {
				hm.replace(tmp, hm.get(tmp)+1);
			}else {
				hm.put(tmp, 1);
			}
		}
		
		for(String tmp : hm.keySet()) {
			max = Math.max(max, hm.get(tmp));
		}
		
		ArrayList<String> arr = new ArrayList<String>(hm.keySet());
		Collections.sort(arr);
		for(String tmp : arr) {
			if(hm.get(tmp) == max) {
				System.out.println(tmp);
				break;
			}
		}
	}
}
