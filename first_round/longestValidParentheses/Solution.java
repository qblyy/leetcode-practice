package longestValidParentheses;

import java.util.*;

public class Solution {
	/*
    public int longestValidParentheses(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int i = 0;
        int len = s.length();
        int running = 0;
        LinkedList<Character> stack = new LinkedList<Character>();
        int cnt = 0;
        while (i < len) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.addFirst(ch);
            } else if (ch == ')') {
                if (stack.isEmpty()) {
                    cnt = 0;
                } else {
                    stack.removeFirst();
                    cnt += 2;
                    if (cnt > running) {
                        running = cnt;
                    }
                }
            }
           
            i++;
        }
        return running;
    }
    */
	
	public int longestValidParentheses(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }
        int cnt = 0;
        int i = 0;
        int k = -1;
        int maxl = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch == '(') {
                cnt++;
            } else if (ch == ')') {
                cnt--;
            }
            if (cnt == 0) {
                if (i - k > maxl) {
                    maxl = i - k;
                }
            } else if (cnt < 0) {
                k = i;
                cnt = 0;
            }
            /**
             * Good Question.
             */
            i++;
        }
        
        k = s.length();
        i = s.length() - 1;
        //int maxr = 0;
        cnt = 0;
        while (i >= 0) {
            char ch = s.charAt(i);
            if (ch == ')') {
                cnt++;
            } else if (ch == '(') {
                cnt--;
            }
            if (cnt == 0) {
                if (k - i > maxl) {
                    maxl = k - i;
                }
            } else if (cnt < 0) {
                k = i;
                cnt = 0;
            }
            i--;
        }
        return maxl;
    }
}