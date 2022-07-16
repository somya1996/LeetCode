package com.CodeCrusher;

import java.util.Scanner;

public class Percent_of_strin_character {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		char letter = sc.next().charAt(0);;
		int ans = percentageLetter(s , letter);
		System.out.println(ans);
	}
	public static int percentageLetter(String s, char letter){
		int count = 0;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == letter)
				count++;
		}
		System.out.println((int)Math.floor((double)count/s.length()*100));
		return count;
	}
}
