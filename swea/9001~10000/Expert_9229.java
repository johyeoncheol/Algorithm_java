package com.Expert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert_9229 {
	static int [] snackWeight;
	static int maxWeight;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TestCase = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TestCase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			//과자 갯수
			int N = Integer.parseInt(st.nextToken());
			//최대 무게
			maxWeight= Integer.parseInt(st.nextToken());
			// 각각의 과자 무게
			snackWeight = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				snackWeight[i]=Integer.parseInt(st.nextToken());
			}
			
			int idx = 0;
			int sum =0;
			int count =0;
			
			int max = maxfind(idx,sum,count,maxWeight);
			System.out.println("#"+tc+" "+max);
		}
	}

	private static int maxfind(int idx, int sum,int count, int remain) {
		// 남아있는게 0보다 작은 경우는 -1 리턴
		if(remain<0) {
			return -1;
		}
		//count로 재귀함수가 돌수 있는 횟수 제한
		if(count==2) {
			return sum;
		}
		// 마지막까지 찾는데 2개가 안된 경우 -1로 리턴
		if(idx == snackWeight.length) {
			return -1;
		}
		
		//선택 안하는 경우 , 선택하는 경우
		int v1 = maxfind(idx+1,sum,count,remain);
		int v2 = maxfind(idx+1, sum+snackWeight[idx],count+1, remain-snackWeight[idx]);
		
		return Math.max(v1, v2);
	}

}
