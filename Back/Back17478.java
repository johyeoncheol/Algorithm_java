package com.Back;

import java.util.Scanner;

public class Back17478 {
	static StringBuffer buf;
	
	public static void recursive(int num, String underBar) {
		String temp = underBar;
					
		//재귀 종료 조건 - Base Case			
		if(num == 0) {
			buf.append(temp + "재귀함수가 뭔가요?\n");
			buf.append(temp + "재귀함수는 자기 자신을 호출하는 함수라네.\n");
			buf.append(temp + "라고 답변하였지.\n");
			return;
		}
		
		//재귀-반복		
		buf.append(temp + "재귀함수가 뭔가요?\n");
		buf.append(temp + "잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
		buf.append(temp + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
		buf.append(temp + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\n");
			
		underBar += "____";	// 호출될 때 마다 밑줄이 2개씩 증가.
		recursive(num-1, underBar);		
		buf.append(temp + "라고 답변하였지.\n");// 재귀 후 출력문
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		buf = new StringBuffer();
		
		buf.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		
		recursive(N, "");
		System.out.println(buf);
		scan.close();
	}

}



//package com.Back;
//
////https://www.acmicpc.net/problem/17478
//public class Back17478 {
//
//	static String answer0="어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
//	static String answer1="\"재귀함수가 뭔가요?\"";
//	static String answer2="\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
//	static String answer3="그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
//	static String answer4="\"재귀함수는 자기 자신을 호출하는 함수라네\"";
//	static String answer5="라고 답변하였지.";
//
//	public static void main(String[] args) {
//		System.out.println(answer0);
//		bot(2);
//	}
//	
//	static void bot(int n) {
//		if(n==0) {
//			System.out.println(answer5);
//		}
//	}
//}
