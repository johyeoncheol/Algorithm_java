package com.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class jungol_1071 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int []arr= new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		
		int temp1=0,temp2=0;
		for (int i = 0; i < N; i++) {
			if(M%arr[i]==0) {
				temp1+=arr[i];
			}
			if(arr[i]%M==0) {
				temp2+=arr[i];
			}
		}
		System.out.println(temp1);
		System.out.println(temp2);
	}
}
