package com.Expert;

/**
 *규영이와 인영이는 1에서 18까지의 수가 적힌 18장의 카드로 게임을 하고 있다.

한 번의 게임에 둘은 카드를 잘 섞어 9장씩 카드를 나눈다. 그리고 아홉 라운드에 걸쳐 게임을 진행한다.

한 라운드에는 한 장씩 카드를 낸 다음 두 사람이 낸 카드에 적힌 수를 비교해서 점수를 계산한다.

높은 수가 적힌 카드를 낸 사람은 두 카드에 적힌 수의 합만큼 점수를 얻고,

낮은 수가 적힌 카드를 낸 사람은 아무런 점수도 얻을 수 없다.

이렇게 아홉 라운드를 끝내고 총점을 따졌을 때, 총점이 더 높은 사람이 이 게임의 승자가 된다.

두 사람의 총점이 같으면 무승부이다.

이번 게임에 규영이가 받은 9장의 카드에 적힌 수가 주어진다.

규영이가 내는 카드의 순서를 고정하면, 인영이가 어떻게 카드를 내는지에 따른 9!가지 순서에 따라

규영이의 승패가 정해질 것이다.

이 때, 규영이가 이기는 경우와 지는 경우가 총 몇 가지 인지 구하는 프로그램을 작성하라.


[입력]

첫 번째 줄에 테스트 케이스의 수 T가 주어진다.

각 테스트 케이스의 첫 번째 줄에는 아홉 개의 정수가 공백으로 구분되어 주어진다.

각 정수는 1이상 18이하이며, 같은 정수는 없다.

규영이는 정수가 주어지는 순서대로 카드를 낸다고 생각하면 된다.


[출력]

각 테스트 케이스마다 ‘#x’(x는 테스트케이스 번호를 의미하며 1부터 시작한다)를 출력하고 한 칸을 띄운 후,

인영이가 카드를 내는 9! 가지의 경우에 대해 규영이가 게임을 이기는 경우의 수와 게임을 지는 경우의 수를

공백 하나로 구분하여 출력한다. 
[입력]							[결과]
4
1 3 5 7 9 11 13 15 17           #1 112097 250783
18 16 14 12 10 8 6 4 2          #2 250783 112097
13 17 9 5 18 7 11 1 15          #3 336560 26320
1 6 7 9 12 13 15 17 18          #4 346656 16224
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Expert_6808 {
	static boolean[] card;// 1-18. 전체 카드정보 저장할 배열
	static boolean[] pick;// 선택여부 체크 배열

	static int[] num1 = new int[9];// 규영이가 받은 카드 번호 저장 배열
	static int[] num2 = new int[9];// 인영이가 받은 카드 번호 저장 배열
	static int win, lose;
	static int N = 9;

	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(in.readLine());// tc
		for (int tc = 1; tc <= T; tc++) {
			win = lose = 0;
			card = new boolean[19];
			pick = new boolean[N];

			st = new StringTokenizer(in.readLine().trim());// 1st TC, 9장의 카드에 대한 정보

			int data = 0;
			// 규영이가 받은 카드 저장하기
			for (int i = 0; i < N; i++) {
				data = Integer.parseInt(st.nextToken());// card번호
				card[data] = true;// card배열에 규영이가 받은 카드 번호의 칸에 true로 표시
				num1[i] = data;// 규영이 카드배열에 받은 숫자 하나씩 저장
			} // 입력

			// 인영이가 받은 카드 저장하기. card[i]==1: 규영이가 가진 카드 번호 i
			data = 0;
			for (int i = 1; i < card.length; i++) {
				if (!card[i]) {// 규영이가 안받은 카드임.인영이꺼
					num2[data++] = i;// 인영이 카드배열에 받은 숫자 저장
				}
			} // card 배열에 인영이가 받은 카드 위치에는 false이 저장되어 있음.
			// card 배열에 규영이가 받은 카드 위치에는 true이 저장되어 있음.
			

			perm(0, 0, 0);// 라운드번호(횟수), 규영이점수, 인영이 점수
			//perm2(0, 0, 0, 0);// 라운드번호(횟수), 규영이점수, 인영이 점수
			sb.append("#" + tc + " " + win + " " + lose + "\n");
		}
		System.out.println(sb.toString());
	}

	// 한 라운드 당 규영이와 인영이가 가지고 있는 점수를 비교해서 이기는 횟수와 지는 횟수를 계산하는 메소드
	public static void perm(int round, int sum1, int sum2) {
		if(round == N) {//모든 라운드 끝.총점 비교
			if(sum1 > sum2) win++;
			if(sum1 < sum2) lose++;
			return;
		}
		
		for (int i = 0; i < N; i++) {//인영이 카드를 바꿔볼것
			if(!pick[i]) {//i번째 카드가 사용 x
				pick[i] = true;
				if(num1[round] > num2[i]) {
					perm(round+1, sum1 + num1[round] + num2[i], sum2);
					
				}else {
					perm(round+1, sum1, sum2 + num1[round] + num2[i]);
				}
				pick[i] = false;
			}			
		}		
	}
}


//package com.Expert;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.StringTokenizer;
//
//public class Expert_6808 {
//
//	static int[] Person1;
//	static int[] Person2;
//	static int win;
//	static int lose;
//	
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int TestCase = Integer.parseInt(br.readLine());
//		
//		for (int tc = 1; tc <= TestCase; tc++) {
//			StringTokenizer st= new StringTokenizer(br.readLine());
//			
//			Person1 = new int[9];
//			Person2 = new int[9];
//			
//			for (int i = 0; i < 9; i++) {
//				Person1[i] = Integer.parseInt(st.nextToken());
//			}
//			
//			// 오름차순으로 정렬시켜주기
//			Arrays.sort(Person1);
//			 
//			int count1 =0;
//			int count2 =0;
//			//person2에도 숫자 넣어주기
//			for (int i = 1; i <= 18; i++) {
//				if(count1<9 && Person1[count1]==i) {
//					count1++;
//					continue;
//				}else {
//					Person2[count2] = i;
//					count2++;
//				}
//			}
//			
//			for(int w :Person1) {
//				System.out.print(w+" ");
//			}
//			for(int w :Person2) {
//				System.out.print(w+" ");
//			}
//			
//			//Compare(0);
//		}
//	}
//
////	private static void Compare(int cnt) {
////		if(cnt == 9) {
////			checkWin();
////			return;
////		}
////	}
//
//}
//
//package com.Expert;
//
//import java.util.Scanner;
//
//public class Expert_6808 {
// 
//    static int T;
//    static int[] arr1;
//    static int[] arr2;
//    static int[] mix;
//    static boolean[] otherCards;
//    static boolean[] v;
//    static int win;
//    static int lose;
// 
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        Scanner sc = new Scanner(System.in);
//        T = sc.nextInt();
// 
//        for (int t = 1; t <= T; t++) {
//            win = 0;
//            lose = 0;
//            otherCards = new boolean[19];
//            v = new boolean[9];
//            arr1 = new int[9];
//            arr2 = new int[9];
//            mix = new int[9];
// 
//            for (int i = 0; i < 9; i++) { // 규영이 카드 받기
//                arr1[i] = sc.nextInt();
//                otherCards[arr1[i]] = true;
//            }
// 
//            int count = 0;
//            for (int i = 1; i < otherCards.length; i++) { // 인영이 카드 받기
//                if (otherCards[i] == false) {
//                    arr2[count] = i;
//                    count++;
//                }
//            }
// 
//            npr(0);
// 
//            System.out.println("#" + t + " " + win + " " + lose);
//        }
// 
//    }
// 
//    private static void npr(int cnt) {
//        // TODO Auto-generated method stub
//        if (cnt == 9) {
//            checkWin();
//            return;
//        }
// 
//        for (int i = 0; i < 9; i++) {
//            if (v[i])
//                continue;
// 
//            v[i] = true;
//            mix[cnt] = arr2[i];
//            npr(cnt + 1);
//            v[i] = false;
//        }
//    }
// 
//    private static void checkWin() {
//        // TODO Auto-generated method stub
//        int a = 0;
//        int b = 0;
// 
//        for (int i = 0; i < arr1.length; i++) {
//            if (arr1[i] > mix[i])
//                a += arr1[i] + mix[i];
//            else
//                b += arr1[i] + mix[i];
//        }
// 
//        if (a > b)
//            win++;
//        else
//            lose++;
//    }
// 
//}