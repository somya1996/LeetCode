package Bit_Manipulation;

import java.util.Scanner;

public class HammingDistance_Number_of_bits_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = hammingWeight(n);
		System.out.println(ans);
	}
	public static int hammingWeight(int n) {
    /*
        int count = 0;
        while(n!=0){
            n = (n & (n-1));
            count += 1;
        }
        return count;
    */
		int ones = 0;
		while(n!=0) {
			ones = ones + (n & 1);
			n = n>>>1; // here we are not using >> beacuse it is signed bit so it gives ans in signed bit
		}
		return ones;
	}
}
