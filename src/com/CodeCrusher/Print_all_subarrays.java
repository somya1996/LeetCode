package com.CodeCrusher;

import java.util.Scanner;

public class Print_all_subarrays {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}

		printsubarray(arr,0);
	}
	public static int printsubarray(int[] arr , int x ){
		if(x == arr.length)
			return 0;
		String res = "";
		for(int i=x; i<arr.length ; i++){
			res += " "+arr[i]+" ";
			//System.out.println(arr[x] + "  " + arr[i]);
			System.out.print("["+res+"]");
		}
		return printsubarray(arr , x+1);
	}
}
