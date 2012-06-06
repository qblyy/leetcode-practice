package trap;

/**
 * I misunderstood the question again!
 * That's unforgivable in an interview!
 * @author ryan
 *
 */
public class Solution {
    public static int trap1(int[] A) {
        if (null == A || A.length == 0) {
            return 0;
        }
        
        int left = 0;
        int tallestInShorter = 0;
        int tallestIndex = -1;
        int cnt = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[left]) {
                if (A[i] >= tallestInShorter) {
                    tallestInShorter = A[i];
                    tallestIndex = i;
                }
            } else {
                cnt += (i - left) * A[left];
                left = i;
                tallestInShorter = 0;
                tallestIndex = i;
            }
        }
        cnt += (tallestIndex - left) * tallestInShorter;
        if (tallestIndex != A.length - 1) {
            
            int right = A.length - 1;
            for (int j = A.length - 2; j > tallestIndex; j--) {
                if (A[j] >= A[right]) {
                    cnt += (right - j) * A[right];
                    right = j;
                } else {
                    continue;
                }
            }
            cnt += (right - tallestIndex) * A[right];
        }
        
        return cnt;
    }

	public static int trap(int[] A) {
		if (null == A || A.length <= 2) {
			return 0;
		}
		int cnt = 0;
		int left = 0;
		int nextTall = 0;
		int nextTallIndex = -1;
		int right = A.length - 1;
		for (int i = 1; i < A.length; i++) {
			if (A[i] >= A[left]) {
				for (int j = left + 1; j < i; j++) {
					cnt += A[left] - A[j];
				}
				left = i;
				nextTall = 0;
			} else {
				/**
				 * Good Question!
				 * Subtle off-by-one problem. Corner cases are hard to cover at first try.
				 * change > to >=, the result will be right.
				 */
//				if (A[i] > nextTall) {
				if (A[i] >= nextTall) {
					nextTall = A[i];
					nextTallIndex = i;
				}
			}
		}
		if (left != right) {
			for (int i = right - 1; i > nextTallIndex; i--) {
				if (A[i] >= A[right]) {
					right = i;
				} else {
					cnt += A[right] - A[i];
				}
			}
			for (int i = left + 1; i < nextTallIndex; i++) {
				cnt += A[nextTallIndex] - A[i];
			}
		}
		return cnt;
	}
    
    public static void main(String[] args) {
		int[] A = {
				0,1,0,2,1,0,1,3,2,1,2,1
				};
		int result = trap(A);
		System.out.println(result);
	}
}
