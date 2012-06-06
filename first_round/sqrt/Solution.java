package sqrt;

/**
 * Tricky problem.
 * Do pay attention to off-by-one problem in binary search problems.
 * @author ryan
 *
 */
public class Solution {
    public static  int sqrt(int x) {
        if (x < 0)
            return -1;
        
        int high = x;
        int low = 0;
        int mid = -1;
        long product = 1;
        while (low < high) {
            mid = low + (int)(((long)high - low + 1) / 2);
            /**
             * Good Question.
             * Very important to test if mid*mid will produce an overflow.
             * Note: Should use Integer.MAX_VALUE instead of Long.MAX_VALUE here.
             * Try the following statement, you'll be surprised.
             * if (Long.MAX_VALUE / mid <= mid) {
             */
            if (Integer.MAX_VALUE / mid <= mid) {
            	high = mid - 1;
            	continue;
            }
            product = mid * mid;
            if (product == x) {
                return mid;
            } else if (product > x) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return high;
    }
    
    public static void main(String[] args) {
		int x = 
//				0
//				1
//				987654321
//				Integer.MAX_VALUE
//				2147395599
				2147483647
				;
		int result = sqrt(x);
		System.out.println(result);
	}
}