package com.Expert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * */
class Point{
	int x;
	int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

public class Expert_1247 {

	

	static Point home;
	static Point company;
	static Point[] customers;
	static int N, ans;
	// np를 위한 배열, 방문해야 되는 고객 순서
	static int[] selected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TestCase = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TestCase; tc++) {
			ans = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine()); // 고객수
			customers = new Point[N]; // 고객 정보 저장
			selected = new int[N]; // 고객 방문 배열 저장

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			company = new Point(x,y);
			
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			home= new Point(x,y);
			
			for(int i = 0 ; i < N ; i++) {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				customers[i] = new Point(x,y);
			}
			
			//np 사용하기 위해 배열 준비 0,1,2,3,4,.... N-1
			for (int i = 0; i < N; i++) {
				selected[i] = i;
			}
			
			//순열을 만들어서 길이 체크
			do {
				int tmp = calc(selected);
				ans = ans> tmp ? tmp:ans;
			} while (np(selected));
			System.out.println("#");
		}
	}

	private static boolean np(int[] selected) {
		//1. i 찾기(top), i-1번째가 교환 대상
		int i = N - 1;
		while(i>0 && selected[i-1]>=selected[i]) {
			i--;
		}
		//마지막 순열의 경우
		if(i==0)
			return false;
	
		//2. j 찾기
		int j = N-1;
		while(selected[i-1] >= selected[j]) {
			j--;
		}
		//3. i-1 ~ j를 서로 swap
		swap(selected,i-1,j);
		
		//4. i(top)~맨끝(N-1)까지 오름차순 정렬해서 가장 작은 수 만듬
		int k = N-1;
		while(i<k) {
			swap(selected,i++,k--);
		}
		
		return false;
	}

	// selected 배열의 있는 값대로 고객을 방문해서 거리 계산해 봄
	private static int calc(int[] selected) { //012345 , 31245
		int sum = 0;
		//1. 회사~ 첫고객
		sum+= getDistance(company,customers[0]);
		
		//2. N명의 고객 방문
		int i = 0;
		for (i = 0; i < selected.length-1; i++) {
			int from = selected[i]; //시작
			int to = selected[i+1]; //도착
			
			sum+=getDistance(customers[from],customers[to]);
		}
		
		//3. 마지막 고객 ~ 집
		sum+= getDistance(customers[selected[i]],home);
		return sum;
	}
	private static int getDistance(Point from, Point to) {
		return Math.abs(from.x - to.x) + Math.abs(from.y-to.y);
	}

	private static void swap(int[] selected,int i, int j) {
		int tmp = selected[i];
		selected[i] = selected[j];
		selected[j] = tmp;
	}
}
