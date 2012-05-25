package combine;
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        int[] input = new int[n];
        for (int i = 0; i < input.length; i++) {
            input[i] = i + 1;
        }
        int[] A = new int[k];
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        solve(input, A, 0, result);
        return result;
    }
    
    private void addSol(int[] A, ArrayList<ArrayList<Integer>> result) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : A) {
            list.add(i);
        }
        result.add(list);
    }
    
    private void solve(int[] input, int[] A, int index, ArrayList<ArrayList<Integer>> result) {
        if (index >= A.length) {
            addSol(A, result);
            return;
        }
//        for (int i = 0; i < input.length ; i++) {
        for (int i = index; i < input.length ; i++) {
        	if (index > 0 && input[i] <= A[index - 1]) {
	            continue;
        	} else {
        		A[index] = input[i];
	            solve(input, A, index+1, result);
        	}
        }
    }
    
    public static void main(String[] args) {
		int n = 13;
		int k = 1;
		Solution test = new Solution();
		ArrayList<ArrayList<Integer>> result = test.combine(n, k);
		for(ArrayList<Integer> al: result) {
			System.out.println(al);
		}
	}
}
