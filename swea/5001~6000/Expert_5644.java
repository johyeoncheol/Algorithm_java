/* 1) 매시간마다 각 위치에서
 * 	playerA : 가능한 BC리스트 (BC1,BC2)
 * 	playerB : 가능한 BC리스트 (BC2,BC3)
 * 
 * 2) 매시간마다 각 위치에서
 * 모든 BC리스트를 가지고 가능한 모든 경우 시도
 * "중복 순열"
 * Player A -> 1 2
 * Player B -> 1 2
 * */

package com.Expert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert_5644 {
	static int M,bcCnt;
	static int[] pathA,pathB,playerA,playerB;
	static int[][] bc;
	
	//그대로, 상, 우, 하, 좌
	static int dx[] = {0,0,1,0,-1};
	static int dy[] = {0,-1,0,1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
		playerA = new int[2];
		playerB = new int[2];
		
		for (int tc = 1; tc <= testCase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			bcCnt = Integer.parseInt(st.nextToken());
			
			playerA[0] = playerA[1] = 1;
			playerB[0] = playerB[1] = 10;
			
			pathA = new int[M+1];
			pathB = new int[M+1];
			bc = new int[bcCnt][4];
			
			StringTokenizer stA = new StringTokenizer(br.readLine()," ");
			StringTokenizer stB = new StringTokenizer(br.readLine()," ");
			
			for (int i = 0; i < M; i++) {
				pathA[i] = Integer.parseInt(stA.nextToken());
				pathB[i] = Integer.parseInt(stB.nextToken());
			}
			
			for (int i = 0; i < bcCnt; i++) {
				st = new StringTokenizer(br.readLine()," ");
				bc[i][0] = Integer.parseInt(st.nextToken()); //x
				bc[i][1] = Integer.parseInt(st.nextToken()); //y
				bc[i][2] = Integer.parseInt(st.nextToken()); //거리
				bc[i][3] = Integer.parseInt(st.nextToken()); //충전량
			}			
			
			System.out.println("#"+tc+" "+move());
		}
	}
	private static int move() {
		int totalSum = 0;
		// 매시간마다의 각 위치에서 두 플레이어의 최대 충전량을 계산하여 합산
		for (int t = 0; t <=M ; t++) { // 초기위치도 처리해야 하기 때문에 0부터
			
			// 두 플레이어 궤적에 따라 이동
			playerA[0] += dx[pathA[t]];
			playerA[1] += dx[pathA[t]];
			playerB[0] += dx[pathB[t]];
			playerB[1] += dx[pathB[t]];
			
			// 현 위치에서의 최대 충전량 계산
			totalSum += getMaxCharge();
		}
		return totalSum;
	}
	private static int check(int a,int x,int y) {
		return Math.abs(bc[a][0]-x)+Math.abs(bc[a][1]-y) <=bc[a][2] ? bc[a][3] :0; 
	}
	private static int getMaxCharge() {
		int max=0;
		for (int a = 0; a < bcCnt; a++) {
			for (int b = 0; b < bcCnt; b++) {
				// 0,0  0,1  0,2  1,0  1,1  1,2  2,0  2,1  2,2
				int sum = 0;
				int amountA = check(a,playerA[0],playerA[1]);
				int amountB = check(b,playerB[0],playerB[1]);
				
				// 두 충전소가 다르면
				if(a !=b) sum = amountA + amountB;
				else sum = Math.max(amountA, amountB);
				
				if(max<sum) max=sum;
			}
		}
		return max;
	}

}

