package anagrams;

import java.util.*;
public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result = new ArrayList<String>();
        Map<String, List<Integer>> memo = new HashMap<String, List<Integer>>();
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if (memo.containsKey(key)) {
                memo.get(key).add(i);
            } else {
                List<Integer> ll = new ArrayList<Integer>();
                ll.add(i);
                memo.put(key, ll);
            }
        }
        for (String key: memo.keySet()) {
            if (memo.get(key).size() > 1) {
                List<Integer> ll = memo.get(key);
                for (Integer i : ll) {
                    result.add(strs[i]);
                }
            }
        }
        return result;
    }
}
