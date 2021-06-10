package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol_1002 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr= new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int gcd = arr[0];
		int lcm = arr[0];

		for (int i = 1; i < N; i++) {
			gcd = get_gcd(gcd,arr[i]);
			lcm = (lcm *arr[i])/get_gcd(lcm, arr[i]);
		}
		
		System.out.println(gcd+" "+lcm);
	}

	private static int get_gcd(int gcd, int i) {
		int r=0;
		while(i!=0) {
			r = gcd%i;
			gcd = i;
			i = r;
		}
		return gcd;
	}
}
