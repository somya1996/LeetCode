package Bit_Manipulation;

import java.util.Scanner;

public class Count_set_bit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(solve(n));
	}
	public static int solve(int A) {
    /*
        // one way
        long ans = 0;
        for(int i=1; i <= A; i++){
            long count = countBit(i);
            ans += count;
        }
        return (int)ans;
    */
		if(A == 0)
			return 0;
		int x = last_Bit_power_2(A);
		int total_bit = x * ( 1 << (x-1) );
		int remaining = A - ( 1 << x ) + 1;
		int res = A - (1 << x);

		int count = total_bit + remaining + solve(res);
		return count;

	}
	public static int last_Bit_power_2(int A){
		int i = 0;
		while((1 << i) <= A ){
			i++;
		}
		return i-1;
	}
    /*
    public static long countBit(int i){

        long count = 0;
        while(i != 0){
            count += (i & 1);
            i = i>>1;
        }
        return count;
    }
    */
}
