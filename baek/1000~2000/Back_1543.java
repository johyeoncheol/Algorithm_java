package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back_1543 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();
		String search = br.readLine();
		int ans=0;
		
		for (int i = 0; i < temp.length()-search.length()+1; i++) {
			if(temp.substring(i, i+search.length()).equals(search)) {
				ans++;
				i+=search.length()-1;
			}
		}
		System.out.println(ans);
	}
}
