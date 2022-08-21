package Binary_search;

import java.util.Scanner;

public class Allocate_Books {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int book[] = new int[n];
		for(int i=0; i<n; i++){
			book[i] = sc.nextInt();
		}
		int no_of_student = sc.nextInt();
		int ans = books(book , no_of_student);
		System.out.println(ans);
	}
	public static int books(int[] A, int B) {
		if(B > A.length)
			return -1;
		int start = Integer.MIN_VALUE;
		int end = 0;
		for(int i=0; i<A.length; i++){
			start = Math.max(A[i] , start);
			end += A[i];
		}
		int ans = -1;

		while(start <= end){
			int mid = (start + end)/2;
			if(checkPages(mid , A , B)){
				ans = mid;
				end = mid - 1;
			}
			else{
				start = mid + 1;
			}
		}
		return ans;
	}

	private static boolean checkPages(int maxpages, int[] A, int students) {
		int sumPages = 0, count = 0;

		for (int i = 0; i < A.length; i++) {
			sumPages += A[i];
			if (sumPages > maxpages) {
				count++;
				sumPages = A[i];
			}
		}
		if (sumPages != 0)
			count++;

		if (count <= students) {
			return true;
		}
		else {
			return false;
		}
	}
}
