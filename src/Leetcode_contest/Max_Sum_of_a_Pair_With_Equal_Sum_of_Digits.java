package Leetcode_contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Max_Sum_of_a_Pair_With_Equal_Sum_of_Digits {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int maxsum = maximumSum(arr);
		System.out.println(maxsum);
	}
	public static int maximumSum(int[] nums) {
		int maxsum = -1;
		HashMap<Integer , Integer> hm = new HashMap<Integer,Integer>();
		Arrays.sort(nums);
		for(int i=nums.length-1; i>=0; i--){
			int x = sumOfDigit(nums[i]);
			if(hm.containsKey(x)){
				int sum = hm.get(x) + nums[i];
				if(maxsum < sum){
					maxsum = sum;
				}
			}
			else{
				hm.put(x , nums[i]);
			}
		}
		return maxsum;
	}
	public static int sumOfDigit(int num){
		int sum = 0;
		while(num != 0){
			sum += num%10;
			num = num/10;
		}
		return sum;
	}
}
