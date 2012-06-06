package multiply;

import java.util.*;

public class Solution {
    public static String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "0";
        }
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] n1 = null;
        char[] n2 = null;
        
        if (num1.length() >= num2.length()) {
            n1 = num1.toCharArray();
            n2 = num2.toCharArray();
        } else {
            n2 = num1.toCharArray();
            n1 = num2.toCharArray();
        }
        
        int[] temp = new int[n1.length + n2.length];
        int[] result = new int[n1.length + n2.length];
        
        int tempIndex = 0;
        int digit = 0;
        int carry = 0;
        int p = 0;
        for (int i = n2.length - 1; i >= 0; i--) {
            Arrays.fill(temp, 0);
            tempIndex = n1.length + i;
            digit = (int)(n2[i] - '0');
            for (int j = n1.length - 1; j >= 0; j--) {
                p = ((int)(n1[j] - '0') * digit + carry);
                temp[tempIndex] = (p % 10);
                carry = p / 10;
                tempIndex--;
            }
            if (carry != 0) {
            	temp[tempIndex] = carry;
            }
            addToResult(temp, result, n1.length + i, i);
        }
        
        int begin = 0;
        StringBuffer sb = new StringBuffer();
        while (begin < result.length && result[begin] == 0) {
            begin++;
        }
        while (begin < result.length) {
            sb.append((char)(result[begin] + '0'));
            begin++;
        }
        return sb.toString();
    }
    
    private static void addToResult(int[] temp, int[] result, int right, int left) {
        int carry = 0;
        int sum = 0;
        int i = 0;
        for (i = right; i >= left; i--) {
            sum = temp[i] + result[i] + carry;
            result[i] = sum % 10;
            carry = sum / 10;
        }
//        result[i] = carry;
    }
    
    public static void main(String[] args) {
		String num1 = "9";
		String num2 = "9";
		String result = multiply(num1, num2);
		System.out.println(result);
	}
}
