package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
class Back_15686 {
    static int N;
    static int M;
    static int[][] arr;
    static ArrayList<Dot> chicken;
    static ArrayList<Dot> person;
    static int[] output;
    static boolean[] visited;
    static int result;
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new int[N][N];
        result = Integer.MAX_VALUE;
        chicken = new ArrayList<Dot>();
        person = new ArrayList<Dot>();
 
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
                if (arr[i][j] == 1) {
                    //1일때는 사람 list에 추가
                    person.add(new Dot(i, j));
                } else if (arr[i][j] == 2) {
                    //2일때는 치킨 list에 추가
                    chicken.add(new Dot(i, j));
                }
            }
        }
        //-------입력부-------//
        
        //치킨 집 선택을 위한 배열 visited, output
        visited = new boolean[chicken.size()];
        output = new int[chicken.size()];
        
        //치킨 집 선택
        for (int i = 0; i < chicken.size(); i++) {
            visited[i] = true;
            ChickenSelection(i, 0);
            visited[i] = false;
        }
        System.out.println(result);
    }
    
    //치킨집 선택을 위한 함수
    public static void ChickenSelection(int start, int depth) {
        output[depth] = start + 1;
        
        for (int i = start; i < chicken.size(); i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            ChickenSelection(i, depth + 1);
            visited[i] = false;
        }
        //치킨집이 선택되었을 경우
        //(치킨집이 최대 M개 이므로 depth은 M-1 이 되어야한다. 0부터 시작했으니깐)
        if (depth == M - 1) {
            int sum = 0;
            int currentM = 0;
            //사람이 갈수 있는 치킨집의 경우중 가장 최소값을 선택한다.
            //person 한명씩 모든 Chicken 집을 선택하여 최소값을 비교한다.
            for (int i = 0; i < person.size(); i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < M; j++) {
                    currentM = Calc(person.get(i), chicken.get(output[j] - 1));
                    min = Math.min(min, currentM);
                }
                //최소값일 경우 더한다.
                sum = sum + min;
            }
            //치킨집 경우의 수마다 다른 최소거리중 가장 작은 최소거리를 선택한다.
            result = Math.min(result, sum);
        }
    }
    
    //위치 거리 계산 함수
    public static int Calc(Dot d1, Dot d2) {
        return Math.abs(d1.x - d2.x) + Math.abs(d1.y - d2.y);
    }
}
 
class Dot {
    int x;
    int y;
 
    Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}


//package com.Back;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.StringTokenizer;
//
//class Point{
//	int x;
//	int y;
//	Point(int x,int y){
//		this.x=x;
//		this.y=y;
//	}
//}
//public class Back_15686 {
//
//	static int R,cnt,ans;
//	static int [][] map;
//	
//	//포인트 형식으로 치킨과 사람 배열을 넣음
//	static ArrayList<Point> chi;
//	static ArrayList<Point> per;
//	
//	static boolean[] visited;
//	
//	
//	//상 하 좌 우
//	static int[] dx = {-1,1,0,0};
//	static int[] dy = {0,0,-1,1};
//	
//	public static void main(String[] args) throws Exception {	
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		//R 배열의 크기 , cnt는 최대 치킨가게 수
//		R = Integer.parseInt(st.nextToken());
//		cnt = Integer.parseInt(st.nextToken());
//		//map 초기화
//		map = new int[R][R];
//		
//		chi = new ArrayList<Point>();
//		per = new ArrayList<Point>();
//		
//		// 값 받아 오기
//		for (int i = 0; i < R; i++) {
//			st=new StringTokenizer(br.readLine());
//			for (int j = 0; j < R; j++) {
//				map[i][j]=Integer.parseInt(st.nextToken());
//				if(map[i][j]==1) {
//					//사람인 경우
//					per.add(new Point(i, j));
//				}else if(map[i][j]==2) {
//					//치킨인 경우
//					chi.add(new Point(i,j));
//				}
//			}
//		}	
//		
//		
//		//1. 조합을 이용해서 N개의 치킨집 중에서 cnt 만큼 선택해야함
//		visited = new boolean[chi.size()];
//		
//		// 치킨집 선택
//		for (int i = 0; i < chi.size(); i++) {
//			visited[i]= true;
//		}
//	}
//}
