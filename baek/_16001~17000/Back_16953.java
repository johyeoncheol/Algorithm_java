package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_16953 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int ans =1;
		
		while(true) {
			if(A==B) {
				break;
			}
			if(A>B) {
				ans = -1;
				break;
			}
			String tmp = String.valueOf(B);
			if(B%2!=0 && tmp.charAt(tmp.length()-1)!='1') {
				ans = -1;
				break;
			}
			
			if(B%2==0) {
				B/=2;
			}else {
				tmp = tmp.substring(0,tmp.length()-1);
				B = Integer.parseInt(tmp);
			}
			
			ans++;
		}
		System.out.println(ans);
	}
}
