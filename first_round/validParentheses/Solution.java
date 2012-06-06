package validParentheses;

import java.util.*;

public class Solution {
    public static boolean isValid(String s) {
        if (null == s || s.length() == 0)
            return true;
        
        char[] left = {'(', '{', '['};
        char[] right = {')', '}', ']'};
        LinkedList<Character> stack = new LinkedList<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            for (int j = 0; j < left.length; j++) {
                if (ch == left[j]) {
                    stack.addFirst(ch);
                    break;
                } 
                if (ch == right[j]){
                    if (stack.isEmpty() ||
                        (char)(stack.removeFirst()) != left[j]) {
                            return false;
                        }
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
		String s = 
//				"[({(())}[()])]"
				"[])"
				;
		boolean result = isValid(s);
		System.out.println(result);
	}
}
