package Array;

import java.util.HashMap;
import java.util.Scanner;

public class Longest_substring_without_repeating_characters {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int ans = lengthOfLongestSubstring(s);
		System.out.println(ans);
	}
	public static int lengthOfLongestSubstring(String s) {
		if (s.length() == 0 || s.length() == 1)
			return s.length();
		HashMap<Character, Integer> hm = new HashMap<>();
		int start = 0, end = 0, ans = 0;
		while (end < s.length()) {
			char c = s.charAt(end);
			if (hm.containsKey(c) && start <= hm.get(c)) {
				start = hm.get(c) + 1;
			}
			ans = Math.max(ans, end - start + 1);
			hm.put(c, end);
			end++;
		}
		return ans;
	}
}
