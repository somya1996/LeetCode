package com.CodeCrusher;

import java.util.Scanner;

public class RangeSum_2D {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr.length;j++){
				arr[i][j] = sc.nextInt();
			}
		}

		// prefix sum
		for(int c=1; c<n; c++){
			arr[0][c] = arr[0][c-1] + arr[0][c];
		}

		for(int r=1; r<n; r++){
			arr[r][0] = arr[r-1][0] + arr[r][0];
		}

		for(int r=1; r<n; r++){
			for(int c=1; c<n; c++){
				arr[r][c] = arr[r][c-1] + arr[r-1][c] - arr[r-1][c-1] + arr[r][c];
			}
		}

		for(int i=0; i<arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
