package jump;

public class Solution {
	// DP version 1
	public int jump(int[] A) {
		int[] dp = new int[A.length];
		for (int i = 1; i < A.length; i++) {
			dp[i] = i;
			for (int j = 0; j < i; j++) {
				if (j + A[j] >= i) {
					dp[i] = Math.min(dp[i], dp[j] + 1);
				}
			}
		}
		return dp[dp.length - 1];
	}

	// DP version 2
	public int jump2(int[] A) {
		if (A == null || A.length == 0 || A.length == 1) {
			return 0;
		}
		int[] dp = new int[A.length];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = -1;
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			if (dp[i] >= 0) {
				for (int j = i + 1; j <= i + A[i] && j < A.length; j++) {
					if (1 + dp[i] < dp[j] || -1 == dp[j]) {
						dp[j] = dp[i] + 1;
						if (min > dp[j] && j == A.length - 1) {
							min = dp[j];
						}
					}
				}
			}
		}
		if (min == Integer.MAX_VALUE) {
			return -1;
		}
		return min;
	}
	
	// greedy version
	// O(n)
	public int jump3(int[] A) {
		int startPos = 0;
		int max = 0;
		int newMax = 0;
		int jumpCount = 0;
		while (max < A.length - 1) {
			jumpCount++;
			for (int i = startPos; i <= max; i++) {
				newMax = Math.max(newMax, A[i] + i);
			}
			startPos = max + 1;
			if (newMax <= max) {
				return -1;
			}
			max = newMax;
		}
		return jumpCount;
	}
	
	public static void main(String[] args) {
		Solution test = new Solution();
		int[] A = {0, 0};
		int result = test.jump2(A);
		System.out.println(result);
	}
}