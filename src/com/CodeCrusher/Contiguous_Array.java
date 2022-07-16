package com.CodeCrusher;

import java.util.HashMap;
import java.util.Scanner;
// find total subarray where we get equal no of 0,s and 1,s

public class Contiguous_Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		//int arr[] = {1,0,0,1,0,1,1};
		//System.out.println("entering");
		int ans = findMaxlength(arr);
		//System.out.println("exit6");
		System.out.println(ans);
	}
	/*
	// Brute force counting equal no of zeroes and ones in each subarray
	public int findMaxLength(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int zeros = 0, ones = 0;
			for (int j = i; j < nums.length; j++) {
				if (nums[j] == 0) {
					zeros++;
				} else {
					ones++;
				}
				if (zeros == ones) {
					count = Math.max(count, j - i + 1);
				}
			}
		}
		return count;
	}*/
	private static int findMaxlength(int[] nums) {
		int count = 0 ;
		int maxlen = 0;
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		hm.put(0,-1);
		for(int i=0; i<nums.length; i++){
			count += nums[i]==1?1:-1;
			if(hm.containsKey(count)){
				maxlen = Math.max(maxlen,i-hm.get(count));
			}
			else
				hm.put(count,i);
		}
		return maxlen;
	}

}
