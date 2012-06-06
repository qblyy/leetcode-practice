package fraction_in_string;

import java.util.*;

/**
 * GQ.
 * The two input numbers N and D can be reduced, using their common prime factors, which can be
 * outsourced to another sub routine.
 *
 */
public class Solution {
	public static String calculate(int N, int D) {
		if (D == 0)
			return "INFINITY";
		int integral = N / D;
		int remainder = N % D;
		if (remainder == 0)
			return Integer.toString(integral);
		Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
		StringBuffer sb = new StringBuffer();
		int index = 0;
		int dividend = remainder * 10;
		int quotient = dividend / D;
		remainder = dividend % D;
		while ((remainder != 0)
				&& (!memo.containsKey(remainder)
//						|| quotient == 0
						)) {
			if (quotient == 0) {
				while (dividend < D) {
					dividend *= 10;
					sb.append(0);
					index++;
				}
				quotient = dividend / D;
				remainder = dividend % D;
				continue;
			}
			memo.put(remainder, index);
			index++;
			sb.append(quotient);
			dividend = remainder * 10;
			quotient = dividend / D;
			remainder = dividend % D;
		}
		if (remainder == 0) {
			sb.append(quotient);
			return Integer.toString(integral) + "." + sb.toString();
		} else {
			int startIndex = memo.get(remainder);
			sb.insert(startIndex, '[');
			sb.append(']');
			return Integer.toString(integral) + "." + sb.toString();
		}
	}

	public static void main(String[] args) {
		int N = 1;
		int D = 10;
		String result = calculate(N, D);
		System.out.println(result);
	}
}
