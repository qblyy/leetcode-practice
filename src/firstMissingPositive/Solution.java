package firstMissingPositive;

/**
 * 
 * @author ryan
 * Good Question.
 */
public class Solution {
    public int firstMissingPositive(int[] A) {
        for (int i = 0; i < A.length; i++) {
            while (A[i] != i + 1) {
                if ((A[i] <= 0) ||
                    (A[i] > A.length) || 
                    (A[i] == A[A[i] - 1])) {
                    break;
                }
                int tmp = A[i];
                A[i] = A[tmp - 1];
                A[tmp - 1] = tmp;
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }

	public static void main(String[] args) {
		int[] A = { 10, 4, 16, 54, 17, -7, 21, 15, 25, 31, 61, 1, 6, 12, 21,
				46, 16, 56, 54, 12, 23, 20, 38, 63, 2, 27, 35, 11, 13, 47, 13,
				11, 61, 39, 0, 14, 42, 8, 16, 54, 50, 12, -10, 43, 11, -1, 24,
				38, -10, 13, 60, 0, 44, 11, 50, 33, 48, 20, 31, -4, 2, 54, -6,
				51, 6 };
		Solution test = new Solution();
		int result = test.firstMissingPositive(A);
		System.out.println(result);
	}
}
