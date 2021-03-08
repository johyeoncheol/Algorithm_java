package com.Back;

import java.util.ArrayList;
import java.util.Scanner;

public class Back_17135 {
	static int N, M, D,max;
	static int selected[]; // 궁수들 조합 결과 0, 1, 2
	static ArrayList<Enemy> elist;
	
	static class Enemy{
		int r , c;
		public Enemy(int r,int c) {
			this.r=r; // 한행 하갈할 때 조정 +1
			this.c=c; // 더 왼쪽에 있는 적 결정할 때 사용
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1.초기값 입력
		N = sc.nextInt(); //행
		M = sc.nextInt(); //열
		D = sc.nextInt(); //유효거리
		
		//2. 적 정보 입력
		elist = new ArrayList<Enemy>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(sc.nextInt() == 1) {
					elist.add(new Enemy(i,j));
				}
			}
		}
		
		//3. 궁수의 조합을 만들어 몇명을 죽일 수 있는지 계산
		combination(0,0);
		
		//4. max 출력
		System.out.println(max);
	}
	
	//궁수 조합 만들기
	private static void combination(int cnt, int start) {
		if(cnt == 3) { // 조합 한개 완성 , 궁수 3명 준비 -> 쏴보기
			ArrayList<Enemy> elist2 = new ArrayList<Enemy>(); // copy
			for(Enemy x: elist) {
				elist2.add(new Enemy(x.r, x.c));
			}// 복사본, 각 조합마다 쏴봐야 하므로 원본에는 손대면 안됨
			
			int killed = gameStart(elist2,selected);
			max = Math.max(max,killed);
			return;
		}
		
		for (int i = start; i < M; i++) {
			selected[cnt] = i;
			combination(cnt+1, i+1);
		}
	}

	private static int gameStart(ArrayList<Enemy> elist2, int[] selected2) {
		int cnt = 0 ; //적의 수
		
		while(elist2.size() !=0) { // 적이 있는 동안
			
			ArrayList<Enemy> tmp = new ArrayList<>();
			//궁수 3명이 쏠거임 , 자신에게서 제일 가까운 적을 찾아서 모아놈.
			for( int pos: selected2) {
				//자신에게서 제일 가까운 적을 찾음
				int targetIndex = findNear(elist2,pos);
				if(targetIndex >= 0) { // 적이 있으면
					tmp.add(elist2.get(targetIndex));
				}
			} //요기까지 오면 궁수 3명이 tmp에 죽일 놈 정보를 저장한 후
			
			//요기서 죽임
			for(Enemy x: tmp) {
				if(elist2.remove(x)) { // 삭제한 경우
					cnt ++; //죽일놈 증가
				}
			}
			enemyDown(elist2); // 적 하강
		}
		return cnt;
	}

	private static void enemyDown(ArrayList<Enemy> elist2) {
		for(Enemy x : elist2) {
			if(x.r==N-1) {
				elist2.remove(x);
			}
			x.r++;
		}
	}

	private static int findNear(ArrayList<Enemy> elist2, int pos) {
		
		return 0;
	}
}

// 테케에 있는 예제들은 통과가 되는데
// 막상 실행을 돌리면 실패....

//package com.Back;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Back_17135 {
//
//	static int N , M, D;
//	static int [][] Map;
//	static int [][] input;
//	static int tempCount;
//	static int killCount;
//	//상 하 좌 
//	static int [] dx = {0,-1,0};
//	static int [] dy = {-1,0,1};
//			
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		//맵의 행 N , 맵의 열 M
//		N=Integer.parseInt(st.nextToken());
//		M=Integer.parseInt(st.nextToken());
//		input = new int[N][M];
//		Map = new int[N][M];
//		
//		// 사정거리 설정
//		D=Integer.parseInt(st.nextToken());
//		
//		// 맵 생성
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			for (int j = 0; j < M; j++) {
//				input[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//
//		// 궁수 배치할 공간 생성
//		int [] location = new int[M];
//		int cnt = 0;
//		
//		// 뒷쪽부터 R개 만큼 1을 채움
//		while (++cnt <= 3)
//			location[M - cnt] = 1;
//
///* TestCase 1 기준으로
// * 이 순으로 궁수가 배치 됨
// * X X 1 1 1 
//   X 1 X 1 1 
//   X 1 1 X 1 
//   X 1 1 1 X 
//   1 X X 1 1 
//   1 X 1 X 1 
//   1 X 1 1 X 
//   1 1 X X 1 
//   1 1 X 1 X 
//   1 1 1 X X 
//* */
//		do {
//			tempCount=0;
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					Map[i][j]=input[i][j];
//				}
//			}
//			for (int i = 0; i < N; i++) {
//				for(int j = 0 ; j<M;j++ ) {
//					if(location[j]==1) {
//						// 거리가 1인 경우
//						if(Map[N-i-1][j]==1) {
//							Map[N-i-1][j]=0;
//							tempCount++;
//							continue;
//						}
//						//D 사거리 , j는 
//						direction(1,N-i-1,j);
//					}
//				}
//			}
//			killCount=killCount<tempCount?tempCount:killCount;
//		} while (np(location));
//		System.out.println(killCount);
//	}
//	
//	private static void direction(int cnt,int h, int w) {
//			if(cnt==D) return;
//			for (int j = 0; j < 3; j++) {
//				int	xx =h+ dx[j];
//				int	yy =w+ dy[j];
//				if(xx>=0 && xx<N && yy>=0 && yy<M && Map[xx][yy]==1) {
//					Map[xx][yy]=0;
//					tempCount++;
//					return;
//				}
//			}
//			direction(cnt+1,h,w-1);
//			direction(cnt+1,h-1,w);
//			direction(cnt+1,h,w+1);
//	}
//
//	public static boolean np(int[] arr) {
//		
//		//STEP1
//		int i = M-1;
//		while(i>0 && arr[i-1]>=arr[i]) --i;
//		
//		// 더이상 앞자리가 없는 상황 : 현 순열의 상태가 가장 큰 순열(마지막 순열)
//		if(i==0) return false;
//		
//		//STEP2
//		int j = M-1;
//		while(arr[i-1] >= arr[j]) --j;
//		
//		//STEP3
//		swap(arr,i-1,j);
//		
//		//STEP4
//		int k = M-1;
//		while(i<k) {
//			swap(arr,i++,k--);
//		}
//		
//		return true;
//	}
//	
//	private static void swap(int[] arr,int i , int j) {
//		int temp = arr[i];
//		arr[i] = arr[j];
//		arr[j] = temp;
//	}
//
//}
