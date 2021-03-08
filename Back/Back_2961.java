package com.Back;

import java.util.Scanner;

public class Back_2961{
	static int n , r;
	static int[] sour , bitter,result;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			sour[i] = sc.nextInt();
			bitter[i] = sc.nextInt();
		}
		
		for (int i = 1; i < n+1; i++) {
			r = i;
			combi(0,0); // n개 중에 r 개를 고르는 조합
		}
		System.out.println(min);
	}
	
	private static void combi(int cnt,int start) {
		if(cnt == r) { // 다 고름. 하나의 조합이 완성. 계산
			int sum = 0;
			int mul =1;
			for (int i = 0; i < r; i++) { //선택한 재료 개수만큼만 반복
				mul = mul * sour[result[i]];
				sum = sum + bitter[result[i]];
			}
			min = Math.min(min, Math.abs(sum-mul));
			return;
		}
		
		for (int i = start; i < n; i++) {
			result[cnt] = i; // 사용할 재료의 인덱스를 저장 , result[0] = 0;
			combi(cnt+1,i+1);
		}
	}
}

//package com.Back;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Back_2961 {
//
//	//신맛 - 곱
//	static int [] S;
//	//짠맛 - 합
//	static int [] B;
//	static int num;
//	static int gap=Integer.MAX_VALUE;
//	
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		num = Integer.parseInt(br.readLine());
//		
//		StringTokenizer st;
//		
//		S = new int[num]; 
//		B = new int[num]; 
//		
//		for (int i = 0; i < num; i++) {
//			st= new StringTokenizer(br.readLine());
//			
//			S[i] = Integer.parseInt(st.nextToken());
//			B[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		Selection(1<<num);
//		System.out.println(gap);
//	}
//
//	private static void Selection(int cnt) {
//		for (int flag = 1; flag < cnt; flag++) {
//			//맨 뒤부터 N개의 비트열을 확인
//			int temp1=0 , temp2=1;
//			for (int j = 0; j < num; j++) {
//				if((flag & 1<<j) !=0) { 
//					temp1+=B[j];
//					temp2*=S[j];
//				}
//			}
//			if(gap>Math.abs(temp2-temp1)) gap=Math.abs(temp2-temp1);
//			
////			if(temp2>temp1) {
////				if(gap>(temp2-temp1)) gap=temp2-temp1;
////			}else {
////				if(gap>(temp1-temp2)) gap=temp1-temp2;
////			}
//		}
//	}
//	
//
//}
