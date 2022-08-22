package Bit_Manipulation;

import java.util.ArrayList;
import java.util.Scanner;

public class City_of_Happy_People {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();

		for(int i=0; i<n; i++){
			arr.add(sc.nextInt());
		}
		int a = sc.nextInt();
		int b = sc.nextInt();

		int count = makeHappyGroup(arr , n , a , b);
		System.out.println(count);
	}
	public static int makeHappyGroup(ArrayList<Integer> happiness, int n, int a, int b)  {
		// Brute force TC = O(2^n)
		int ways = 0;
		int pow = 1<<n;
		for(int i=0; i<pow; i++){
			int sum = 0;
			for(int j=0; j<happiness.size(); j++){
				if((i&(1<<j))!=0){
					sum += happiness.get(j);
				}
			}
			//System.out.println(" i "+i+" sum "+sum);
			if(sum >= a && sum <= b)
				ways++;
		}
		return ways;
	}
}
