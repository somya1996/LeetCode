package Bit_Manipulation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No_duplicatesubset {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		System.out.println(subsetsWithDup(arr));
	}
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		subsequence(0 , nums , ans , new ArrayList<Integer>());
		return ans;
	}
	public static void subsequence(int idx , int[]nums , List<List<Integer>> ans , ArrayList<Integer> ds){
		ans.add(new ArrayList<>(ds));
		for(int i=idx ; i<nums.length ; i++){
			if(i != idx && nums[i] == nums[i-1])
				continue;
			ds.add(nums[i]);
			subsequence(i+1 , nums , ans , ds);

			ds.remove(ds.size()-1);
		}
	}
}
