package com.Back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back_3107 {

	static String [] answer = {"0000","0000","0000","0000","0000","0000","0000","0000"};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		String ip = br.readLine();
		
		String[] splits = ip.split("::");
		
		//::가 
		if(splits.length==1) {
			String[] split = splits[0].split(":");
			for (int i = 0; i < split.length; i++) {
				if(split[i].length()==4) {
					answer[i]=split[i];
				}else {
					sb = new StringBuilder();
					for (int j = 0; j < 4-split[i].length(); j++) {
						sb.append(0);
					}
					sb.append(split[i]);
					answer[i]=sb.toString();
				}
			}
		}else {
			String[] split1;
			String[] split2;
			// 앞부분 처리
			if(!splits[0].equals("")) {				
				split1 = splits[0].split(":");
				for (int i = 0; i < split1.length; i++) {
					if(split1[i].length()==4) {
						answer[i]=split1[i];
					}else {
						sb = new StringBuilder();
						for (int j = 0; j < 4-split1[i].length(); j++) {
							sb.append(0);
						}
						sb.append(split1[i]);
						answer[i]=sb.toString();
					}
				}
			}
			// 뒷부분 처리
			if(!splits[1].equals("")) {
				split2 = splits[1].split(":");
				for (int i = 0; i < split2.length; i++) {
					if(split2[i].length()==4) {
						answer[8-split2.length+i]=split2[i];
					}else {
						sb = new StringBuilder();
						for (int j = 0; j < 4-split2[i].length(); j++) {
							sb.append(0);
						}
						sb.append(split2[i]);
						answer[8-split2.length+i]=sb.toString();
					}
				}
			}
			
			
		}
		
		sb = new StringBuilder();
		for (int i = 0; i < 7; i++) {
			sb.append(answer[i]+":");
		}
		sb.append(answer[7]);
		System.out.println(sb);
	}
}
