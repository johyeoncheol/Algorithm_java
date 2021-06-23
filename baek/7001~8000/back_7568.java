package com.back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class back_7568 {
	static ArrayList<Size> arr= new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int tall = Integer.parseInt(st.nextToken());
			arr.add(new Size(weight, tall));
		}
		
		for (int i = 0; i < N; i++) {
			int rank = 1;
			
			for (int j = 0; j < N; j++) {
				if(i==j)continue;
				if(arr.get(i).tall<arr.get(j).tall && arr.get(i).weight <arr.get(j).weight) {
					rank++;
				}
			}
			sb.append(rank+" ");
		}
		System.out.println(sb);
	}

	static class Size{
		int weight;
		int tall;
		public Size(int weight, int tall) {
			super();
			this.weight = weight;
			this.tall = tall;
		}
	}
}
