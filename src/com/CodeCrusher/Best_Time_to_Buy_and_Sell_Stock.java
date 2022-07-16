package com.CodeCrusher;

import java.util.Scanner;
// At least one transaction
public class Best_Time_to_Buy_and_Sell_Stock {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int prices[] = new int[n];
		for(int i=0; i<n; i++){
			prices[i] = sc.nextInt();
		}
		int profit = maxProfit(prices);
		System.out.println(profit);

	}
	public static int maxProfit(int[] prices) {
		int profit = 0;
		int n = prices.length;
		int buy = prices[0];
		for(int i = 0; i<n; i++){
			buy = Math.min(buy , prices[i]);
			//System.out.println(buy);
			profit = Math.max(profit , prices[i]-buy);
		}
		return profit;
	}
}
