package Bit_Manipulation;

import java.util.Scanner;

public class Reverse_unsigned_String {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(reverseBits(n));
	}
	public static int reverseBits(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result += n & 1;
			n = n >>> 1;
			if (i < 31)
				result <<= 1;
		}
		return result;
	}
}
