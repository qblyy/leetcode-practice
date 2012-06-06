package minDistance;

public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        } 
        
        final int len1 = word1.length();
        final int len2 = word2.length();
        if (len1 == 0 || len2 == 0) {
            return Math.max(len1, len2);
        }
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int d1 = dp[i-1][j] + 1;
                int d2 = dp[i][j-1] + 1;
                int d3 = dp[i-1][j-1] + 
                ((word1.charAt(i - 1) == word2.charAt(j - 1)) ? 0 : 1);
                int min = Math.min(d1, d2);
                dp[i][j] = Math.min(min, d3);
            }
        }
        return dp[len1][len2];
//        return 0;
        
    }
    
    public static void main(String[] args) {
		String word1 = "polynomial";
		String word2 = "exponential";
		Solution test = new Solution();
		int result = test.minDistance(word1, word2);
		System.out.println(result);
	}
}
