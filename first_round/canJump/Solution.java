package canJump;

/**
 * canJump3(int[] A) is Good Question.
 * @author ryan
 *
 */

public class Solution {
    public boolean canJump(int[] A) {
        if (null == A) {
            return false;
        }
        if (A.length == 1) {
            return true;
        }
        
        
        return dest(A, A.length - 1);
    }
    
    private boolean dest(int[] A, int index) {
        if (index <= 0) {
            return true;
        }
        for (int i = index - 1; i >= 0; i--) {
            if (A[i] + i >= index) {
                if(dest(A, i)) {
                    return true;
                }
            } 
        }
        return false;
    }
    
    public boolean canJump2(int[] A) {
    	if (null == A) {
            return false;
        }
        if (A.length == 1) {
            return true;
        }
        int[] dp = new int[A.length];
        for (int i = 0; i < A.length; i++) {
        	dp[i] = A[i] + i;
        	for (int j = 0; j < i; j++) {
        		dp[i] = Math.max(dp[i], A[j] + j);
        	}
        	if (i < A.length - 1 && dp[i] <= i) {
        		return false;
        	}
        }
        if(dp[A.length - 1] >= A.length - 1) {
            return true;
        }
        return false;
    }
    
    public boolean canJump3(int[] A) {
    	int i = 0;
    	int k = 0;
    	int sum = 0;
    	while (i < A.length) {
    		sum = i + A[i];
//    		if (sum < i) {
        	if (k < i) {
    			return false;
    		}
    		if (sum > k) {
    			k = sum;
    		}
    		if (k >= A.length - 1) {
    			return true;
    		}
    		i++;
    	}
    	
    	return false;
    }
    
    public static void main(String[] args) {
    	int[] A = {2, 0, 2, 0, 1};
    	Solution test = new Solution();
    	boolean result = test.canJump3(A);
    	System.out.println(result);
	}
}
