package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back_14889 {
	static int size,ans=Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] visit;    

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[size][size];
		visit = new boolean[size];
		
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		combi(0, 0);
		System.out.println(ans);
	}

	private static void combi(int start, int cnt) {
		if (cnt == size / 2) {
			dif();
			return;
		}
		for (int i = start; i < size; i++) {

			if (!visit[i]) {
				visit[i] = true; 
				combi(i + 1, cnt + 1); 
				visit[i] = false;
			}
		}
	}

	static void dif() {
		int team1 = 0;
		int team2 = 0;
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (visit[i] == true && visit[j] == true) {
					team1 += map[i][j];
					team1 += map[j][i];
				}
				else if (visit[i] == false && visit[j] == false) {
					team2 += map[i][j];
					team2 += map[j][i];
				}
			}
		}

		int diff = Math.abs(team1-team2);

		ans = Math.min(diff, ans);
	}

}
