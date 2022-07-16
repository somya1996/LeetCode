package com.CodeCrusher;

import java.util.Scanner;

public class Sum_of_all_subarrays {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}

		int sum = 0;
		for(int i=0; i<n; i++){
			sum += arr[i]*(n-i)*(i+1);
		}

		System.out.println(sum);
	}
}
