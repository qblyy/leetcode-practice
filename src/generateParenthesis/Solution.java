package generateParenthesis;

import java.util.*;
public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        char[] A = new char[n << 1];
        find(n, n, 0, A, result);
        return result;
                
    }
    
    private void find(int l, int r, int index, char[] A, ArrayList<String> result) {
        if (r == 0) {
            result.add(new String(A));
            return;
        }
        if (l > 0) {
            A[index] = '(';
            find(l - 1, r, index + 1, A, result);
        }
        if (r > l) {
            A[index] = ')';
            find(l, r - 1, index + 1, A, result);
        }
    }
}
