package sudoku_solver;

import java.util.*;

public class Solution {
    public static void solveSudoku(char[][] board) {
	int NINE = board.length;
	Map<Integer, Set<Character>> memo = new HashMap<Integer, Set<Character>>();
	for (int i = 0; i < 27; i++) {
	    memo.put(i, new HashSet<Character>());
	}
	int emptySpots = 0;
	for (int i = 0; i < NINE; i++) {
	    for (int j = 0; j < NINE; j++) {
		char ch = board[i][j];
		if (ch != '.') {
		    if (memo.get(i).contains(ch) ||
			memo.get(NINE + j).contains(ch) ||
			memo.get(NINE * 2 + 3 * (i / 3) + j / 3).contains(ch)) {
			System.err.println("Obviously, it's fucking invalid configuration.");
			System.err.println("(" + i + ", " + j + "): " + board[i][j]);
			return;
		    }
		    memo.get(i).add(ch);
		    memo.get(NINE + j).add(ch);
		    memo.get(NINE * 2 + 3 * (i / 3) + j / 3).add(ch);
		} else {
		    emptySpots++;
		}
	    }
	}
	if (solve(board, memo, new int[]{emptySpots})) {
	    System.out.println("Solved!");
	} else {
	    System.err.println("Shit, I failed. But are you sure the configuration is valid?");
	}
	
    }

    private static boolean solve(char[][] board, Map<Integer, Set<Character>> memo, int[] emptySpots) {
	if (emptySpots[0] == 0)
	    return true;

	int NINE = board.length;
	int nearest = 0;
	int nextY = -1;
	int nextX = -1;
	for (int i = 0; i < NINE; i++) {
	    int row = i;
	    for (int j = 0; j < NINE; j++) {
		if (board[i][j] != '.') {
		    continue;
		}
		int col = NINE + j;
		int grid = (NINE << 1) + 3 * (i / 3) + j / 3;
		int sum = memo.get(row).size() + memo.get(col).size() + memo.get(grid).size();
		if (sum > nearest) {
		    nearest = sum;
		    nextY = i;
		    nextX = j;
		}
	    }
	}

	int rowKey = nextY;
	int colKey = NINE + nextX;
	/**
	 * Good Question.
	 * Be careful here how to calculate the grid key. Note it's NOT
	 * (NINE << 1) + (nextY / 3) + nextX / 3;
	 * the middle item should be 3 * (nextY / 3)
	 */
	int gridKey = (NINE << 1) + 3 * (nextY / 3) + nextX / 3;
	for (char ch = '1'; ch <= '9'; ch++) {
	    if (memo.get(rowKey).contains(ch) ||
		memo.get(colKey).contains(ch) ||
		memo.get(gridKey).contains(ch)) {
		continue;
	    }
	    memo.get(rowKey).add(ch);
	    memo.get(colKey).add(ch);
	    memo.get(gridKey).add(ch);
	    board[nextY][nextX] = ch;
	    emptySpots[0]--;
	    if (solve(board, memo, emptySpots)) {
		return true;
	    }
	    memo.get(rowKey).remove(ch);
	    memo.get(colKey).remove(ch);
	    memo.get(gridKey).remove(ch);
	    board[nextY][nextX] = '.';
	    emptySpots[0]++;
	}
	return false;
    }

    public static char[][] processArray(String[] arr) {
	final int NINE = 9;
	char[][] board = new char[NINE][NINE];
	for (int i = 0; i < arr.length; i++) {
	    board[i] = arr[i].toCharArray();
	}
	return board;
    }

    public static void printBoard(char[][] board) {
    System.out.println("====================================================================");
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
		System.out.print(board[i][j] + "\t");
	    }
	    System.out.println("\n");
	}
	System.out.println("====================================================================");
    }

    public static void main(String... args) {
	String[] arr = {
//		".....7..9",".4..812..","...9...1.","..53...72","293....5.",".....53..","8...23...","7...5..4.","531.7...."
//			".....7..9",".4..812..","...9...1.","..53...72","293....5.",".....53..","8...23...","7...5..4.","531.7...."
			// Most difficult one:
			".......12", "....35...", "...6...7.", "7.....3..", "...4..8..", "1.........", "...12....", ".8.....4.", ".5....6.."
	};

	char[][] board = processArray(arr);
	printBoard(board);
	solveSudoku(board);
	printBoard(board);
    }
}