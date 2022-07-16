package Recursion;

import java.util.Scanner;

public class Next_Permutation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		Next_Permutation x = new Next_Permutation();
		x.nextPermutation(arr);
		for(int i=0 ; i< n ; i++){
			System.out.print(arr[i]+" ");
		}
	}
	public void nextPermutation(int[] nums) {
		int n = nums.length;
		int i ;
		for(i = n-2; i>=0; i--){
			if(nums[i] < nums[i+1])
				break;
		}
		if(i < 0){
			reverse(0 , n-1 , nums);
		}
		for(int j = n-1; j > i ; j-- ){
			swap(i , j , nums);
		}
		reverse(i+1 , n-1 , nums);
	}
	public static void reverse(int s , int e , int[] nums){
		while(s<e){
			swap(s , e , nums);
			s++;
			e--;
		}
		return;
	}
	public static void swap(int x , int y , int[] nums){
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
		return;
	}
}
