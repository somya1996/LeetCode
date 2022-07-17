package Leetcode_contest;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Query_Kth_Smallest_Trimmed_Number {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String nums[] = new String[n];
		sc.nextLine();
		for(int i=0; i<n; i++){
			nums[i] = sc.nextLine();
		}
		//int q = sc.nextInt();
		int[][] query = {{1,1} , {2,3} , {4,2} , {1 , 2}};
		int [] ans = smallestTrimmedNumbers(nums , query);
		for(int i=0; i<ans.length; i++){
			System.out.print(ans[i]+" ");
		}
	}
	static class Node {
		int idx;
		String val;
		Node(int i , String  val){
			this.idx = i;
			this.val = val;
		}
	}
	public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
		int result[] = new int[queries.length];
		int index = 0 , len = nums[0].length();
		HashMap<Integer , Node[]> hm = new HashMap<>();
		for(int query[] : queries){
			if(!hm.containsKey(query[1])) {
				Node[] arr = new Node[nums.length];
				for (int i = 0; i < nums.length; i++) {
					String trim = nums[i].substring((len - query[1]) , len);
					arr[i]  = new Node(i , trim);
				}
				Arrays.sort(arr , (a,b)->(a.val.compareTo(b.val)));
				hm.put(query[1] , arr);
			}
			result[index++] = hm.get(query[1])[query[0]-1].idx;
		}
		return result;
	}
}
