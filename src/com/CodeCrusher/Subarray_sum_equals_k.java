package com.CodeCrusher;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Subarray_sum_equals_k {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		int count = subarraysum(arr,k);
		System.out.println(count);
	}

	public static int subarraysum(int[] nums,int k) {
		// this way its not valid
		/*int count = 0;
		int left = 0 , right = 0 , sum = 0;
		while(right<nums.length){
			sum += nums[right];
			if(sum == k || nums[right]==k)
				count++;
			if(sum >= k){
				while(sum >= k) {
					sum -= nums[left];
					left++;
				}
			}
			right++;
		}*/
		int sum = 0, result = 0;
		Map<Integer, Integer> preSum = new HashMap<>();
		preSum.put(0, 1);

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (preSum.containsKey(sum - k)) {
				result += preSum.get(sum - k);
			}
			preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
		}

		return result;
	}

}
