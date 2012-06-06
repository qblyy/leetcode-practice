package minWindow;

import java.util.*;

public class Solution {
	/**
	 * Good Question.
	 * @param S
	 * @param T
	 * @return
	 */
    public static String minWindow(String S, String T) {
        if (S == null || S.isEmpty()) {
            return "";
        }
        if (T == null || T.isEmpty()) {
            return "";
        }
        char[] arrT = T.toCharArray();
        Map<Character, Integer> needToFind = new HashMap<Character, Integer>();
        for(char ch: arrT) {
            if (needToFind.containsKey(ch)) {
                needToFind.put(ch, needToFind.get(ch) + 1);
            } else {
                needToFind.put(ch, 1);
            }
        }
        int head = 0;
        int tail = 0;
        int minHead = 0;
        int minTail = S.length();
        Map<Character, Integer> hasFound = new HashMap<Character, Integer>();
        int count = 0;
        while(head <= tail && tail < S.length()) {
            char ch = S.charAt(tail);
            if (needToFind.containsKey(ch)) {
                if (!hasFound.containsKey(ch)) {
                    hasFound.put(ch, 1);
                } else {
                    hasFound.put(ch, hasFound.get(ch) + 1);
                }
                if (hasFound.get(ch) <= needToFind.get(ch)) {
                    count++;
                } 
                
                    char h = S.charAt(head);
                    while (!needToFind.containsKey(h) || hasFound.get(h) > needToFind.get(h)) {
                        if(needToFind.containsKey(h)) {
                            hasFound.put(h, hasFound.get(h) - 1);
                        }
                        head++;
                        h = S.charAt(head);
                    }
               
            }
            if (count == T.length()) {
                if (tail - head + 1 < minTail - minHead) {
                    minHead = head;
                    minTail = tail + 1;
                }
            }
            tail++;
        }
        /*
        for (char ch : arrT) {
            if (!hasFound.containsKey(ch) || hasFound.get(ch) < needToFind.get(ch)) {
                return "";
            }
        }
        */
        if (count < T.length()) {
        	return "";
        }
        
        return S.substring(minHead, minTail);

    
    }
        
    /**
     * Use two arrays instead of map. Which would be much faster.
     * @param S
     * @param T
     * @return
     */
    public static String minWindow2(String S, String T) {
    	// assume ASCII
    	int needToFind[] = new int[256];
    	for (int i = 0; i < T.length(); i++) {
    		needToFind[(int)T.charAt(i)]++;
    	}
    	int hasFound[] = new int[256];
    	int count = 0;
    	int minBegin = 0;
    	int minEnd = S.length() - 1;
    	for (int begin = 0, end = 0; end < S.length(); end++) {
    		int ch = (int)S.charAt(end);
    		if (needToFind[ch] == 0) {
    			continue;
    		}
    		hasFound[ch]++;
    		if (hasFound[ch] <= needToFind[ch]) {
    			count++;
    		}
    		
    		
    		if (count == T.length()) {
    			int h = (int)S.charAt(begin);
    			while (needToFind[h] == 0 || hasFound[h] > needToFind[h]) {
    				if (needToFind[h] != 0) {
    					hasFound[h]--;
    				}
    				begin++;
    				h = (int)S.charAt(begin);
    			}
    			// update minBegin and minEnd
    			if (end - begin < minEnd - minBegin) {
    				minBegin = begin;
    				minEnd = end;
    			}
    			
    		}
    	}
    	if (count < T.length()) {
    		return "";
    	}
    	return S.substring(minBegin, minEnd + 1);
    }

    public static void main(String[] args) {
		String S = "ab";
		String T = "b";
		String result = minWindow2(S, T);
		System.out.println(result);
	}
}