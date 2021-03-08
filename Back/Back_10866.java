package com.Back;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Back_10866 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TestCase = Integer.parseInt(br.readLine());
		Deque<Integer> dq = new ArrayDeque<Integer>();
		StringBuilder output = new StringBuilder();
		
		for(int tc = 0 ; tc < TestCase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command =st.nextToken();
			int input =0;

			if(command.equals("push_front")||command.equals("push_back")) {
				input = Integer.parseInt(st.nextToken());
			}
			switch (command) {
			case "push_front":
				dq.offerFirst(input);
				break;
			case "push_back":
				dq.offerLast(input);
				break;
			case "pop_front":
				if(dq.size()==0) {
					output.append("-1\n");
					break;
				}
				output.append(dq.pollFirst()+"\n");
				break;
			case "pop_back":
				if(dq.size()==0) {
					output.append("-1\n");
					break;
				}
				output.append(dq.pollLast()+"\n");
				break;
			case "size":
				output.append(dq.size()+"\n");
				break;
			case "empty":
				if(dq.size()==0) {
					output.append("1\n");
				}else {
					output.append("0\n");
				}
				break;
			case "front":
				if(dq.size()==0) {
					output.append("-1\n");
					break;
				}
				output.append(dq.getFirst()+"\n");
				break;
			case "back":
				if(dq.size()==0) {
					output.append("-1\n");
					break;
				}
				output.append(dq.getLast()+"\n");
				break;
			}
			
		}
		System.out.println(output);
	}
}