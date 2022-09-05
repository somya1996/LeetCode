import java.util.Scanner;

public class Sorting {
	static int inv_count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		inv_count = inversion_count(arr);
		System.out.println(inv_count);

		System.out.println();

		for(int i=0; i<n; i++){
			System.out.print(arr[i]+" ");;
		}
	}
	public static int inversion_count(int[] A) {
		int start = 0 , end = A.length-1;
		//int count = 0;
		merge_sort(A , start , end);
		return inv_count;
	}
	public static void merge_sort(int A[] , int start , int end){
		if(start<end){
			int mid = (start+end)/2;
			merge_sort(A,start , mid);
			merge_sort(A , mid+1 , end);
			merge(A , start , mid , end);
		}
	}
	public static void merge(int A[] , int start , int mid , int end){
		int l1 = mid - start + 1;
		int l2 = end - mid ;

		int L[] = new int[l1];
		int R[] = new int[l2];

		for(int i=0; i<l1; i++){
			L[i] = A[start+i];
		}

		for(int j=0; j<l2; j++){
			R[j] = A[j+mid+1];
		}

		int i=0 , j = 0 , k = start;
		while(i < l1 && j < l2){
			if(L[i] <= R[j]){
				A[k] = L[i];
				i++;
			}
			else{
				A[k] = R[j];
				j++;
				inv_count += l1 - i;
			}
			k++;
		}
		while(i<l1){
			A[k] = L[i];
			i++;
			k++;
		}
		while(j<l2){
			A[k] = R[j];
			j++;
			k++;
		}
	}
}
