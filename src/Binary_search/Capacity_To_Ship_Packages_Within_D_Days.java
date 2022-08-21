package Binary_search;

import java.util.Scanner;

public class Capacity_To_Ship_Packages_Within_D_Days {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int weights[] = new int[n];
		for(int i=0; i<weights.length; i++){
			weights[i] = sc.nextInt();
		}

		int days = sc.nextInt();
		int ans = shipWithinDays(weights , days);
		System.out.println(ans);
	}
	public static int shipWithinDays(int[] weights, int days) {
		int start = Integer.MIN_VALUE , end = 0;

		for(int i=0; i<weights.length; i++){
			start = Math.max(start , weights[i]);
			end += weights[i];
		}
		int ans = -1;
		while(start <= end){
			int mid = start+(end-start)/2;
			if(check_Weight(mid , weights , days)){
				ans = mid;
				end = mid -1; // is any lesser value exists
			}
			else{
				start = mid + 1;
			}
		}
		return ans;
	}
	public static boolean check_Weight(int mid , int[] weights , int days){
		int total_sum = 0 , d = 0;
		for(int i=0; i<weights.length; i++){
			total_sum += weights[i];
			if(total_sum > mid){
				d++;
				total_sum = weights[i];
			}
		}
		if(total_sum != 0)
			d++;

		if(d <= days)
			return true;
		return false;
	}
}
