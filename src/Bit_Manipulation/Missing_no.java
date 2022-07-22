package Bit_Manipulation;

import java.util.Scanner;

public class Missing_no {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int ans = missingNumber(arr);
			System.out.println(ans);
	}
	public static int missingNumber ( int[] nums){
        /*//(Approach 1)
        int sum1=0 , sum2 = 0;
        for(int i=0; i<nums.length; i++){
            sum1 += nums[i];
        }
        for(int i=1; i<=nums.length; i++){
            sum2 += i;
        }
        return sum2-sum1;*/

		//(Xor approach)
		int xor = 0, i = 0;
		for (i = 0; i < nums.length; i++) {
			xor = xor ^ i ^ nums[i];
		}
		//System.out.println(xor);
		// incremented value of i as i is starting from 0
		return xor ^ i;
	}


}
