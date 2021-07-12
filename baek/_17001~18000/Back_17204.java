package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_17204 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int [] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int Now = 0,ans=0;
		boolean flag=false;
		boolean visited[] = new boolean[N];
		
		while(true) {
			// 끝난 경우
			if(arr[Now]==K) {
				ans++;
				break;
			}
			//반복 순환 방지
			if(visited[arr[Now]]) {
				flag = true;
				break;
			}
			else {
				Now = arr[Now];
				visited[Now] = true;
				ans++;
			}
		}
		if(flag==true) {
			System.out.println(-1);
		}else {
			System.out.println(ans);
		}
	}
}
