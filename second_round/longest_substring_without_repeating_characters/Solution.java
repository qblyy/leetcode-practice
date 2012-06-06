package longest_substring_without_repeating_characters;

public class Solution {
	public static int lengthOfLongestSubstring(String s) {
		if (null == s || s.length() == 0)
			return 0;
		if (s.length() == 1)
			return 1;
		boolean[] hasFound = new boolean[256];
		int start = 0, end = 0;
		int LS = 0, LE = 0;
		while (end < s.length()) {
			int endIndex = (int) (s.charAt(end));
			if (hasFound[endIndex]) {
				if (end - start > LE - LS) {
					LE = end;
					LS = start;
				}
				int startIndex = 0;
				while (hasFound[endIndex]) {
					startIndex = (int) (s.charAt(start));
					hasFound[startIndex] = false;
					start++;
				}
				/**
				 * GQ.
				 * Should set hasFound[endIndex] to true.
				 */
				hasFound[endIndex] = true;
			} else {
				hasFound[endIndex] = true;
			}
			end++;
		}
		if (end - start >= LE - LS) {
			return end - start;
		}
		return LE - LS;
	}

	public static void main(String... args) {
		String s =
//		 "abcad"
				"abcabcbb"
//		"aaaaa"
				;
		int result = lengthOfLongestSubstring(s);
		System.out.println("longest length of unique substring is " + result);

	}
}
