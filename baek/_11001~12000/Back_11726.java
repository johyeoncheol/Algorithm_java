package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Back_11726 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] D = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			if(i==1) {
				D[i]=1;
			}
			else if(i==2) {
				D[i]=2;
			}
			else {				
				D[i] = (D[i-2]+D[i-1])%10007;
			}
		}
		
		System.out.println(D[N]);
	}

}
