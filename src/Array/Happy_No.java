package Array;

import java.util.HashSet;
import java.util.Scanner;

public class Happy_No {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(isHappy(n))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	public static boolean isHappy(int n) {
		HashSet<Integer> hs = new HashSet<>();
		int sum = 0 ;
		while(n > 0){
			int x = n%10;
			sum += x*x;
			n = n/10;
			if(n == 0 && sum != 1){
				if(hs.contains(sum)){
					return false;
				}
				else{
					hs.add(sum);
					n = sum;
					sum = 0;
				}
			}
		}
		return true;
	}
}
