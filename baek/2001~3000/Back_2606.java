package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_2606 {

	static int comNum,linkNum,ans;
	static boolean [][] map ;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		comNum = Integer.parseInt(br.readLine());
		linkNum = Integer.parseInt(br.readLine());
		
		//0은 사용하지 않음
		map = new boolean[comNum+1][comNum+1];
		isSelected = new boolean[comNum+1];
		
		for (int i = 0; i < linkNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			map[from][to]=true;
			map[to][from]=true;
		}
		//1부터 comNum까지 돌면 된다.
		dfs(1);
		
		System.out.println(ans-1);
	}

	private static void dfs(int cnt) {
		if(isSelected[cnt]==true) return; //기저조건
		
		isSelected[cnt] = true; // 방문 처리
		ans++;
		
		for (int i = 0; i < comNum+1; i++) {
			if(map[cnt][i]==true && !isSelected[i])
				dfs(i);
		}
		
	}

}
