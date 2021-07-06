package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Back_10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> arr = new Stack<Integer>();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			
			if(tmp==0) {
				arr.pop();
				continue;
			}
			
			arr.add(tmp);
		}
		
		int sum=0;
		for(int tmp:arr) {
			sum+=tmp;
		}
		System.out.println(sum);
	}
}
