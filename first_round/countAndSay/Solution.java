package countAndSay;

public class Solution {
    public String countAndSay(int n) {
        return solve(Integer.toString(1), 1, n);
    }
    
    private String solve(String s, int depth, int n) {
        if (depth >= n) {
            return s;
        }
        int k = 0;
        int i = 0;
        StringBuffer sb = new StringBuffer();
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(k) == s.charAt(i)) {
                continue;
            } else {
                sb.append(i - k);
                sb.append(s.charAt(k));
                k = i;
            }
        }
        if (k < i) {
           sb.append(i - k);
           sb.append(s.charAt(k));
        }
        return solve(sb.toString(), depth + 1, n);
    }
}