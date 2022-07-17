package Leetcode_contest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Maximum_Number_of_Pairs_in_Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int ans[] = numberOfPairs(arr);
		for(int i=0; i<2; i++){
			System.out.print(ans[i] + " ");
		}
	}
	public static int[] numberOfPairs(int[] nums) {
		HashMap<Integer , Integer> hm = new HashMap<Integer,Integer>();
		for(int i=0; i<nums.length; i++){
			if(hm.containsKey(nums[i])){
				hm.put(nums[i] , hm.get(nums[i])+1);
			}
			else{
				hm.put(nums[i] , 1);
			}
		}
		int pair = 0 , remaining = 0;
		for ( Map.Entry<Integer,Integer> entry : hm.entrySet()){
			if(entry.getValue()%2 == 0){
				pair += entry.getValue()/2;
			}
			else if(entry.getValue()%2 == 1){
				pair += entry.getValue()/2;
				remaining += 1;
			}
            /*else{
                remaining += 1;
            }*/
		}
		int arr[] = new int[2];
		arr[0] = pair;
		arr[1] = remaining;
		return arr;
	}
}
