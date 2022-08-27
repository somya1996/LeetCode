package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Distinct_Numbers_in_Window {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}
		int B = sc.nextInt();
		int[] res = dNums(A , B);
		for(int i=0; i<res.length; i++)
			System.out.println(res[i]);
	}
	public static int[] dNums(int[] A, int B) {
		ArrayList<Integer> result = new ArrayList<>();
		HashMap<Integer, Integer> hm = new HashMap();
		int count = 0;
		for(int i=0; i<B; i++){
			if(!hm.containsKey(A[i])){
				count++;
				hm.put(A[i], 1);
			}
			else{
				hm.put(A[i], hm.get(A[i])+1);
			}
		}
		result.add(count);
		for(int i=B; i<A.length; i++){
			if(hm.get(A[i-B])>1){
				hm.put(A[i-B], hm.get(A[i-B])-1);
			}
			else{
				hm.remove(A[i-B]);
				count--;
			}
			if(!hm.containsKey(A[i])){
				hm.put(A[i], 1);
				count++;
			}
			else{
				hm.put(A[i], hm.get(A[i])+1);
			}

			result.add(count);
		}
		int arr[] = new int[result.size()];
		for(int i=0; i<result.size(); i++){
			arr[i] = result.get(i);
		}
		return arr;
	}
}
