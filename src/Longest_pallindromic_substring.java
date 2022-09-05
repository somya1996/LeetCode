import java.util.Scanner;

public class Longest_pallindromic_substring {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String lp = longestPalinSubstring(s);
		System.out.println(lp);
	}
	public static String longestPalinSubstring(String str)
	{
		String res = "";
		String ans = "";
		for(int i=0; i<str.length(); i++) {
			String odd = expand(str, i, i);
			if (odd.length() > res.length()) {
				res = odd;
			}
		}
		for(int i=0; i<str.length(); i++){
			String even = expand(str , i , i+1);
			if(even.length() > res.length())
				res = even;
		}

		return res;
	}
	public static String expand(String str , int s , int e){
		while(s>=0 && e<=str.length()-1 && str.charAt(s) == str.charAt(e)){
			s--;
			e++;
		}
		return str.substring(s+1,e);
	}

}
