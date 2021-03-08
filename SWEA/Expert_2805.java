package com.Expert;

import java.util.Scanner;

//교수님 풀이
public class Expert_2805 {
	static int[][] map;
	static int N ,center;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc < T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			center = N / 2;
			
			//map 배열 처리
			for (int i = 0; i < N; i++) { // 행
				char [] tmp=sc.next().toCharArray(); //한 행을 위한 배열
				
				for (int j = 0; j < N; j++) { // 열
					//char 타입의 숫자 '2' -> int 타입의 숫자로 바꾸기
					map[i][j] = tmp[j] - '0';
					//System.out.println((int)tmp[j] + ":"+((int)'0'));
				}
			} // 입력
			//입력확인
			
			System.out.println("#"+tc+" "+getHarvest());
		}
	}

	//배열안의 다이아몬드 영역에 해당하는 값들을 더해서 리턴(begin~end)
	private static int getHarvest() {
		// harvest: 총합, begin: 각 행에서 수확할 칸의 시작 인덱스
		// end: 각행에서 수확할 칸의 마지막 인덱스
		// gap: 매행마다 begin, end값을 조정할 변수
		int harvest = 0 , begin = 0 , end = 0 , gap=0;
		
		for (int i = 0; i < N; i++) { //행
			begin = center - gap; // 중앙에서 앞쪽으로 이동
			end = center + gap; // 중앙에서 뒤쪽으로 이동
			for (int j = begin; j <= end; j++) { // 열
				harvest += map[i][j];
			} //주어진 영역 수확
			if(i < center) { //중앙보다 윗쪽
				gap++;
			}else { // center ~ 아래쪽 행
				gap--;
			}
		}
		return 0;
	}
}


//package com.Expert;
//
//import java.util.Scanner;
//
//public class Expert_2805 {
//	static String input="1\r\n" + 
//			"5\r\n" + 
//			"14054\r\n" + 
//			"44250\r\n" + 
//			"02032\r\n" + 
//			"51204\r\n" + 
//			"52212";
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(input);
//		int TestCase= sc.nextInt();
//		for(int tc = 1 ; tc <= TestCase;tc++) {
//			int size=sc.nextInt();
//			char [][] CharMap = new char[size][size];
//			
//			int sum=0;
//			int count=0;
//			int W=size/2;
//			for (int i = 0; i < size; i++) {
//				CharMap[i]= sc.next().toCharArray();
//			}
//			
//			for(int i=0 ; i < size; i++) {				
//				for(int j = W-count ; j<W+count+1;++j) {
//					sum+=Character.getNumericValue(CharMap[i][j]);
//				}
//				if(i<W)count++;
//				else if(i>=W)count--;
//			}
//			System.out.println("#"+tc+" "+sum);			
//		}
//	}
//
//}
