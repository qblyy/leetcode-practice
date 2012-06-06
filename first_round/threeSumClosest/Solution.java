package threeSumClosest;

import java.util.*;

public class Solution {
	public int threeSumClosest(int[] num, int target) {
		Arrays.sort(num);
		int result = 0;
		int sum = 0;
		int difference = Integer.MAX_VALUE;
		for (int i = 0; i < num.length - 2; i++) {
			int j = i + 1, k = num.length - 1;
			while (j < k) {

				sum = num[i] + num[j] + num[k];
				int d = Math.abs(target - sum);
				if (d == 0) {
					return target;
				} else if (d < difference) {
					difference = d;
					result = sum;
				}
				if (sum > target) {
					k--;
				} else {
					j++;
				}
			}

		}
		return result;
	}
}
