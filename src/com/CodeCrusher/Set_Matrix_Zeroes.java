package com.CodeCrusher;

import java.util.Scanner;

public class Set_Matrix_Zeroes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[][] = new int[n][m];

		//inserting elements
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		/*
		int brr[][] = new int[n][m];

		// TIME COMPLEXITY  :  O(n*m)
		// SPACE COMPLEXITY :  O(n+m)
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++) {
				brr[i][j] = arr[i][j];
			}
		}
		int row = 0 , col = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 0) {
					row = i;
					col = j;
					inserting_zeroes(brr,row,col);
				}
			}
		}
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				System.out.print(brr[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void inserting_zeroes(int[][] brr , int row , int col){
		// for row : col is fixed
		for(int i=0 ; i<brr.length; i++){
			brr[i][col] = 0;
		}
		// for col : row is fixed
		for(int i=0 ; i<brr[0].length; i++){
			brr[row][i] = 0;
		}
	*/
		//TIME COMPLEXITY  = O(n*m)
		//SPACE COMPLEXITY = O(1)
		boolean row = false , col = false;
		// check row and col fixed
		for(int i=0; i<n ; i++){
			if(arr[i][0] == 0)
				col = true;
		}
		for(int i=0; i<m; i++){
			if(arr[0][i] == 0)
				row = true;
		}
		// if any element is zero in this then put that zero in the starting row/col
		for(int i=1; i<n; i++){
			for(int j = 1; j<m; j++){
				if(arr[i][j] == 0){
					arr[0][j] = 0;
					arr[i][0] = 0;
				}
			}
		}

		for(int i=1; i<n; i++){
			if(arr[i][0] == 0){
				for(int j= 0; j<m; j++){
					arr[i][j] = 0;
				}
			}
		}

		for(int j= 1; j<m; j++){
			if(arr[0][j] == 0){
				for(int i=0; i<n; i++){
					arr[i][j] = 0;
				}
			}
		}

		// if in case any element is left
		if(row){
			for(int j=0; j<m;j++)
				arr[0][j] = 0;
		}

		if(col){
			for(int i=0; i<n; i++)
				arr[i][0] = 0;
		}

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}

	}
}
