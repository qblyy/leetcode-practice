package reverse;

import java.util.*;

public class Solution {
    public static int reverse(int x) {
        long a = (long)x;
        int base = 10;
        LinkedList<Integer> vector = new LinkedList<Integer>();
        boolean negative = false;
        if (x < 0) {
            negative = true;
            a = -a;
        }
        while (a != 0) {
            vector.addFirst((int)(a % base));
            a /= base;
        }
        long result = 0;
        while (!vector.isEmpty()) {
            result *= base;
            int d = vector.removeLast();
            result += d;
        }
        if (negative) {
            result = -result;
        }
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)result;
    }
    
    public static void main(String[] args) {
		int x = Integer.MAX_VALUE;
		int result = reverse(x);
		System.out.println(result);
	}
}