package Leetcode_contest;

import java.util.Arrays;
import java.util.Scanner;

public class Minimum_Lines_to_Represent_a_Line_Chart {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int mat[][] = new int[n][2];
		for(int i=0; i<n; i++){
			for(int j=0; j<2; j++){
				mat[i][j] = sc.nextInt();
			}
		}

		int ans = minimumLines(mat);
		System.out.println(ans);
	}
	public static int minimumLines(int[][] stockPrices) {
		if(stockPrices.length <=1)
			return 0;
		Arrays.sort(stockPrices , (a,b)->Integer.compare(a[0],b[0]));
		int count = 1;
		for(int i = 2; i<stockPrices.length; i++){
			if((stockPrices[i][1] - stockPrices[i - 1][1]) * (stockPrices[i - 1][0] - stockPrices[i - 2][0]) ==
			   (stockPrices[i - 1][1] - stockPrices[i - 2][1]) * (stockPrices[i][0] - stockPrices[i - 1][0])) {
				continue;
			}
			count++;
		}
		return count;
	}
}
