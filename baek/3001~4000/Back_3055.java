package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back_3055 {
	static int Row, Col, ans;
	static char map[][];
	static Queue<point> q1;
	static Queue<point> q2;
	
	//상 하 좌 우
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	}
}

class point{
	int x;
	int y;
	point(int x,int y){
		this.x=x;
		this.y=y;
	}
}
