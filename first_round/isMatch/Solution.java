package isMatch;

public class Solution {
    public static boolean isMatch1(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return match1(s, 0, p, 0);
    }
    
    private static boolean match1(String s, int indexS, String p, int indexP) {
        if (indexS == s.length() && indexP == p.length()) {
            return true;
        }
        char charS = (indexS >= s.length()) ? (char)Character.UNASSIGNED : s.charAt(indexS);
        char charP = p.charAt(indexP);
        if (charP == '*') {
            if (p.charAt(indexP - 1) == charS
                || p.charAt(indexP - 1) == '.') {
            	boolean extendP = match1(s, indexS, p, indexP + 1);
                if (extendP) {
                    return true;
                }
                boolean extendS = match1(s, indexS + 1, p, indexP);
                if (extendS) {
                    return true;
                }
                boolean extendBoth = match1(s, indexS + 1, p, indexP + 1);
                return extendBoth;
            } else {
                boolean extendP = match1(s, indexS, p, indexP + 1);
                return extendP;                
            }
        } else if (charP == '.') {
            if (indexP < p.length() - 1 && p.charAt(indexP + 1) == '*') {
                return match1(s, indexS, p, indexP + 1);
            } else {
                return match1(s, indexS + 1, p, indexP + 1);
            }
        } else {
            if (indexP < p.length() - 1 && p.charAt(indexP + 1) == '*') {
            	boolean extendP = match1(s, indexS, p, indexP + 1);
            	return extendP;
            } else {
            	return (charP != charS) ? false : match1(s, indexS + 1, p, indexP + 1);
            }
        }
    }
    
    /**
     * Very Good Question. Thanks to leetcode!
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        return match(s, 0, p, 0);
    }
    
    private static boolean match(String s, int indexS, String p, int indexP) {
    	if (indexS == s.length() && indexP == p.length()) {
    		return true;
    	}
    	return false;
    }
    
    
    public static void main(String[] args) {
		String[] sp = {
//				"", ""
//				"abbbcd", "ab*bbbcd"
				"a", "ab*"
		};
		boolean result = isMatch1(sp[0], sp[1]);
		System.out.println(result);
	}
}