package Array;

import java.util.Scanner;

public class Jump_Game_II {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int ans = jump(arr);
		System.out.println(ans);
	}
	public static int jump(int[] nums) {
		int jumps = 0, curEnd = 0, Far = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			Far = Math.max(Far, i + nums[i]);
			if (i == curEnd) {
				jumps++;
				curEnd = Far;
			}
		}
		return jumps;
	}
}
