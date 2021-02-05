package com.Expert;

//문자의미
//.	평지(전차가 들어갈 수 있다.)
//*	벽돌로 만들어진 벽
//#	강철로 만들어진 벽
//-	물(전차는 들어갈 수 없다.)
//^	위쪽을 바라보는 전차(아래는 평지이다.)
//v	아래쪽을 바라보는 전차(아래는 평지이다.)
//<	왼쪽을 바라보는 전차(아래는 평지이다.)
//>	오른쪽을 바라보는 전차(아래는 평지이다.)


//들어가기 전에 만들 로직을 정리해 둔다.
/* 1. map을 입력. 입력 받고 전차의 위치 찾아놓기
 * 2. 명령 입력 받기
 * 3. 명령어 내용에 따라 동작
 * 	3-1. 이동(UDLR)
 *  3-2. SHOOT
 * */
import java.util.Scanner;

public class Expert_1873 {
	// 상 , 하 , 좌 , 우
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	static int H,W;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1 ; tc <= T; tc++) {
			//1.MAP의 크기 입력
			H = sc.nextInt();
			W = sc.nextInt();
			char[][] map = new char[H][W];
			
			//전차의 좌표저장하는 배열
			int [] tank = new int[2];
			
			//입력
			for (int i = 0; i < H; i++) {
				//한 행에 입력이 됨
				map[i] = sc.next().toCharArray();
				for (int j = 0; j < map[i].length; j++) {
					switch (map[i][j]) {
					case '<':
					case '>':
					case '^':
					case 'v':
						tank[0] = i;
						tank[i] = j;
						break;
					
					}
				}
			} // 입력 완료 , 전차 찾기 완료
				
			//명령 갯수와 내용을 입력
			int N = sc.nextInt(); //23
			String command = sc.next();
			
			for (int i = 0; i < N; i++) {
				char c = command.charAt(i); // 명령어 한글자
				switch (c) {
					case 'U': {//상
						map[tank[0]][tank[1]]='^'; // 방향 전환
						move(map, tank, 0);
						break;
					}
					case 'D': {//하
						map[tank[0]][tank[1]]='v'; // 방향 전환
						move(map, tank, 1);
						break;
					}
					case 'L': {//좌
						map[tank[0]][tank[1]]='<'; // 방향 전환
						move(map, tank, 2);
						break;
					}
					case 'R': {//우
						map[tank[0]][tank[1]]='>'; // 방향 전환
						move(map, tank, 3);
						break;
					}
					case 'S': {//슛
						shoot(map,tank);
						break;
					}
				}//switch
			}//for
			System.out.print("#"+tc+" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.println(map[i][j]);
				}
			}
		}
		
	}//main
	
	private static void shoot(char[][] map, int[] tank) {
		int dir = 0;
		
		//map[tank[0]][tank[1]] <- '^','v','<','>'
		//1. 현재 전차의 방향에 따라 그 방향으로 쏴야 함
		switch (map[tank[0]][tank[1]]) {
		case '<':
			dir=0;
			break;
		case '>':
			dir=1;
			break;
		case '^':
			dir=2;
			break;
		case 'v':
			dir=3;
			break;
		}
		
		//2. 전차의 현재 위치
		int tx = tank[0];
		int ty = tank[1];
		
		//3. 가능할 때까지 포탄이 계속 이동하면서 쏠거임
		while(true) {
			//3-1 포탄이 날아갈 새 좌표
			tx = tx + dx[dir];
			ty = ty + dy[dir];
			
			//3-2 새좌표의 유효성 체크
			if(tx < 0 || ty < 0 || tx>=H || ty >=W) return;
			
			//3-3 벽돌벽인 경우(평지로 바뀜)
			if(map[tx][ty] == '*') {
				map[tx][ty]= '.'; // 평지로 바꾸고
				return;
			}else if(map[tx][ty] == '#') {//3-4 강철벽인 경우(그냥 끝)
				return;
			}
		}
	}
	
	//지정한 방향의 새 좌표로 전차 이동
	private static void move(char[][]map,int[] tank, int dir) {
		// 전차의 방향은 이미 바꾸고 있음
		// 1. 전차가 이동할 방향으로 새 좌표 계산
		int nx = tank[0] + dx[dir]; // 현재 전차의 x 좌표
		int ny = tank[1] + dy[dir]; // 현재 전차의 y 좌표
		
		// 2. 새좌표의 유효성 체크
		if(nx < 0 || ny < 0 || nx>=H || ny >=W) return;
		
		// 3. 이동 가능(평지이어야만 가능)
		if(map[nx][ny] == '.') {
			//3.1. 새 위치에 전차를 이동시킴
			map[nx][ny] = map[tank[0]][tank[1]];
			//3.2. 원래 전차가 있던 자리는 평지로 바꿈
			map[tank[0]][tank[1]]='.';
			//3.3. 전차의 좌표 갱신
			tank[0]=nx;
			tank[1]=ny;
		}
	}

}



