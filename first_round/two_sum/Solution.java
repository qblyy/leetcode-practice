package two_sum;

public class Solution {
    public static int[] twoSum(int[] numbers, int sum) {
	if (numbers == null || numbers.length < 2) {
	    return new int[]{0, 0};
	}
	int[] result = {0, 1};
	for (int i = 0; i < numbers.length - 1; i++) {
	    for (int j = i + 1; j < numbers.length; j++) {
		if (numbers[i] + numbers[j] == sum) {
		    result[0] = i + 1;
		    result[1] = j + 1;
		    return result;
		}
	    }
	}
	return result;
    }
}