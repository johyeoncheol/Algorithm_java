package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2578 {

	static int [][] arr = new int[5][5];
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 5; i++) {
			st= new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		boolean flag = false;
		for (int i = 0; i < 5; i++) {
			if(flag==true)break;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				ans=0;
				
				for (int x = 0; x < 5; x++) {
					for (int y = 0; y < 5; y++) {
						if(arr[x][y]==tmp) {
							arr[x][y]=0;
							check();
						}
					}
				}
				if(ans>=3) {
					flag=true;
					System.out.println(i*5+1+j);
					break;
				}
			}
		}
	}
	private static void check() {
		int cross1=0;
		int cross2=0;
		for (int i = 0; i < 5; i++) {
			int cnt1 =0;
			int cnt2 =0;
			for (int j = 0; j < 5; j++) {
				if(arr[i][j]==0) {
					cnt1++;
				}
				if(arr[j][i]==0) {
					cnt2++;
				}
			}
			
			if(arr[i][i]==0) {
				cross1++;
			}
			
			if(arr[i][4-i]==0) {
				cross2++;
			}
			if(cnt1==5) {
				ans++;
			}
			if(cnt2==5) {
				ans++;
			}
		}
		if(cross1==5) {
			ans++;
		}
		if(cross2==5) {
			ans++;
		}
	}
}
