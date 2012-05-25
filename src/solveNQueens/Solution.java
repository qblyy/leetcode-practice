package solveNQueens;

import java.util.*;

/**
 * Good Question. I did it terribly wrong at first time, when updating the positions[] array.
 * @author ryan
 *
 */
public class Solution {
	ArrayList<String[]> result = new ArrayList<String[]>();

	public ArrayList<String[]> solveNQueens(int n) {
		if (n <= 0) {
			return null;
		}
		int[] positions = new int[n];

		for (int i = 0; i < n; i++) {
			positions[0] = i;
			solve(positions, 1);
		}
		return result;
	}

	private void solve(int[] A, int index) {
		if (index == A.length) {
			addToResult(A);
			return;
		}
		/**
		 * Terribly wrong.
		for (int j = 0; j < A.length; j++) {
			for (int i = 0; i < index; i++) {
				if (A[i] == j || Math.abs(A[i] - j) == index - i) {
					break;;
				}
				A[index] = j;
				solve(A, index + 1);
			}
		}
		*/
		
		boolean valid = true;
		for (int j = 0; j < A.length; j++) {
			valid = true;
			for (int i = 0; i < index; i++) {
				if (A[i] == j || Math.abs(A[i] - j) == index - i) {
					valid = false;
					break;
				}
			}
			if (valid) {
				A[index] = j;
				solve(A, index + 1);
			}
		}
	}

	private void addToResult(int[] A) {
		String[] sol = new String[A.length];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < sol.length; i++) {
			sb.delete(0, sb.length());
			for (int j = 0; j < A.length; j++) {
				if (A[i] == j) {
					sb.append('Q');
				} else {
					sb.append('.');
				}
			}
			sol[i] = sb.toString();
		}
		result.add(sol);
	}

	public static void main(String[] args) {
		Solution test = new Solution();
		int n = 10;
		ArrayList<String[]> result = test.solveNQueens(n);
		for (int i = 0; i < result.size(); i++) {
			String[] ss = result.get(i);
			System.out.println("sol # " + i + "=============");
			for (int j = 0; j < n; j++) {
				System.out.println(ss[j]);
			}
			System.out.println("===========================");
		}
	}
}
