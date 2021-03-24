package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_1759 {
	static char [] code ;
	static boolean [] visited;
	static char [] codes;
	static int num;
	static int count;
	//모음 갯수
	static int vow=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		count = Integer.parseInt(st.nextToken());
		num = Integer.parseInt(st.nextToken());
		
		code = new char[num];
		codes = new char[count];
		visited= new boolean[num];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++) {
			code[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(code);
		combi(0,0);
	}
	private static void combi(int cnt,int start) {
		if(cnt==count) {
			//vow는 0개 보다 많고 count-vow는 자음의 갯수 이므로 이는 1개보단 많아야 한다.
			if(identiVow(codes)>0 && count-identiVow(codes)>1) {
				for (int i = 0; i < count; i++) {
					System.out.print(codes[i]);
				}
				System.out.println();
				return;
			}
			return;
		}
		
		for (int i = start; i < num; i++) {		
			codes[cnt]=code[i];
			combi(cnt+1,i+1);
		}
	}
	private static int identiVow(char[] code) {
		int temp=0;
		for (int i = 0; i < count; i++) {			
			if(code[i]=='a'||code[i]=='e'||code[i]=='i'||code[i]=='o'||code[i]=='u') {
				temp++;
			}
		}
		return temp;
	}
}
