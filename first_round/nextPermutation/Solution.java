package nextPermutation;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null || num.length <= 1) {
            return;
        }
        int c = num.length - 2;
        /**
         * Good Question. Difference between > and >=. The famous Off-By-One problem.
         */
//        while (c >= 0 && num[c] > num[c+1]) {
        while (c >= 0 && num[c] >= num[c+1]) {
            c--;
        }
        if (c < 0) {
           reverseTail(num, 0);
           return; 
        }
        int swapIndex = c + 1;
        for (int i = c + 2; i < num.length; i++) {
            if (num[i] > num[c]) {
                swapIndex = i;
            } else {
            	break;
            }
        }
        swap(num, c, swapIndex);
        reverseTail(num, c + 1);
        
    }
    
    private void swap(int[] A, int a, int b) {
        int tmp = A[a];
        A[a] = A[b];
        A[b] = tmp;
    }
    
    void reverseTail(int[] A, int fromIndex) {
        int toIndex = A.length - 1;
        while (fromIndex < toIndex) {
            swap(A, fromIndex, toIndex);
            fromIndex++;
            toIndex--;
        }
    }
    
    public static void main(String[] args) {
		Solution test = new Solution();
		int[] num = {2,2,7,5,4,3,2,2,1};
		test.nextPermutation(num);
		System.out.println(Arrays.toString(num));
	}
}