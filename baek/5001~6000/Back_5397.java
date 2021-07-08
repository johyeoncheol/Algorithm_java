package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Back_5397 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		char[] str;
		for (int tc = 0; tc < testCase; tc++) {
			str = br.readLine().toCharArray();
			Stack<Character> left = new Stack<Character>();
			Stack<Character> right = new Stack<Character>();

			for (int i = 0; i < str.length; i++) {
				switch (str[i]) {
					case '<':
						if (!left.isEmpty()) {
							right.push(left.pop());
						}
						break;
					case '>': 
						if (!right.isEmpty()) {
							left.push(right.pop());
						}
						break;
					case '-':
						if(!left.isEmpty()) {
							left.pop();
						}
						break;
					default:
						left.push(str[i]);
				}
			}
			
			for(Character c : left) {
				sb.append(c);
			}
			
			while(!right.isEmpty()) {
				sb.append(right.pop());
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
