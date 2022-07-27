package Array;

import java.util.HashMap;
import java.util.Scanner;

public class Check_If_Array_Pairs_Are_Divisible_by_k {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		boolean total = canArrange(arr , k);
		System.out.println(total);
	}
	public static boolean canArrange(int[] arr, int k) {
		HashMap<Integer , Integer> hm = new HashMap<Integer, Integer>();
		for(int x : arr){
			int rem = x%k;
			if(rem < 0){
				rem = (rem + k)%k;
			}
			int of = hm.getOrDefault(rem , 0);
			hm.put(rem , of+1);
		}
		System.out.println(hm);
		boolean flag = true;
		for(int x : arr){
			int rem = x % k ;
			if(rem < 0){
				rem = (rem + k)%k;
			}
			// case 0
			if( rem == 0 ){
				int freq = hm.get(rem);
				if(freq % 2 == 1){
					return  false;
				}
			}
			// case 1
			else if( 2 * rem == k){
				int freq = hm.get(rem);
				if(freq % 2 == 1){
					return false;
				}
			}

			//case 2
			else{
				int freq = hm.get(rem);
				int other_freq = hm.getOrDefault(k-rem , 0);
				if(freq != other_freq){
					return false;
				}
			}
		}

		return true;
	}
}
