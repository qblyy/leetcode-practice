package combinationSum;

import java.util.*;

public class Solution {

	public ArrayList<ArrayList<Integer>> combinationSum1(int[] candidates,
			int target) {
		Arrays.sort(candidates);
		Wrapper r = solve1(candidates, candidates.length - 1, target);
		return r.al;
	}

	class Wrapper {
		boolean can;
		ArrayList<ArrayList<Integer>> al;

		Wrapper(boolean can, ArrayList<ArrayList<Integer>> al) {
			this.can = can;
			this.al = al;
		}
	}

	private Wrapper solve1(int[] input, int d, int target) {
		if // (d >= 0 &&
		(target == 0) {
			ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> inner = new ArrayList<Integer>();
			al.add(inner);
			return new Wrapper(true, al);
		}
		if (d < 0) {
			return new Wrapper(false, null);
		}
		if (input[d] > target) {
			return solve1(input, d - 1, target);
		}
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; target - i * input[d] >= 0; i++) {
			Wrapper tail = solve1(input, d - 1, target - i * input[d]);
			if (tail.can) {
				for (ArrayList<Integer> inner : tail.al) {

					for (int j = 0; j < i; j++) {
						inner.add(input[d]);
					}
				}
				result.addAll(tail.al);
			}
		}
		if (result.size() > 0) {
			return new Wrapper(true, result);
		} else {
			return new Wrapper(false, null);
		}
	}

	
	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates == null || candidates.length == 0) {
			return null;
		}
		Arrays.sort(candidates);
		int len = (target +  candidates[0]) / candidates[0];
		int[] A = new int[len + 1];
		A[0] = 0;
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		solve(candidates, 0, target, A, 0, result);
		return result;
	}
	
	

	private void addSol(int[] A, int n, ArrayList<ArrayList<Integer>> result) {
		ArrayList<Integer> ll = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			ll.add(A[i]);
		}
		result.add(ll);
	}
	
	private void solve(int[] input, int sum, int target, int[] A, int n, ArrayList<ArrayList<Integer>> result) {
		if (sum > target) {
			return;
		}
		if (sum == target) {
			addSol(A, n, result);
		}
		for (int i = 0; i < input.length; i++) {
			if (input[i] >= A[n]) {
				A[n + 1] = input[i];
				solve(input, sum + input[i], target, A, n + 1, result);
			}
		}
	}
	
	public static void main(String[] args) {
		int[] candidates = new int[] { 1, 2, 3, 6, 7 };
		int target = 8;
		Solution test = new Solution();
		ArrayList<ArrayList<Integer>> list = test.combinationSum(candidates,
				target);
		for (ArrayList<Integer> l : list) {
			System.out.println(l.toString());
		}
	}
}