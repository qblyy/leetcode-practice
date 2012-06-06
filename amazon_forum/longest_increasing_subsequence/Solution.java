package longest_palindrome_substring;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static List<Integer> find_1(int[] A) {
	int len = A.length;
	int[] dp = new int[len];
	int[] trackBack = new int[len];
	dp[0] = 1;
	trackBack[0] = 0;
	int max = 0;
	int maxIndex = 0;
	for (int i = 1; i < len; i++) {
	    dp[i] = 1;
	    trackBack[i] = i;
	    for (int j = 0; j < i; j++) {
		if (A[i] > A[j]) {
		    if (dp[i] < dp[j] + 1) {
			dp[i] = dp[j] + 1;
			trackBack[i] = j;
			if (dp[i] > max) {
			    max = dp[i];
			    maxIndex = i;
			}
		    }
		}
	    }
	}
	
	List<Integer> result = new ArrayList<Integer>();
	int previous = -1;
	while (previous != trackBack[maxIndex]) {
	    result.add(0, maxIndex);
	    previous = maxIndex;
	    maxIndex = trackBack[maxIndex];
	}
	
	return result;
    }
}