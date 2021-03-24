package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_13458 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] person = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < num; i++) {
			person[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		// 감독 가능 인원
		int main = Integer.parseInt(st.nextToken());
		int sub = Integer.parseInt(st.nextToken());
		// 정답
		long ans = 0;

		for (int i = 0; i < num; i++) {
				if (person[i] - main <= 0) {
					ans++;
					continue;
				}
				person[i]=person[i] - main;
				ans+=person[i]/sub+1;
				if(person[i]%sub!=0) {
					ans++;
				}
		}
		System.out.println(ans);
	}

}
