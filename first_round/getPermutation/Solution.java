package getPermutation;

/**
 * Good Question! Failed the large test.
 * 
 * 
 * @author ryan
 *
 */
class Wrapper {
    int cnt = 0;
    String result = null;
}
public class Solution {
    public String getPermutation(int n, int k) {
        if (n <= 0) {
            return "";
        }
        int fact = 1;
        for (int i = 2; i <= n; i++) {
        	fact *= i;
        }
        if (k > fact) {
        	return "";
        }
        int[] A = new int[n];
        Wrapper r = new Wrapper();
        for (int i = 0; i < n; i++) {
        	/**
        	 * Good Question.
        	 * Should be A[0] instead of A[i]
        	 */
//            A[i] = i + 1;
        	A[0] = i + 1;
            solve(A, 1, n, k, r);
        }
        if (r.result == null) {
        	return "";
        }
        return r.result;
    }
    
    private void solve(int[] A, int index, int n, int k, Wrapper r) {
        if (r.result != null) {
            return;
        }
        if (index == n) {
            r.cnt++;
            if (r.cnt == k) {
            	/**
            	 * Good Question. Should not use Arrays.toString()
            	 * r.result = Arrays.toString(A);
            	 */
            	StringBuffer sb = new StringBuffer();
                for (int element : A) {
                    sb.append(element);
                }
                r.result = sb.toString();
                return;
            }
        }
        boolean valid = true;
        for (int i = 1; i <= n; i++) {
            valid = true;
            for (int j = 0; j < index; j++) {
                if (A[j] == i) {
                	valid = false;
                    break;
                }
            }
            if (valid) {
                A[index] = i;
                solve(A, index + 1, n, k, r);
            }
        }
    }
    
    public static void main(String[] args) {
		Solution test = new Solution();
		int n = 3;
		int k = 2;
		String result = test.getPermutation(n, k);
		System.out.println(result);
	}
}
