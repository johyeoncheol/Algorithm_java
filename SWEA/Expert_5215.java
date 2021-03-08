package com.Expert;

import java.util.Scanner;

public class Expert_5215 {
	static int R[][], maxCal; // R[][]: 각 재료별 점수와 칼로리 저장할 배열
	
	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // tc no
		
		for (int tc = 1; tc <= T; tc++) {
			// 재료 갯수
			int N = sc.nextInt(); //재료 갯수
			maxCal = sc.nextInt();//제한 열량
			
			R = new int[N][2]; //[0]맛에 대한 점수, [1] 칼로리
			for (int i = 0; i < N; i++) {
				R[i][0]=sc.nextInt(); // 점수
				R[i][1]=sc.nextInt(); // 칼로리
			}
			
			//각 재료별 조합을 만들어 그때의 맛점수가 최고인 것 찾기
			int idx = 0; // 조합할 재료 번호
			int score=0; //맛 점수, 재료를 선택해 나갈 때마다 올라감
			
			int max = find(idx,score,maxCal);
			System.out.println("#"+tc+" "+max);
		}
	}

	/*idx번째의 재료를 고려해서 (넣을수도 있고 뺄수도 있다)
	 *  조합을 만들었을 때 칼로리 체크 후 맛점수 리턴하는 함수
	 *  idx : 사용할 재료 번호 , 
	 *  score : idx 번째 재료를 고려했을때의 맛점수,
	 *  remain : 남아있는 사용 가능 칼로리
	 */
	private static int find(int idx, int score, int remain) {
		
		if(remain < 0) {
			return 0;
		}
		if(remain == 0) {
			return score;
		}
		if(idx == R.length) {
			return score;
		}
		
		//idx번째 재료를 사용하지 않은 경우
		int v1 = find(idx+1,score,remain); // 그 다음 재료로
		
		//idx번째 재료를 사용한 경우
		int v2 = find(idx+1,score+R[idx][0],remain - R[idx][1]);
		
		return Math.max(v1, v2);
	}


}


//package com.Expert;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Expert_5215 {
//
//	static int MaxCal,SumCal,tc,num,Score;
//	static StringBuilder sb = new StringBuilder();
//	static int [][] material;
//	
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int testCase = Integer.parseInt(br.readLine());
//		
//		
//		for (tc = 0; tc < testCase; tc++) {
//			StringTokenizer line = new StringTokenizer(br.readLine());
//			
//			// 조합의 수
//			num = Integer.parseInt(line.nextToken());
//			MaxCal = Integer.parseInt(line.nextToken());
//			material = new int [num][2];
//			
//			for (int i = 0; i < num; i++) {
//				StringTokenizer line2 = new StringTokenizer(br.readLine());
//				material[i][0] = Integer.parseInt(line2.nextToken());
//				material[i][1] = Integer.parseInt(line2.nextToken());
//			}
//			
//			SumCal=0;
//			Score=0;
//			
//
//		}
//			
//	}
//	
//	private static int Combi() {
//		if(SumCal>MaxCal) {
//			return Score;
//		}
//		for (int i = 0; i < num; i++) {
//			
//		}
//		return 0;
//	}
//
//}
