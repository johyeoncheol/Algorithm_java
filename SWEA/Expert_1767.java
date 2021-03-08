package com.Expert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//프로세서 연결하기
public class Expert_1767{
	
	static int N, max, totalCnt,min, map[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static ArrayList<int[]> list; //고려해야 하는 코어만 담고 있는 리스트
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int [N][N];
			list = new ArrayList<int[]>();
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt =0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i==0 || j==0 || i == N-1 || j==N-1) continue; //가장자리 코어
					if(map[i][j]==1) {
						list.add(new int[] {i,j});
						totalCnt++;
					}
				}
			}
			
			go(0,0);
			System.out.println("#"+tc+" "+min);
		}
	}
	
	//전선을 놓고 안놓고를 부분집합으로 해결하는 부분
	private static void go(int index,int cCnt) { // index : 부분집합에 고려할 코어 인덱스, cCnt: 연결된 코어 개수
		
		if(index == totalCnt) {
			int res = getLength(); // 놓아진 전선의 길이 구하기
			
			if(max < cCnt) {
				max  = cCnt;
				min = res;
			}else if(max == cCnt) {
				if(res<min) min =res;
			}
			return;
		}
		// 코어 선택 전선 놓아보기(4방향으로 놓아보기)
		int[] cur=list.get(index);
		int r = cur[0];
		int c = cur[1];
		for (int d = 0; d < 4; d++) {
			if(isAvailable(r, c, d)) {
				// 전선 놓기
				setStatus(r, c, d, 2);
				// 다음 코어로 넘어가기
				go(index+1,cCnt+1);
				// 다른 방향으로 가기 위해서는 놓았던 전선을 되돌려 놓기
				setStatus(r, c, d, 0);		
			}
		}
		// 코어 비선택
		go(index+1,cCnt);
	}
	
	private static void setStatus(int r,int c,int d,int s) {
		int nr = r, nc =c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr<0||nr>=N||nc<0||nc>=N) break;
			map[nr][nc] =s;
		}
	}
	
	private static boolean isAvailable(int r,int c,int d) {
		int nr = r, nc = c;
		while(true) {
			nr += dr[d];
			nc += dc[d];
			if(nr<0 || nr>=N || nc <0 ||nc>=N) break; // 계속해서 해당방향으로 직진을 해서 경계를 벗어남.:전원 연결 가능
			if(map[nr][nc]>=1) return false; // 코어나 전선이 놓아져있어 불가능.
		}
		return true;
	}
	
	private static int getLength() {
		int lCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==2) lCnt++;
			}
		}
		return lCnt;
	}
}


//package com.Expert;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//class point1{
//	int x;
//	int y;
//	public point1(int x, int y) {
//		this.x=x;
//		this.y=y;
//	}
//}
//
//public class Expert_1767 {
//	
//	static int N;
//	static int linknum = Integer.MIN_VALUE;
//	//정답
//	static int ans = Integer.MAX_VALUE;
//	static int [][] map;
//	static boolean[][] isSelected;
//	
//	static int dx[] = {-1,1,0,0};
//	static int dy[] = {0,0,-1,1};
//	
//	//core를 넣음
//	static ArrayList<point1> arr;
//	
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int testCase = Integer.parseInt(br.readLine());
//		for (int tc = 1; tc <= testCase; tc++) {
//			StringTokenizer st;
//			int N = Integer.parseInt(br.readLine());
//			map = new int[N][N];
//			isSelected = new boolean[N][N];
//			arr = new ArrayList<point1>();
//			
//			//값 넣기
//			for (int i = 0; i < N; i++) {
//				st = new StringTokenizer(br.readLine());
//				for (int j = 0; j < N; j++) {
//					map[i][j]=Integer.parseInt(st.nextToken());
//					if(map[i][j]==1) {
//						arr.add(new point1(i,j));
//					}
//						
//				}
//			}
//			coreLink();
//			
//			arr.clear();
//			linknum = Integer.MIN_VALUE;
//			ans = Integer.MAX_VALUE;
//		}
//	}
//
//	private static void coreLink() {
//		
//		// 테두리에 있는 core 처리
//		for (int i = 0; i < arr.size(); i++) {
//			if(arr.get(i).x == 0|| arr.get(i).y==0 ||arr.get(i).x==N-1||arr.get(i).y==N-1) {
//				isSelected[arr.get(i).x][arr.get(i).y]=true;
//				arr.remove(i);
//				linknum++;
//			}
//		} 
//
//		// 나머지 core에 대한 처리
//		combi(arr.size());
//	}
//
//	//r개의 갯수를 다 배정해주면 끝
//	private static void combi(int r) {
//		
//		isSelected[arr.get(r).x][arr.get(r).y] = true;
//		
//		// 상하좌우
//		for (int k = 0; k < 4; k++) {
//			
//		}
//	}
//}
//
