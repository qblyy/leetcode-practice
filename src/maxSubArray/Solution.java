package maxSubArray;

/**
 * Good Question.
 * @author ryan
 *
 */
public class Solution {
    public static int maxSubArray(int[] A) {
        if (A == null) {
            return 0;
        }        
        int sum = 0;
        int running = 0;
        for (int i = 0; i < A.length; i++) {
            running += A[i];
            if (running > sum) {
                sum = running;
            }
            if (running < 0) {
                running = 0;
            }
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
		int[] A = {5, -1, -1, 3};
//			{31,-41,59,26,-53,58,97,-93,-23,84};
		int result = maxSubArray(A);
		System.out.println(result);
	}
}
