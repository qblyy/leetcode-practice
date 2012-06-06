package totalNQueens;

public class Solution {
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;
        }
        int A[] = new int[n];
        int sol = 0;
        for (int i = 0; i < n; i++) {
            A[0] = i;
            sol += solve(A, 1, n);
        }
        return sol;
    }
    
    private int solve(int[] A, int index, int n) {
        if (index == n) {
            return 1;
        }
        int sol = 0;
        boolean valid = true;
        for (int j = 0; j < n; j++) {
            valid = true;
            for (int i = 0; i < index; i++) {
                if (A[i] == j || Math.abs(A[i] - j) == (index - i)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                A[index] = j;
                sol += solve(A, index + 1, n);
            }
        }
        return sol;
    }
}
