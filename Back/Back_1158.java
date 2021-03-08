package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 1. 1 ~ N -> Q
 * 2. K-1번째 사람들 -> Q의 맨뒤로 보내기
 * 3. K번째 POLL -> 출력
 * 4. Q 안의 사람들이 1명 남을때 까지 반복
 * */
public class Back_1158 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 사람수
		int K = Integer.parseInt(st.nextToken()); // 삭제될 순서
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		// 1~N개 OFFER
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		//N-1 명의 사람들에 대해 작업
		while(q.size() !=1) {
			for(int i = 0 ; i < K-1;i++) {
				q.offer(q.poll());
			}
			
			//K번쨰 사람은 삭제
			sb.append(q.poll()+", ");
		}
		
		//Q 안에 남은 사람 1명
		sb.append(q.poll()+">");
		
		System.out.println(sb);
	}

}


//package com.Back;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class Back_1158 {
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		int TestCase = Integer.parseInt(st.nextToken());
//		int Time = Integer.parseInt(st.nextToken());
//		
//		Queue<Integer> qu = new LinkedList<Integer>();
//		StringBuilder sb = new StringBuilder();
//	
//		
//		for (int tc = 1; tc <= TestCase; tc++) {
//			qu.offer(tc);
//		}
//		
//		sb.append("<");
//		
//		int count=0;
//		int num=0;
//		// 0 1 2
//		while(qu.size()!=0) {
//			if(count==(Time-1)) {
//				sb.append(qu.poll());
//				if(qu.size()>=1) sb.append(", ");
//			}else {
//				num=qu.poll();
//				qu.offer(num);
//			}
//			count=(++count)%3;
//			
//		}
//		sb.append(">");
//		System.out.println(sb);
//		
//	}
//
//}
