package rotate;

public class Solution {
    public static void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        
        int n = matrix.length;
        for (int from = 0; from <= (n >> 1); from++) {
            for (int i = from, to = n - 1 - from; i < to; i++) {
                int tmp = matrix[from][i];
//                matrix[from][i] = matrix[i][n - 1 - from];
//                matrix[i][n - 1 - from] = matrix[n-1-from][n-1-i];
//                matrix[n-1-from][n-1-i] = matrix[n-1-i][from];
//                matrix[n-1-i][from] = tmp;
                matrix[from][i] = matrix[n-1-i][from];
                matrix[n-1-i][from] = matrix[n-1-from][n-1-i];
                matrix[n-1-from][n-1-i] = matrix[i][n-1-from];
                matrix[i][n-1-from] = tmp;
            }
        }
    }
    
    static void print(int[][] matrix) {
    	int n = matrix.length;
    	System.out.println("==========================");
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++) {
    			System.out.print(matrix[i][j] + "\t");
    		}
    		System.out.println();
    	}
    	System.out.println("============================");
    }
    
    public static void main(String[] args) {
		int[][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}};
		print(matrix);
		rotate(matrix);
		print(matrix);
	}
}
