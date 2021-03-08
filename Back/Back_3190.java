//package com.Back;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Back_3190 {
//	
//	//오 아 왼 위
//	static int [] dx = {0,1,0,-1};
//	static int [] dy = {1,0,-1,0};
//	
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int num = Integer.parseInt(br.readLine());
//		int count =0;
//		
//		int temp = Integer.parseInt(br.readLine());
//		
//		for (int i = 0; i < temp; i++) {
//			br.readLine();
//		}
//		
//		int dirNum = Integer.parseInt(br.readLine());
//		int [] dirCount = new int[dirNum];
//		char [] dir = new char [dirNum];
//		StringTokenizer st;
//		for (int i = 0; i < dirNum; i++) {
//			st = new StringTokenizer(br.readLine());
//			dirCount[i] = Integer.parseInt(st.nextToken());
//			dir[i] = st.nextToken().charAt(0);
//		}
//		
//		while(true) {
//			
//		}
//		
//	}
//
//}

//
//package com.Back;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//// 뱀
//// 시뮬레이션 
//public class Back_3190 {
//	static int[][] map; // 0: 빈칸,  1: 사과 존재  2: 몸통 존재
//	static int[] moveX = { 0, 1, 0, -1 };	//상우하좌
//	static int[] moveY = { -1, 0, 1, 0 };
//	static HashMap<Integer, String> move;
//	static Queue<Snake> mySnake;
//	static int nowDirection = 1;	// 현재 뱀의 이동 방향
//	
//	public static void main(String args[]) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		int n = Integer.valueOf(st.nextToken());
//		map = new int[n + 1][n + 1];	// 인덱스 : 1 ~ N
//		move = new HashMap<Integer, String>();
//		mySnake = new LinkedList<Snake>();
//		
//		st = new StringTokenizer(br.readLine());
//		int k = Integer.valueOf(st.nextToken());	// 사과의 개수
//		
//		// 맵에 사과 넣기
//		while(k --> 0) {
//			st = new StringTokenizer(br.readLine());
//			int y = Integer.valueOf(st.nextToken());
//			int x = Integer.valueOf(st.nextToken());
//			
//			map[y][x] = 1;
//		}
//		
//		st = new StringTokenizer(br.readLine());
//		int l = Integer.valueOf(st.nextToken());	// 뱀의 방향 변환 횟수
//		
//		// 이동 방향 바뀌는 시간과 이동 방향 담기
//		while(l --> 0) {
//			st = new StringTokenizer(br.readLine());
//			int time = Integer.valueOf(st.nextToken());
//			String c = st.nextToken();
//			move.put(time, c);
//		}
//		
////		Arrays.sort(move.keySet().toArray());	// 시간 순 오름차순 정렬
//		mySnake.add(new Snake(0, 0));
//		int finishTime = start(2, 1, n);
//		System.out.println(finishTime);
//	}
//	
//	static int start(int x, int y, int n) {
//		int nowTime = 1;
//		
//		while(true) {
////			System.out.println(x + " , " + y + " : " + nowTime);
//			// 뱀이 벽에 부딪힌 경우
//			if((x <= 0 || x > n) || (y <= 0 || y > n)) {
//				return nowTime;
//			}
//			
//			if(map[y][x] == 2) {
//				return nowTime;
//			}
//			
//			if(map[y][x] == 0) {	// 꼬리 제거
//				Snake tail = mySnake.poll();
//				map[tail.y][tail.x] = 0;
//			}
//			mySnake.add(new Snake(x, y));	// 머리 추가
//			map[y][x] = 2;
//			
//			if(move.containsKey(nowTime)) {
//				String c = move.remove(nowTime);
//				if(c.equals("L")) {
//					
//					nowDirection = nowDirection == 0 ? (moveX.length - 1) % 4 : (nowDirection - 1) % 4;
//				}
//				if(c.equals("D")) {
//					nowDirection = (nowDirection + 1) % 4;
//				}
//			}
////			System.out.println(x + " , " + y + " : " + nowTime + ",, direction : " + nowDirection);
//			x += moveX[nowDirection];
//			y += moveY[nowDirection];
//			
//			nowTime++;
//		}
//	}
//}
//
//class Snake {
//	int x;
//	int y;
//	
//	Snake(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//}