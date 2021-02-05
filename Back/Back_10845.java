package com.Back;

import java.util.Scanner;

public class Back_10845 {
	static String input="15\r\n" + 
			"push 1\r\n" + 
			"push 2\r\n" + 
			"front\r\n" + 
			"back\r\n" + 
			"size\r\n" + 
			"empty\r\n" + 
			"pop\r\n" + 
			"pop\r\n" + 
			"pop\r\n" + 
			"size\r\n" + 
			"empty\r\n" + 
			"pop\r\n" + 
			"push 3\r\n" + 
			"empty\r\n" + 
			"front";
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		int TestCase = sc.nextInt();
		int [] arr = new int[TestCase]; 
		int num=0;
		StringBuilder st = new StringBuilder();
		for(int tc = 0 ; tc < TestCase; tc++) {
			String command =sc.next();
			int input =0;

			if(command.equals("push")) {
				input = sc.nextInt();
			}
			switch (command) {
			case "push":
				arr[num++]=input;
				break;
			case "pop":
				if(num==0) {
					st.append("-1\n");
					break;
				}
				st.append(arr[0]+"\n");
				for (int i = 0; i < arr.length-1; i++) {
					arr[i]=arr[i+1];
				}
				arr[num-1]=0;
				num--;
				break;
			case "size":
				st.append(num+"\n");
				break;
			case "empty":
				if(num==0) {
					st.append("1\n");
				}else {
					st.append("0\n");
				}
				break;
			case "front":
				if(num==0) {
					st.append("-1\n");
					break;
				}
				st.append(arr[0]+"\n");
				break;
			case "back":
				if(num==0) {
					st.append("-1\n");
					break;
				}
				st.append(arr[num-1]+"\n");
				break;
			}
			
		}
		System.out.println(st);
	}

}
