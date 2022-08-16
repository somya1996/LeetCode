package Array;

import java.util.Scanner;

public class TWO_SUM_II_Sorted_Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();

		int[] ans = twoSum(arr , target);
		for(int i=0; i<2; i++){
			System.out.println(ans[i]);
		}
	}
	public static int[] twoSum(int[] numbers, int target) {
			int ans[] = new int[2];
				int e = numbers.length-1;
				for(int i=0; i<numbers.length; i++){
					if(numbers[i]+numbers[e] == target){
						ans[0] = numbers[i];
						ans[1] = numbers[e];
						break;
					}
					if(numbers[i]+numbers[e]>target){
						e--;
						i--;
			}
		}
		return ans;
		/*
        int ans[] = new int[2];
        HashMap<Integer , Integer> hm = new HashMap<Integer , Integer>();
        for(int i=0; i<numbers.length; i++){
            if(hm.containsKey(target - numbers[i])){
                ans[1] = i+1;
                ans[0] = hm.get(target - numbers[i]);
                break;
            }
            else
                hm.put(numbers[i] , i+1);
        }
        return ans;
        */
        /*
		int len = numbers.length;
		int L = 0, R = len - 1, sum;

		while(L < R) {
			sum = numbers[L] + numbers[R];

			if(sum == target) return new int[]{L + 1, R + 1};
			else if(sum < target) L++;
			else R--;
		}

		return new int[]{0, 0};

         */
	}
}
