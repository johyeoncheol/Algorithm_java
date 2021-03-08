package com.Expert;

import java.util.Scanner;

public class Expert_1289 {
	static String input="4\r\n" + 
			"0011\r\n" + 
			"100\r\n"+
			"10101111\r\n"+
			"011010101";
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		int TestCase = sc.nextInt();
		String Line = "";
		for(int tc = 0 ; tc <TestCase;tc++ ) {
			int count = 0; 
			Line = sc.next();
			char[] arr = Line.toCharArray();
			if(arr[0]=='1')count++;
			for(int i = 1 ; i < arr.length;i++) {
				if(arr[i]!=arr[i-1]) {
					count++;
				}
			}
			System.out.println("#"+(tc+1)+" "+count);
		}
	}

}
