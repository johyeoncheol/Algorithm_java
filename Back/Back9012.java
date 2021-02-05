//package com.Back;
//
//import java.util.Scanner;
//import java.util.Stack;
////https://www.acmicpc.net/problem/9012
//public class Back9012 {
//	static String input= "6\r\n" + 
//			"(())())\r\n" + 
//			"(((()())()\r\n" + 
//			"(()())((()))\r\n" + 
//			"((()()(()))(((())))()\r\n" + 
//			"()()()()(()()())()\r\n" + 
//			"(()((())()(";
//	public static void main(String[] args) {
//		//char이 아닌 레퍼런스 형태인 Character 사용
//		Stack<Character> stack = new Stack<>();
//		Scanner sc = new Scanner(input);
//		int TestCase = sc.nextInt();
//		for (int tc = 0; tc < TestCase; tc++) {
//			String line = sc.next();
//			char[] arr = line.toCharArray();
//			for (int i = 0; i < arr.length; i++) {
//				//(인경우 그대로 넣으면 된다.
//				if (arr[i] == '(')
//					stack.push(arr[i]);
//				else {
//					//)인 경우
//					// 만약에 비었다면 No가 되므로 넣고 break;
//					if (stack.isEmpty()) {
//						stack.push(arr[i]);
//						break;
//					//비어 있지 않다면 짝을 이루기 때문에 pop을 해서 (을 빼준다.
//					} else
//						stack.pop();
//				}
//			}
//			if (!stack.isEmpty())
//				System.out.println("NO");
//			else
//				System.out.println("YES");
//			stack.removeAllElements();
//		}
//		sc.close();
//	}
//}

//package com.Back;
//
//import java.util.Scanner;
//
//public class Back9012 {
//	static String input= "6\r\n" + 
//			"(())())\r\n" + 
//			"(((()())()\r\n" + 
//			"(()())((()))\r\n" + 
//			"((()()(()))(((())))()\r\n" + 
//			"()()()()(()()())()\r\n" + 
//			"(()((())()(";
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(input);
//		int TestCase = sc.nextInt();
//		
//		for(int tc =0 ; tc< TestCase;tc++) {
//			String line = sc.next();
//			char[] arr = line.toCharArray();
//			int Count=1;
//			if(arr[0]==')') {
//				System.out.println("NO");
//				continue;
//			}
//			for(int i = 1 ; i <arr.length;i++ ) {
//				if(arr[i]=='(') {
//					Count++;
//				}else {
//					Count--;
//				}
//				if(Count<0) {
//					Count=-1;
//					break;
//				}
//			}
//			if(Count==0) {
//				System.out.println("YES");
//			}else {
//				System.out.println("NO");
//			}
//		}
//	}
//
//}
