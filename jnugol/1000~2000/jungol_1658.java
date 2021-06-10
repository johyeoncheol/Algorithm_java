  package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol_1658 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N1 = Integer.parseInt(st.nextToken());
		int N2 = Integer.parseInt(st.nextToken());
		
		
		int gcd = get_gcd(N1,N2);
		int lcm = gcd;
		lcm = lcm * (N1/gcd);
		lcm = lcm * (N2/gcd);
		System.out.println(gcd);
		System.out.println(lcm);
	}
	
	//유클리드 호제법
	//GCD(A,B) = GCD(B,r)
	private static int get_gcd(int n1, int n2) {
		int r=0;
		while(n2!=0) {
			r = n1%n2;
			n1 = n2;
			n2 = r;
		}
		return n1;
	}
}
