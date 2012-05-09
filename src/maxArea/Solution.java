package maxArea;


public class Solution {
	public int maxArea(int[] height) {
		int low = 0, high = height.length - 1;
		int maxArea = 0, runningArea = 0;
		while (low < high) {
			runningArea = (high - low) * Math.min(height[low], height[high]);
			if (runningArea > maxArea) {
				maxArea = runningArea;
			}
			int left = low;
			int right = high;

			if (height[low] > height[high]) {
				while (right > left && height[right] <= height[high]) {
					right--;
				}
				high = right;
			} else if (height[high] > height[low]) {
				while (left < right && height[left] <= height[low]) {
					left++;
				}
				low = left;
			} else {
				low++;
				high--;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		int[] height = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int result = test.maxArea(height);
		System.out.println(result);
	}
}
