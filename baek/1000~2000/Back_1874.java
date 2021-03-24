package com.Back;

// ���� ���ظ� ���ϰ���
import java.util.Scanner;
import java.util.Stack;

public class Back_1874 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> s = new Stack<>();
		int n = sc.nextInt();
		int[] tmp = new int[n];
		String result = "";

		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			tmp[i] = a;
		}

		int startNum = 1;
		int i = 0;
		s.push(startNum++);
		result += "+\n";
		while (i < n) {
			if (s.empty()) {
				s.push(startNum++);
				result += "+\n";
			} else {
				if (s.peek().intValue() == tmp[i]) {
					s.pop();
					result += "-\n";
					i++;
				} else if (s.peek().intValue() > tmp[i]) {
					result = "NO";
					break;
				} else {
					s.push(startNum++);
					result += "+\n";
				}
			}
		}

		System.out.print(result);
	}
}
