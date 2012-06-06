package divide;

public class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 0;
        if ((dividend > 0 && divisor < 0)
            ||
            (dividend < 0 && divisor > 0)) {
            sign = 1;
        }
        long dividend1 = Math.abs((long)dividend);
        long divisor2 = Math.abs((long)divisor);
        long result = div(dividend1, divisor2);
        if (sign == 1) {
            result = -result;
        }
        return (int)result;
    }
    
    private long div(long tempDividend, long tempDivisor) {
        long tmp = tempDivisor;
        long quotient = 1;
        if (tempDividend == tempDivisor) {
            return 1;
        }
        if (tempDividend < tempDivisor) {
            return 0;
        }
        while (tempDivisor < tempDividend) {
            tempDivisor <<= 1;
            quotient <<= 1;
        }
        
        tempDivisor >>= 1;
        quotient >>= 1;
        
        return quotient + div(tempDividend - tempDivisor, tmp);
    }
    
    public static void main(String[] args) {
		int dividend = Integer.MIN_VALUE;
		int divisor = 2;
		Solution test = new Solution();
		int result = test.divide(dividend, divisor);
		System.out.println(result);
	}
}
