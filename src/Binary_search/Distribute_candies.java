package Binary_search;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Distribute_candies {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] candy = new int[n];
		for(int i=0; i<n; i++){
			candy[i] = sc.nextInt();
		}
		// no of candies she can eat
		int no_of_candies = distributeCandies(candy);
		System.out.println(no_of_candies);
	}
	/*
	// Brute force - O(n^2)
	public int distributeCandies(int[] candyType) {
        // Initiate a variable to count how many unique candies are in the array.
        int uniqueCandies = 0;
        // For each candy, we're going to check whether or not we've already
        // seen a candy identical to it.
        for (int i = 0; i < candyType.length; i++) {
            // Start by assuming that the candy IS unique.
            boolean isUnique = true;
            // Check each candy BEFORE this candy.
            for (int j = 0; j < i; j++) {
                // If this candy is the same as a previous one, it isn't unique.
                if (candyType[i] == candyType[j]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueCandies++;
            }
        }
        // The answer is the minimum out of the number of unique candies, and
        // half the length of the candyType array.
        return Math.min(uniqueCandies, candyType.length / 2);
    }
	*/
	// Using sorting technique O(nlog(n))
	/*
	 public int distributeCandies(int[] candyType) {
        // We start by sorting candyType.
        Arrays.sort(candyType);
        // The first candy is always unique.
        int uniqueCandies = 1;
        // For each candy, starting from the second candy...
        for (int i = 1; i < candyType.length && uniqueCandies < candyType.length / 2; i++) {
            // This candy is unique if it is different to the one
            // immediately before it.
            if (candyType[i] != candyType[i - 1]) {
                uniqueCandies++;
            }
        }
        // Like before, the answer is the minimum out of the number of unique
        // candies, and half the length of the candyType array.
        return Math.min(uniqueCandies, candyType.length / 2);
    }
	*/
	//TC - O(n) SC - O(n)
	public static int distributeCandies(int[] candyType) {
		Set<Integer> uniqueCandie = new HashSet<Integer>();
		for(int candy: candyType){
			uniqueCandie.add(candy);
		}
		return Math.min(uniqueCandie.size() , candyType.length/2);
	}
}

