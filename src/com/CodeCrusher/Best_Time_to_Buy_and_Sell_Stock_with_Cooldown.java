package com.CodeCrusher;

import java.util.ArrayList;
import java.util.Scanner;

public class Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {
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
		if(prices.length <= 1)
			return 0;
		int buy = prices[0];
		int profit = 0;
		int max_profit = 0;
		for(int i=1; i<prices.length-1; i++){
			if(prices[i] > prices[i-1]){
				profit += prices[i] - buy;
				//if(max_profit<profit)
				//	max_profit += profit;
				i++;
			}
			buy = prices[i];
		}
		return profit;
	}
}
