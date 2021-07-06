package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Back_4949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String temp = br.readLine();
			Stack<String> arr = new Stack<String>(); 
			if(temp.charAt(0)=='.') {
				break;
			}
			for (int i = 0; i < temp.length(); i++) {
				if(temp.charAt(i)=='(' || temp.charAt(i)=='[') {
					arr.add(Character.toString(temp.charAt(i)));
					continue;
				}else if(temp.charAt(i)==')') {
					if(arr.size()!=0 && arr.peek().charAt(0)=='(') {
						arr.pop();
						continue;
					}
					arr.add(Character.toString(temp.charAt(i)));
					break;
				}
				else if(temp.charAt(i)==']') {
					if(arr.size()!=0 && arr.peek().charAt(0)=='[') {
						arr.pop();
						continue;
					}
					arr.add(Character.toString(temp.charAt(i)));
					break;
				}
				
				
			}

			if(arr.size()==0) {
				sb.append("yes\n");
			}else {
				sb.append("no\n");
			}
		}
		System.out.println(sb);
	}
}
