package com.CodeCrusher;

import java.util.Arrays;
import java.util.Scanner;

public class Range_addition {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int update[][] = new int[3][3];
		for(int i=0; i<3; i++){
			for(int j=0;j<3; j++)
				update[i][j] = sc.nextInt();
		}
		int ans[] = getModifiedArray(length,update);
		for(int i=0; i< ans.length; i++){
			System.out.print(ans[i]+" ");
		}
	}
	public static int[] getModifiedArray(int length, int[][] updates) {
		int ans[] = new int[length];
		Arrays.fill(ans,0);
		for(int r=0; r< updates.length; r++){
			int c1 = updates[r][0];
			int c2 = updates[r][1];
			int val = updates[r][2];
			for(int c = c1; c<=c2; c++){
				ans[c] = ans[c]+val;
			}
		}
		return ans;
	}
}
