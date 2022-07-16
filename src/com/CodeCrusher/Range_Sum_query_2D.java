package com.CodeCrusher;

import java.util.Arrays;
import java.util.Scanner;

public class Range_Sum_query_2D {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		int row1 = sc.nextInt();
		int col1 = sc.nextInt();
		int row2 = sc.nextInt();
		int col2 = sc.nextInt();

		int dp[][] = new int[arr.length+1][arr[0].length+1];
		for (int x[]:dp) {
			Arrays.fill(x,0);
		}

		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr[0].length; c++) {
				dp[r][c + 1] = dp[r][c] + arr[r][c];
			}
		}
		// to print dp[][]
		for(int i=0; i<=n; i++) {
			for (int j = 0; j <= n; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		int sum = 0;
		for (int row = row1; row <= row2; row++) {
			sum += dp[row][col2 + 1] - dp[row][col1];
		}
		System.out.println(sum);
	}
}
