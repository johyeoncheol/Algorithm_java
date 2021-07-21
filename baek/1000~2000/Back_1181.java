package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Back_1181 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayList<word> arr = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			arr.add(new word(temp.length(), temp));
		}
		Collections.sort(arr);
		sb.append(arr.get(0).word + "\n");
		String temp = arr.get(0).word;
		for (int i = 1; i < arr.size(); i++) {
			if (temp.equals(arr.get(i).word)) {
				continue;
			}
			temp = arr.get(i).word;
			sb.append(arr.get(i).word + "\n");
		}
		System.out.println(sb);
	}

	static class word implements Comparable<word> {
		int len;
		String word;

		public word(int len, String word) {
			this.len = len;
			this.word = word;
		}

		@Override
		public int compareTo(word o) {
			if (this.len == o.len) {
				return this.word.compareTo(o.word);
			}
			return this.len - o.len;
		}

	}
}

//package com.Back;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class Back_1181 {
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int N = Integer.parseInt(br.readLine());
//		ArrayList<word> arr = new ArrayList<>();
//		for (int i = 0; i < N; i++) {
//			String temp = br.readLine();
//			arr.add(new word(temp.length(), temp));
//		}
//		Collections.sort(arr);
//		sb.append(arr.get(0).word+"\n");
//		String temp = arr.get(0).word;
//		for (int i = 1; i < arr.size(); i++) {
//			if(temp.equals(arr.get(i).word)) {
//				continue;
//			}
//			temp=arr.get(i).word;
//			sb.append(arr.get(i).word+"\n");
//		}
//		System.out.println(sb);
//	}
//	static class word implements Comparable<word>{
//		int len;
//		String word;
//		
//		public word(int len, String word) {
//			this.len = len;
//			this.word = word;
//		}
//
//		@Override
//		public int compareTo(word o) {
//			if(this.len==o.len) {
//				for (int i = 0; i < this.len; i++) {
//					if(this.word.charAt(i)==o.word.charAt(i)) {
//						continue;
//					}
//					return this.word.charAt(i)-o.word.charAt(i);
//				}
//			}
//			return this.len-o.len;
//		}
//		
//	}
//}
