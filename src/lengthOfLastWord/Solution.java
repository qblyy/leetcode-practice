package lengthOfLastWord;

/**
 * Good Question.
 * Test my basic coding skills.
 * @author ryan
 *
 */
public class Solution {
    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int result = 0;
        int i = len - 1;
        while (s.charAt(i) == ' ') {
            i--;
        }
        while (i >= 0) {
            if (s.charAt(i) != ' ') {
                result++;
            } else {
                break;
            }
            i--;
        }
        return result;
    }
    
    public static void main(String[] args) {
		String s = "        ";//"Today is a nice   day  ";
		int result = lengthOfLastWord(s);
		System.out.println(result);
	}
}