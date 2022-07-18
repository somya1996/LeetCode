package Array;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Minimum_Deletions_to_Make_Array_Divisible {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int nums[] = new int[n];
		for(int i=0; i< n; i++){
			nums[i] = sc.nextInt();
		}
		int q = sc.nextInt();
		int numsDivide[] = new int[q];
		for(int i=0; i< q; i++){
			numsDivide[i] = sc.nextInt();
		}

		int ans = minOperations(nums,numsDivide);
		System.out.println(ans);

	}
	public static int minOperations(int[] nums, int[] numsDivide) {
		/*
			LinkedHashMap<Integer , Integer> lhm = new LinkedHashMap<>();
			for(int i=0; i<nums.length; i++){
				if(lhm.containsKey(nums[i]))
					lhm.put(nums[i] , lhm.get(nums[i])+1);
				else
					lhm.put(nums[i] , 1);
			}
			//System.out.println(lhm);
			int deletion = 0 , values = 0;
			for(Map.Entry<Integer,Integer> entry : lhm.entrySet()){
				boolean flag = true;
				int x = entry.getKey();
				//System.out.println(x);
				for(int i=0; i< numsDivide.length; i++) {
					if (numsDivide[i] % x != 0) {
						flag = false;
						break;
					}
				}
				if (flag == false)
					deletion += entry.getValue();
				if(flag == true)
					return deletion;
			}
			//System.out.println(values);

			return -1;
		*/
		int g = numsDivide[0], tmp;
		for (int a : numsDivide) {
			while (a > 0) { // g = gcd(g, a)
				tmp = g % a;
				g = a;
				a = tmp;
			}
		}
		Arrays.sort(nums);
		int count = 0;
		/*for (int i = 0; i < nums.length && nums[i] <= g; i++)
			if (g % nums[i] == 0)
				return i;
				*/

		for(int i=0; i< nums.length&& nums[i]<g; i++){
			count++;
		}
		//return -1;
		if(count == 0)
			return -1;
		return count;
	}
}
