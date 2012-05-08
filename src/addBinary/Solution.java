package addBinary;



public class Solution {
    public String addBinary(String a, String b) {
        int len = Math.max(a.length(), b.length());
        int[] A = padZeros(a, len);
        int[] B = padZeros(b, len);
          int[] C = new int[len];
        int carry = 0;
        for (int i = A.length - 1; i >= 0; i--) {
        	int sum = A[i] + B[i] + carry;
            if (sum > 1) {
            	carry = 1;
            	C[i] = sum % 2;
            } else {
            	carry = 0;
            	C[i] = sum;
            }
        }
        StringBuffer sb = new StringBuffer();
        if (carry == 1) {
            sb.append(carry);
        }
        for (int i = 0; i < C.length; i++) {
            sb.append(C[i]);
        }
       
       return sb.toString();
    }
    
    private int[] padZeros(String s, int len) {
        int[] S = new int[len];
        int x = s.length();
        int i = 0;
        int base = len - x;
        while (i < base) {
            S[i] = 0;
            i++;
        }
        for (i = 0; i < x; i++) {
            S[i + base] = s.charAt(i) - '0';
        }
        return S;
    }
    
    public static void main(String[] args) {
		String a = "11";
		String b = "1";
		Solution test = new Solution();
		String result = test.addBinary(a, b);
		System.out.println(result);
	}
}