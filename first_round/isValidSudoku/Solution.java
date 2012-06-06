package isValidSudoku;

import java.util.*;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> memo = new HashMap<Integer, Set<Integer>>();
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.')
                    continue;
                if (!check(memo, i, j, (int)(board[i][j] - '1'), n)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean check(Map<Integer, Set<Integer>> memo,
        int row, int col, int digit, int base) {
            if (!memo.containsKey(row)) {
                Set<Integer> set = new HashSet<Integer>();
                set.add(digit);
                memo.put(row, set);
            } else {
                Set<Integer> set = memo.get(row);
                if (set.contains(digit)) {
                    return false;
                } else {
                    set.add(digit);
                }
            }
            int colKey = base + col;
            if (!memo.containsKey(colKey)) {
                Set<Integer> set = new HashSet<Integer>();
                set.add(digit);
                memo.put(colKey, set);
            } else {
                Set<Integer> set = memo.get(colKey);
                if (set.contains(digit)) {
                    return false;
                } else {
                    set.add(digit);
                }
            }
            int gridKey = base * 2 + ((row / 3) * 3 + col / 3);
            if (!memo.containsKey(gridKey)) {
                Set<Integer> set = new HashSet<Integer>();
                set.add(digit);
                memo.put(gridKey, set);
            } else {
                Set<Integer> set = memo.get(gridKey);
                if (set.contains(digit)) {
                    return false;
                } else {
                    set.add(digit);
                }
            }
            return true;
        }
}
