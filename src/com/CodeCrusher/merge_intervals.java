package com.CodeCrusher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class merge_intervals {
	/*
	NOTE: Three cases
			1>  1 3  (s1 , e1)
				2 6  (s2 , e2)
				if(e1 > s2)   Partial OVERLAPPING                  MAX(e1 , e2)
			2>  1 6  (s1 , e1)
			    2 3  (s2 , e2)
			    if(e1 > s2	&& e1 > e2) FULLY OVERLAPPING          MAX(e1 , e2)
			3>  7 8
			    9 15
			    Here no OVERLAPPING
	*/
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int mat[][] = new int[s][2];
		for(int i=0; i< mat.length; i++){
			for(int j=0; j<2; j++){
				mat[i][j] = sc.nextInt();
			}
		}
		int[][] ans = merge(mat);
		for(int i=0; i<ans.length; i++){
			for(int j=0; j<2; j++){
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));

		ArrayList<int[]> result = new ArrayList<>();

		for(int[] interval : intervals){
			if(result.isEmpty()){
				result.add(interval);
			}
			else{
				int prev_Interval[] = result.get(result.size()-1);
				if( prev_Interval[1] >= interval[0]){
					prev_Interval[1] = Math.max(prev_Interval[1] , interval[1]);
				}
				else{
					result.add(interval);
				}
			}
		}
		return result.toArray(new int[result.size()][]);
	}
}
