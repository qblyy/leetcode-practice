package letterCombinations;

import java.util.*;
/**
 * Well done.
 */
public class Solution {
    public static ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            result.add("");
            return result;
        }
        String[] keyboards = {"abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"};
        
        Map<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < keyboards.length; i++) {
            map.put((char)('2' + i), keyboards[i]);
        }
        char[] arr = new char[digits.length()];
        solve(arr, 0, digits, result, map);
        return result;
    }
    
    private static void solve(char[] arr, int index, String digits,
    ArrayList<String>
        result, Map<Character, String> map) {
        if (index == arr.length) {
            result.add(new String(arr));
            return;
        }   
        char ch = digits.charAt(index);
        String value = map.get(ch);
        for (int i = 0; i < value.length(); i++) {
            arr[index] = value.charAt(i);
            solve(arr, index + 1, digits, result, map); 
        }
    }

    
    public static void main(String[] args) {
		String digits = "";
		ArrayList<String> result = letterCombinations(digits);
		System.out.println(result.toString());
	}
}