package com.CodeCrusher;

import java.util.Scanner;

public class Best_Time_to_Buy_and_Sell_Stock_II {
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
		int buy = prices[0];
		int profit = 0;
		for(int i= 1; i<prices.length; i++){
			int sell = prices[i];
			if(buy < sell ){
				profit += sell - buy;
			}
			buy = sell;
		}
		return profit;
	}
}
