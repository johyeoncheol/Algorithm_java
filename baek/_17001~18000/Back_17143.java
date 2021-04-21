package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_17143 {
	static int R,C,N,ans;
	static ArrayList<Shark> sharks = new ArrayList<>();
	static int[][] map;
	static Queue<Shark> remove = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		//N이 0인경우 시스템 종료
		if(N==0) {
			System.out.println(0);
			System.exit(0);
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			sharks.add(new Shark(r, c, s, d, z));
		}
		
		for (int i = 1; i <= C; i++) {
			// 낚시꾼이 상어를 잡음
			catchShark(i);

			// 상어의 움직임 체크
			moveShark();
			 
			// 중복되는 상어가 있으면 삭제
			removeShark();
		}
		System.out.println(ans);
	}

	//겹치는거 확인할때는 map
	private static void removeShark() {
		for (int i = 0; i < sharks.size(); i++) {
			for (int j = 0; j < sharks.size(); j++) {
				if(i==j)continue;
				if(sharks.get(i).c==sharks.get(j).c &&
						sharks.get(i).r == sharks.get(j).r) {
					if(sharks.get(i).z>sharks.get(j).z) {
						sharks.remove(j);
					}else {
						sharks.remove(i);
					}
				}
			}
		}
	}
	
	
	private static void catchShark(int k) {
		boolean flag=false;
		for (int i = 1; i <= R; i++) {
			if(flag) break;
			for (int j = 0; j < sharks.size(); j++) {
				if(sharks.get(j).c==k && sharks.get(j).r==i) {
					ans+=sharks.get(j).z;
					sharks.remove(j);
					flag = true;
					break;
				}
			}
		}
	}
	
	private static void moveShark() {
		for (int i = 0; i < sharks.size(); i++) {
			if(sharks.get(i).d==1 ||sharks.get(i).d==2) {
				//(R-1)/2의 횟수만큼 반복함
				int moveCount = sharks.get(i).s % ((R-1)*2);
				while(moveCount!=0) {
					//
					if(sharks.get(i).r==1) {
						sharks.get(i).d=2;
					}else if(sharks.get(i).r==R) {
						sharks.get(i).d=1;
					}
					
					if(sharks.get(i).d==1) {
						sharks.get(i).r-=1;
					}else if(sharks.get(i).d==2) {
						sharks.get(i).r+=1;
					}
					moveCount--;
				}
			}else {
				//(C-1)/2의 횟수만큼 반복함
				int moveCount = sharks.get(i).s % ((C-1)*2);
				while(moveCount!=0) {
					//
					if(sharks.get(i).c==1) {
						sharks.get(i).d=3;
					}else if(sharks.get(i).c==C) {
						sharks.get(i).d=4;
					}
					
					if(sharks.get(i).d==3) {
						sharks.get(i).c+=1;
					}else if(sharks.get(i).d==4) {
						sharks.get(i).c-=1;
					}
					moveCount--;
				}
			}
		}
	}

	static class Shark{
		//위치,위치,속력,이동방향,크기
		int r;
		int c;
		int s;
		int d;
		int z;
		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		
	}
}
