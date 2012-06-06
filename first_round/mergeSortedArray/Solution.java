package mergeSortedArray;

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if (null == A || null == B)
            return;
        int p = m + n - 1;
        while (n > 0) {
            if (m > 0 && A[m - 1] > B[n - 1]) {
                A[p] = A[m - 1];
                m--;
            } else {
                A[p] = B[n - 1];
                n--;
            }
            p--;
        }
    }
}