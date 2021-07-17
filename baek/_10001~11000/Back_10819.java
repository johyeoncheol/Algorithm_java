package com.back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back_10819 {
	static int n ;
    static int[] arr,temp;
    static int result;
    static boolean[] visited;
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        n =  Integer.parseInt(br.readLine());
        arr =new int[n];
        visited =new boolean[n];
        temp =new int[n]; // 각순열 케이스를 담아줄 임시 저장소
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n ; i++) {
            arr[i] =Integer.parseInt(st.nextToken());
        }
 
        Arrays.sort(arr);
        
        perm(0);
        System.out.println(result);
    }
    private static void perm(int count){
        if(count == n){
            int sum =0;
            for (int i = 0; i <n-1 ; i++) {
                sum += Math.abs(temp[i] - temp[i+1]);
            }
            result = Math.max(result,sum);
            return;
        }
 
        for (int i = 0; i <n ; i++) { // 각순열 케이스생성
            if(visited[i]){
                continue;
            }
            visited[i] =true;
            temp[count] = arr[i];// 담는다.
            perm(count+1);// 재귀로 그 다음 index 늘려간다.
            visited[i] =false;// 다 만들고 false로 해제
        }
    }
}