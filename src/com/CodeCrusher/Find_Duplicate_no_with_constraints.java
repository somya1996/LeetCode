package com.CodeCrusher;

import java.util.Scanner;

/*
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n]
inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and uses only constant extra space.
Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
*/
public class Find_Duplicate_no_with_constraints {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int nums[] = new int[n];
		for(int i=0; i<n; i++){
			nums[i] = sc.nextInt();
		}
	    int duplicate = findDuplicate(nums);
		System.out.println(duplicate);

	}
	public static int findDuplicate(int[] nums) {
		/*
		// initializing index value
		for(int i=0; i<nums.length; i++){
			int idx = Math.abs(nums[i]);
			if(nums[idx]<0)
				return idx;

			nums[idx] = -nums[idx];
		}
		return nums.length;

		*/
		// FLOYD CYCLE DETECTION  or SLOW FAAST POINTER
		int slow = nums[0];
		int fast = nums[0];
		System.out.println(" Part 1 ");
		do{
			slow = nums[slow];
			fast = nums[nums[fast]];
			System.out.println("Slow "+slow+" fast "+fast);
		}while(slow!=fast);

		slow = nums[0];
		System.out.println(" Part 2 ");
		while(slow != fast){
			slow = nums[slow];
			fast = nums[fast];
			System.out.println("Slow "+slow+" fast "+fast);
		}
		return fast;
	}
}