//package com.Expert;
//
////문자의미
////.	평지(전차가 들어갈 수 있다.)
////*	벽돌로 만들어진 벽
////#	강철로 만들어진 벽
////-	물(전차는 들어갈 수 없다.)
////^	위쪽을 바라보는 전차(아래는 평지이다.)
////v	아래쪽을 바라보는 전차(아래는 평지이다.)
////<	왼쪽을 바라보는 전차(아래는 평지이다.)
////>	오른쪽을 바라보는 전차(아래는 평지이다.)
//
//import java.util.Scanner;
//
//public class Expert_1873 {
//	static String input="2\r\n" + 
//			"3 7\r\n" + 
//			"***....\r\n" + 
//			"*-..#**\r\n" + 
//			"#<.****\r\n" + 
//			"23\r\n" + 
//			"SURSSSSUSLSRSSSURRDSRDS\r\n"+
//			"3 7\r\n" + 
//			"***..*.\r\n" + 
//			"*-..#.*\r\n" + 
//			"#<.**.*\r\n" + 
//			"23\r\n" + 
//			"SURSSSSUSLSRSSSURRDSRDS";
//			
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(input);
//		int TestCase = sc.nextInt();
//
//		for (int tc = 1; tc <= TestCase; tc++) {
//			int Height = sc.nextInt();
//			int Width = sc.nextInt();
//
//			char [][] Map = new char[Height][Width];
//			for (int i = 0; i < Map.length; i++) {
//				Map[i]=sc.next().toCharArray();
//			}
//			
//			int NowX = 0;
//			int NowY = 0;
//			
//			//현재 위치 찾기
//			for (int i = 0; i < Height; i++) {
//				for (int j = 0; j < Width; j++) {
//					if(Map[i][j]=='^'||Map[i][j]=='v'||Map[i][j]=='<'
//							||Map[i][j]=='>') {
//						NowX = i;
//						NowY = j;
//						break;
//					}
//				}
//			}
//			
//			// 명령수와 명령 받아오기
//			int ComNum = sc.nextInt();
//			String Command = sc.next();
//			//탄 위치
//			int ShootX=0;
//			int ShootY=0;
//			
//			for (int i = 0; i < ComNum; i++) {
//				if(Command.charAt(i)=='U') {
//					Map[NowX][NowY]='^';
//					if(NowX-1>=0 && Map[NowX-1][NowY]=='.') {
//						Map[NowX][NowY]='.';
//						NowX=NowX-1;
//						Map[NowX][NowY]='^';
//					}
//					continue;
//				}else if(Command.charAt(i)=='D') {
//					Map[NowX][NowY]='v';
//					if(NowX+1<Height&&Map[NowX+1][NowY]=='.') {
//						Map[NowX][NowY]='.';
//						NowX=NowX+1;
//						Map[NowX][NowY]='v';
//					}
//					continue;
//				}else if(Command.charAt(i)=='L') {
//					Map[NowX][NowY]='<';
//					if(NowY-1>=0&&Map[NowX][NowY-1]=='.') {
//						Map[NowX][NowY]='.';
//						NowY=NowY-1;
//						Map[NowX][NowY]='<';
//					}
//					continue;
//				}else if(Command.charAt(i)=='R') {
//					Map[NowX][NowY]='>';
//					if(NowY+1<Width&&Map[NowX][NowY+1]=='.') {
//						Map[NowX][NowY]='.';
//						NowY=NowY+1;
//						Map[NowX][NowY]='>';
//					}
//					continue;
//				}else if(Command.charAt(i)=='S') {
//					ShootX=NowX;
//					ShootY=NowY;
//					if(Map[NowX][NowY]=='^') {
//						while(true) {
//							ShootX--;
//							if(ShootX<0 || Map[ShootX][ShootY]=='#') break;
//							if(Map[ShootX][ShootY]=='*') {
//								Map[ShootX][ShootY]='.';
//								break;
//							}
//						}
//						continue;
//					}else if(Map[NowX][NowY]=='v') {
//						while(true) {
//							ShootX++;
//							if(ShootX>=Height || Map[ShootX][ShootY]=='#') break;
//							if(Map[ShootX][ShootY]=='*') {
//								Map[ShootX][ShootY]='.';
//								break;
//							}
//						}
//						continue;
//					}else if(Map[NowX][NowY]=='<') {
//						while(true) {
//							ShootY--;
//							if(ShootY<0 || Map[ShootX][ShootY]=='#') break;
//							if(Map[ShootX][ShootY]=='*') {
//								Map[ShootX][ShootY]='.';
//								break;
//							}
//						}
//						continue;
//					}else if(Map[NowX][NowY]=='>') {
//						while(true) {
//							ShootY++;
//							if(ShootY>=Width || Map[ShootX][ShootY]=='#') break;
//							if(Map[ShootX][ShootY]=='*') {
//								Map[ShootX][ShootY]='.';
//								break;
//							}
//						}
//						continue;
//					}
//				}
//			}
//			
//			System.out.print("#"+tc+" ");
//			for (int i = 0; i < Height; i++) {
//				for (int j = 0; j < Width; j++) {
//					System.out.print(Map[i][j]);
//				}
//				System.out.println();
//			}
//		}
//	}
//
//}
