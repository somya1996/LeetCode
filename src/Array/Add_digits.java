package Array;

import java.util.Scanner;

public class Add_digits {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(addDigits(n));
	}
	public static int addDigits(int num) {
		// Naive Approach
		/*
		int sum = 0;
		while(num != 0){
			sum += num%10;
			num = num/10;
		}
		if(sum > 9)
			return addDigits(sum);
		return sum;

	    */
		// Mathematical Approach
		if(num == 0)
			return 0;
		if(num % 9 == 0)
			return 9;
		return num % 9;
	}
}
