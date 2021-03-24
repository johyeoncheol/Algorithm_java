package com.Back;

import java.util.Scanner;

public class Back_1244 {
	static String input="27\r\n" + 
			"0 1 0 1 0 0 0 1 0 1 1 1 1 0 1 1 1 1 0 0 0 0 0 0 1 0 1\r\n" + 
			"3\r\n" + 
			"1 3\r\n" + 
			"2 3\r\n"+
			"1 2";
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		int Switch = sc.nextInt();
		int [] IntArray=new int[Switch];
		for(int i = 0 ; i < Switch;i++) {
			IntArray[i]=sc.nextInt();
		}
		int TestCase = sc.nextInt();
		for(int i = 0 ; i < TestCase;i++) {
			int Gen = sc.nextInt();
			int num = sc.nextInt();
			int temp =num;
			if(Gen ==1) {
				while(temp<=Switch) {
					IntArray[temp-1] = IntArray[temp-1]==0?1:0;
					temp+=num;
				}
			}else {
				for(int k = 0 ; k < Switch;k++) {
					if(num-2-k<0||num+k>=Switch||(IntArray[num-2-k]!=IntArray[num+k])) {
						IntArray[num-1] = IntArray[num-1]==0?1:0;
						break;
					}else if(IntArray[num-2-k]==1){
						IntArray[num-2-k]=0;
						IntArray[num+k]=0;
					}else if(IntArray[num-2-k]==0){
						IntArray[num-2-k]=1;
						IntArray[num+k]=1;
					}
				}
			}
		}
		
		for(int i = 0 ; i <Switch;i++) {
			if(i%20==0&&i!=0) {
				System.out.println();
			}
			System.out.print(IntArray[i]+" ");
		}
	}

}
