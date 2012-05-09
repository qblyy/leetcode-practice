package largestRectangleArea;

import java.util.LinkedList;

public class Solution {
	/**
    public static int largestRectangleArea(int[] height) {
    	if (height == null || height.length == 0) {
            return 0;
        }
//        if (height.length == 1) {
//            return height[0];
//        }
        int low = 0, high = height.length - 1;
        int area = Integer.MIN_VALUE;
        while (low <= high) {
            area = Math.max((high - low + 1) *
                    Math.min(height[high], height[low]), area);
            int left = low, right = high;
            if (height[low] < height[high]) {
                while (left < high && height[left] <= height[low]) {
                    left++;
                }
                low = left;
            } else if (height[low] > height[high]) {
                while (right > low && height[high] >= height[right]) {
                    right--;
                }
                high = right;
            } else {
                low++;
                high--;
            }
        }
        return area;
    }
    */
	
	public static int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int len = height.length;
		int[][] dp = new int[len][len];
		for (int i = 0; i < len; i++) {
			dp[i][i] = height[i];
		}
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				dp[i][j] = Math.min(dp[i][j - 1], height[j]);
			}
		}
		int area = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			for (int j = i; j < len; j++) {
				area = Math.max(area, (j - i + 1) * dp[i][j]);
			}
		}
		return area;
	}
	
	// O(n) algorithm by using a stack
	public static int largestRectangleArea2(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int len = height.length;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int[] area = new int[len];
		int t = -1;
		for (int i = 0; i < len; i++) {
			while (!stack.isEmpty()) {
				if (height[i] <= height[stack.peek()]) {
					stack.pop();
				} else {
					break;
				}
			}
			if (stack.isEmpty()) {
				t = -1;
			} else {
				t = stack.peek();
			}
			area[i] += i - t - 1;
			stack.addFirst(i);
		}

		// clean the stack for Ri
		stack.clear();

		for (int i = len - 1; i >= 0; i--) {
			while (!stack.isEmpty()) {
				if (height[i] <= height[stack.peek()]) {
					stack.pop();
				} else {
					break;
				}
			}
			if (stack.isEmpty()) {
				t = len;
			} else {
				t = stack.peek();
			}
			area[i] += t - i - 1;
			stack.push(i);
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			max = Math.max(height[i] * (area[i] + 1), max);
		}
		return max;
	}
    
    public static void main(String[] args) {
		int[] height = {1};
		int result = largestRectangleArea2(height);
		System.out.println(result);
	}
}	