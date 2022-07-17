package Array;

import java.util.Scanner;
import java.util.HashSet;

public class HappyNo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(beautifulNumber(num));
	}
	public static boolean beautifulNumber(int n) {
		HashSet<Integer> s = new HashSet<Integer>();
		while(n != 1){
			int curr = sumofdigit(n);
			if(s.contains(curr))
				return false;
			s.add(curr);
			n = curr;
		}
		return true;
	}
	public static int sumofdigit(int num){
		int sum = 0;
		while(num != 0){
			sum += (num%10) * (num%10);
			num = num/10;
		}
		return sum;
	}
}
