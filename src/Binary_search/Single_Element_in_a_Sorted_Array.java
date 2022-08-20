package Binary_search;

import java.util.Scanner;

public class Single_Element_in_a_Sorted_Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int ans = singleNonDuplicate(arr);
		System.out.println(ans);
	}
	public static int singleNonDuplicate(int[] nums) {
		int left = 0, right = nums.length-1;
		while(left < right){
			int mid = (left + right)/2;
			if(mid % 2 == 0 && nums[mid] == nums[mid +1])
					return nums[mid];
			if(mid %2 == 1 && nums[mid] == nums[mid - 1])
				left = mid + 1;
			else
				right = mid;
		}
		return nums[left];
	}
}
