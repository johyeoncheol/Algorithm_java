package com.Expert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 1. 정점이 연사자 일때 자식은
 * 	1) 연산자 + 연산자
 * 	2) 연산자 + 숫자
 * 	3) 숫자 + 숫자
 * 	4) 숫자 + 연산자는 안됨
 * 2. 정점이 숫자일때 자식은 없어야함
 * */
public class Expert_1233 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N;//정점 개수
		char[] tree;
		
		for (int i = 1; i < 10; i++) {
			N = Integer.parseInt(br.readLine());
			tree = new char[N+1]; // 1번 정점부터~
			
			boolean flag = true; // 식의 유효성 체크
			for (int j = 0; j < N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int index = Integer.parseInt(st.nextToken()); // 정점 번호
				tree[index] = st.nextToken().charAt(0); // 정점이 가지는 값
			}//입력
			
			//모든 정점에 대한 조사
			int left,right;
			for (int j = 1; j <=N; j++) {
				left = j * 2;
				right = left + 1;

				// 1.정점이 연산자인 경우
				// Character.isDigit는 숫자인지를 묻는 방법!
				if (!Character.isDigit(tree[j])) { // 연산자
					// 왼쪽 , 오른쪽 자식이 있고
					if (left <= N && right <= N) {
						if (Character.isDigit(tree[left]) && Character.isDigit(tree[right])) {
							flag = false;
						}
					} else { // 자식이 없으면
						flag = false;
					}
					// 2. 정점이 숫자인 경우 -> 자식이 있으면 안됨
				} else {
					if (left <= N) {
						flag = false;
					}
				}
				if (!flag)
					break;
			}
			System.out.println("#" + i + " " + (flag ? 1 : 0));
		}
	}
}
