package lengthOfLongestSubstring;

import java.util.*;

import java.util.*;

public class Solution {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int i = 0, k = -1;
		int len = s.length();
		int runningLen = 1;
		boolean hasDup = false;
		while (i < len) {
			hasDup = false;
			for (int j = k + 1; j < i; j++) {
				if (s.charAt(j) == s.charAt(i)) {
					hasDup = true;
					if (i - k - 1 > runningLen) {
						runningLen = i - k - 1;
					}
					k = j;
					break;
				}
			}
			if (hasDup) {
				continue;
			} else {
				i++;
			}
		}
		
		/**
		 * Good Question.
		 */
		if (i - k - 1 > runningLen) {
			runningLen = i - k - 1;
		}
		return runningLen;
	}
}