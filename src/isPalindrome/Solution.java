package isPalindrome;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0)
            return true;
        
        int div = 1;
        /**
         * Good Question. Again, difference between > and >=. Off-By-One Problem.
         * 
         * Edit. Actually, it's more than that. There is overflow for multiplication.
         * I have to use division here.
         */
//        while (x > div * 10) {
        /**
         * Very Good Question!
         */
//        while (x >= div * 10) {
        while (x / div >= 10) {
            div *= 10;
        }
        while (x != 0) { // Or while (x >= 10) {
            int mod = x % 10;
            if (mod != x / div) {
                return false;
            }
            x -= (div * mod);
            x /= 10;
            div /= 100;
        }
        return true;
        
    }
    
    public static void main(String[] args) {
		int x = 2147447412;
		Solution test = new Solution();
		boolean result = test.isPalindrome(x);
		System.out.println(result);
	}
}
