package com.CodeCrusher;
/*
->Given an integer array nums and an integer k, return true if nums has a continuous subarray of size
at least two whose elements sum up to a multiple of k, or false otherwise.
->An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a
multiple of k.

Example 1:
Input: nums = [23,2,4,6,7], k = 6
Output: true
Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
Example 2:
Input: nums = [23,2,6,4,7], k = 6
Output: true
Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
Example 3:
Input: nums = [23,2,6,4,7], k = 13
Output: false
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Continuous_Subarray_Sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		String ans = checkSubarraySum(arr,k)?"true":"false";
		System.out.println(ans);
	}
	public static boolean checkSubarraySum(int[] nums, int k) {
		/*HashMap<Integer , Integer> hm = new HashMap<>();
		hm.put(0,-1);
		//HashMap[remainder,index]
		int sum = 0 , rem = 0;
		for(int i=0; i<nums.length; i++){
			sum += nums[i];
			rem = sum%k;
			if(rem == 0 && i>0)
				return true;
			//when map contains mod, it means that there exist an subarray from 0~j ->\
			//(j=map.get(mod)) where its sum%k==mod.
			//which means that subarray sum( j~i) %k==0.
			if(hm.containsKey(rem) && i-hm.get(rem)>1)
				return true;
			if(!hm.containsKey(rem))
				hm.put(rem,i);
		}
		return false;*/


		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			System.out.print(" sum+nums[i] "+sum+" ");
			sum %= k;
			System.out.print("%k "+sum+" ");
			// case 1
			if (sum == 0 && i > 0 ) {
				return true;
			}
			// case 2
			if (map.containsKey(sum) && i - map.get(sum) > 1) {
				return true;
			}
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}

		}
		return false;
	}
}
