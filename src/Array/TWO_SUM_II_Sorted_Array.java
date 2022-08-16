package Array;

import java.util.Scanner;

public class TWO_SUM_II_Sorted_Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();

		int[] ans = twoSum(arr , target);
		for(int i=0; i<2; i++){
			System.out.println(ans[i]);
		}
	}
	public static int[] twoSum(int[] numbers, int target) {
			int ans[] = new int[2];
				int e = numbers.length-1;
				for(int i=0; i<numbers.length; i++){
					if(numbers[i]+numbers[e] == target){
						ans[0] = numbers[i];
						ans[1] = numbers[e];
						break;
					}
					if(numbers[i]+numbers[e]>target){
						e--;
						i--;
			}
		}
		return ans;
	}
}
