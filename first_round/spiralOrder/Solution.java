package spiralOrder;

import java.util.*;


/**
 * Good Question.
 * Need four inner loops instead of one.
 * I am seriously wrong. It specifies M*N matrix. What I'm doing with is N*N.
 * Shit.
 * @author ryan
 *
 */
public class Solution {
    public static ArrayList<Integer> spiralOrder1(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        int n = matrix.length;
        for (int from = 0; from < (n >> 1); from++) {
            for (int i = from, to = n - 1 - from; i < to; i++) {
            	list.add(matrix[from][i]);
//                list.add(matrix[from][i]);
//                list.add(matrix[i][n - 1 - from]);
//                list.add(matrix[n - 1 - from][n - 1 - i]);
//                list.add(matrix[n - 1 - i][from]);
            }
            for (int i = from, to = n - 1 - from; i < to; i++) {
            	list.add(matrix[i][n - 1 - from]);
            }
            for (int i = from, to = n - 1 - from; i < to; i++) {
            	list.add(matrix[n - 1 - from][n - 1 - i]);
            }
            for (int i = from, to = n - 1 - from; i < to; i++) {
            	list.add(matrix[n - 1 - i][from]);
            }
        }
        if ((n & 1) > 0) {
        	int index = n / 2;
        	list.add(matrix[index][index]);
        }
        return list;
    }
    
//    private static void addToList(ArrayList<Integer> list, int[][] matrix, int i, int j) {
//    	list.add(matrix[i][j]);
//    }
    
    
    
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        /**
         * Good Question. Only one loop suffice. No need of two loops.
         */
//        outer: for (int rowFrom = 0, rowTo = row - 1; rowFrom <= rowTo; rowFrom++, rowTo--) {
//            for (int colFrom = 0, colTo = col - 1;
//                colFrom <= colTo; colFrom++, colTo--) {
//                    if(addBorder(list, matrix, rowFrom, rowTo, colFrom, colTo)) {
//                    	break outer;
//                    }
//            }
//        }
        for (int rowFrom = 0, rowTo = row - 1,
        		colFrom = 0, colTo = col - 1;
        		rowFrom <= rowTo && colFrom <= colTo;
        		rowFrom++, rowTo = row - 1 - rowFrom,
        		colFrom++, colTo = col - 1 - colFrom) {
        	addBorder(list, matrix, rowFrom, rowTo, colFrom, colTo);
        }
        return list;
    }
    
    private static void addBorder(List<Integer> list, int[][] matrix, int rowFrom, int rowTo, int colFrom, int colTo) {
        if (rowFrom == rowTo) {
            for (int i = colFrom; i <= colTo; i++) {
                list.add(matrix[rowFrom][i]);
            }
            return;
        } else if (colFrom == colTo) {
            for (int i = rowFrom; i <= rowTo; i++) {
                list.add(matrix[i][colFrom]);
            }
            return;
        }
        for (int i = colFrom; i < colTo; i++) {
            list.add(matrix[rowFrom][i]);
        }
        for (int i = rowFrom; i < rowTo; i++) {
            list.add(matrix[i][colTo]);
        }
        for (int i = colTo; i > colFrom; i--) {
            list.add(matrix[rowTo][i]);
        }
        for (int i = rowTo; i > rowFrom; i--) {
            list.add(matrix[i][colFrom]);
        }
        return;
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
    	int m = 2;
		int n = 4;
		int[][] matrix = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = i * n + j;
			}
		}
		print(matrix);
		ArrayList<Integer> result = 
//				spiralOrder(null);
				spiralOrder(matrix);
		
		System.out.println(Arrays.toString(result.toArray()));
	}
}
