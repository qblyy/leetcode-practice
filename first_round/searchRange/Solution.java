package searchRange;

import java.util.Arrays;

/**
 * Very Good Question.
 * I can't even get it right at all.
 * Be extremely careful with the off-bye-1 problem in Binary Search problems.
 * The solution is to carefully deal with left and right with bound situations.
 * @author ryan
 *
 */
public class Solution {
    public static int[] searchRange(int[] A, int target) {
        final int[] notFound = {-1, -1};
        if (A == null || A.length == 0) {
            return notFound;
        }
        int left = 0, right = A.length - 1;
        int low = 0, high = A.length - 1;
        /*
        boolean exists = false;
        while (low < high) {
        	// make mid toward high, and look out for overflow
            int mid = low + (high - low + 1) / 2;
            if (A[mid] == target) {
                exists = true;
                break;
            } else if (A[mid] < target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        if (A[low] == target) {
        	exists = true;
        }
        if (!exists) {
            return notFound;
        }
        */
        low = 0;
        high = A.length - 1;
        while (low < high) {
            left = low + (high - low + 1) / 2;
            if (A[left] < target) {
                low = left;
            } else {
                high = left - 1;
            }
        }
        /**
         * Be very careful here. Need to increment left by ONE.
         */
//        left++;
//        left = low + 1;
        if (A[low] != target) {
        	if (low < A.length - 1 && A[low + 1] == target) {
        		left = low + 1;
        	} else {
        		left = -1;
        	}
        } else {
        	left = low;
        }
        low = 0;
        high = A.length - 1;
        while (low < high) {
            right = low + (high - low + 1) / 2;
            if (A[right] > target) {
                high = right - 1;
            } else {
                low = right;
            }
        }
        /**
         * Be very careful here. Need to decrement right by ONE.
         */
//        right--;
//        right = high;
        if (A[high] != target) {
        	right = -1;
        } else {
        	right = high;
        }
        return new int[]{left, right};
    }
    
/**
 * A more elegent solution.
 * @param A
 * @param target
 * @return
 */
    public int[] searchRange_MoreElegent(int[] A, int target) {
        final int[] notFound = {-1, -1};
        if (A == null || A.length == 0) {
            return notFound;
        }
        int left = 0, right = A.length - 1;
        int low = 0, high = A.length - 1, mid = -1;
        
        low = 0;
        high = A.length - 1;
        while (low < high) {
        	/**
        	 * Be careful. Round left toward low.
        	 */
            mid = low + (high - low) / 2;
            if (A[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        if (A[low] != target) {
        	left = -1;
        } else {
        	left = low;
        }
        low = 0;
        high = A.length - 1;
        while (low < high) {
        	/**
        	 * Be careful. Round right toward high.
        	 */
            mid = low + (high - low + 1) / 2;
            if (A[mid] > target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }

        if (A[high] != target) {
        	right = -1;
        } else {
        	right = high;
        }
        return new int[]{left, right};
    
    }
    
    public static void main(String[] args) {
		int[] A = {2, 2};
		int target = 3;
		int[] result = searchRange(A, target);
		System.out.println(Arrays.toString(result));
	}
}
