package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Back_11723 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
		for(int i= 1 ; i <=20; i++) {
			hm.put(i, false);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			String st = br.readLine();
			String tmp = st.split(" ")[0];
			if (tmp.equals("all")) {
				for(int j= 1 ; j <=20; j++) {
					hm.put(j, true);
				}
				continue;
			} else if (tmp.equals("empty")) {
				for(int j= 1 ; j <=20; j++) {
					hm.put(j, false);
				}
				continue;
			}
			int val=0;
			if(!st.split(" ")[1].equals("")) {				
				val = Integer.parseInt(st.split(" ")[1]);
			}
			if (tmp.equals("add")) {
				hm.put(val, true);
			} else if (tmp.equals("remove")) {
				hm.put(val,false);
			} else if (tmp.equals("check")) {
				if(hm.get(val)==true) {
					sb.append("1\n");
				}else {
					sb.append("0\n");					
				}
			} else if (tmp.equals("toggle")) {
				if(hm.get(val)==true) {
					hm.put(val,false);
				}else {
					hm.put(val, true);					
				}
			}
		}
		System.out.println(sb);
	}
}
