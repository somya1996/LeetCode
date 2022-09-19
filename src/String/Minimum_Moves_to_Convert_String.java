package String;

import java.util.Scanner;

public class Minimum_Moves_to_Convert_String {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int count = minimumMoves(s);
		System.out.println(count);
	}
	public static int minimumMoves(String s) {
		int i=0;
		int step=0;
		while(i<s.length()){
			if(s.charAt(i)=='X'){
				i=i+3;
				step++;
			}
			else{
				i++;
			}
		}
		return step;
	}
}
