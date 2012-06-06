package generateMatrix;

import java.util.Scanner;

public class Solution {
    public static int[][] generateMatrix(int n) {
        if (n <= 0) {
        	/**
        	 * return an empty array instead.
        	 */
//            return null;
        	return new int[][]{};
        }
        int[][] matrix = new int[n][n];
        
        int cnt = 1;
        for (int from = 0, to = n / 2;
            from < to;
            from++) {
        	int inc = cnt;
        	/**
        	 * Good Question.
        	 * Need to carefully increment each entry.
        	 * And don't forget to increment inc for each loop.
        	 */
           for (int i = from, j = n - 1 - from, diff = j - i; i < j; i++) {
                matrix[from][i] = inc;
                matrix[i][n - 1 - from] = inc + diff;
                matrix[n - 1 - from][n - 1 - i] = inc + (diff << 1);
                matrix[n - 1 - i][from] = inc + 3 * diff;
                inc++;
           }
           cnt += (n - 1 - 2 * from) << 2;
        }
        if ((n & 1) == 1) {
            matrix[n / 2][n / 2] = cnt;
        }
        return matrix;
    }
    
    private static void print(int[][] matrix) {
    	if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    		return;
    	}
    	int m = matrix.length;
    	int n = matrix[0].length;
    	System.out.println("==================");
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n - 1; j++) {
    			System.out.print(matrix[i][j] + "\t");
    		}
    		System.out.println(matrix[i][n-1]);
    	}
    	System.out.println("==================");

    }
    
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Please enter a positive integer:");
//    	scanner.nextInt();
		String s = null;
		int n = 0;
		while ((s = scanner.next()) != null) {
			try {
				n = Integer.parseInt(s);
				System.out.println("You entered: " + n);
//				Thread
				break;
			} catch (NumberFormatException e) {
				System.out.println("Please enter an integer, thanks for your cooperation:");
			}
		}
		int[][] matrix = generateMatrix(n);
		print(matrix);
	}
}
