package uniquePaths;

/**
 * Yay!
 * Classic DP problem
 * @author ryan
 *
 */
public class Solution {
    public static  int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            matrix[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            matrix[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
            }
        }
        return matrix[m - 1][n - 1];
    }
    
    public static void main(String[] args) {
		int m = 1;
		int n = 1;
		int result = uniquePaths(m, n);
		System.out.println(result);
	}
}
