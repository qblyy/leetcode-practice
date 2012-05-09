package combinationSum2;

import java.util.*;

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Set<Integer> memo = new HashSet<Integer>();
        final int len = num.length;
        int size = 1 << len;
        int sum = 0;
        int mask = 0;
        outer: for (int i = 0; i < size; i++) {
            sum = 0;
            for (int j = 0; j < len; j++) {
                mask = 1 << j;
                if ((mask & i) > 0) {
                    sum += num[j];
                }
                if (sum > target)
                    continue outer;
            }
            if (sum == target) {
                addSol(num, i, memo, result);
            }
        }
        return result;
    }
    
    private void addSol(int[] input, int n, Set<Integer> memo, ArrayList<ArrayList<Integer>> result) {
    	StringBuffer sb = new StringBuffer();
    
    	for (int i = 0; i < input.length; i++) {
            if ((n & (1 << i)) > 0) {
            	sb.append(input[i]);
            }
            
    	}
    	String key = sb.toString();
    	if (memo.contains(key.hashCode())) {
    		return;
    	}
    	memo.add(key.hashCode());
        ArrayList<Integer> ll = new ArrayList<Integer>();
        for (int i = 0; i < input.length; i++) {
            if ((n & (1 << i)) > 0) {
                ll.add(input[i]);
            }
        }
        result.add(ll);
    }
    
    public static void main(String[] args) {
		int[] num = {1, 2};
		int target = 1;
		Solution test = new Solution();
		ArrayList<ArrayList<Integer>> result = test.combinationSum2(num, target);
		for (ArrayList<Integer> ll: result) {
			System.out.println(ll);
		}
	}
}