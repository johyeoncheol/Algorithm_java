package com.Expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 아직 잘 이해하지 못해서 여러 블로그들을 참조해서 만들었습니다...
 * 
 * */
public class Expert_5607 {
	static final int MOD = 1234567891;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			long[] factorial = new long[n+1];
			factorial[0]=1;
			for (int i = 1; i <= n; i++) {
				factorial[i]=(factorial[i-1]*i)%MOD;
			}
			
			//temp는 나누기 였던 것을 곱하기로 바꾸기 위해 페르마 소정리 사용
			long temp = (factorial[r]*factorial[n-r])%MOD;
			long temp2 = ferma(temp,MOD-2);
			
			System.out.println((factorial[n]*temp2)%MOD);
		}
	}
	private static long ferma(long temp, int x) {
		if(x==0)return 1;
		long tmp = ferma(temp, x/2);
		long ans = (tmp*tmp)%MOD;
		if(x%2==0) return ans;
		else return (ans*temp)%MOD;
	}

}
