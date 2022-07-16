package com.CodeCrusher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Best_Time_to_Buy_and_Sell_Stock_III {
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
		ArrayList<Integer> al = new ArrayList<>();
		int buy = prices[0];
		int profit = 0;
		int max_so_far = 0;
		int sell = 0;
		for(int i= 1; i<prices.length; i++){
			if(prices[i]>prices[i-1]) {
				sell = prices[i];
				profit = sell - buy;
				if (profit > max_so_far)
					al.add(profit);
			}
			buy = sell;
		}
		int ans = 0;
		int i = al.size()-1;
		int j = 0;
		if(al.size() == 0)
			return 0;
		if(al.size()==1)
			return al.get(i);
		while(j<2){
			ans += al.get(i);
			i--;
			j++;
		}
		return ans;
	}
}
