package zigzag_conversion;

public class Solution {
    public static String convert(String text, int nRows) {
	if (text.length() <= nRows) {
	    return text;
	}
	/**
	 * Important case.
	 */
	//===============================
	if (nRows <= 1) 
			return text;
	//===============================
	StringBuffer[] buffers = new StringBuffer[nRows];
	for (int i = 0; i < nRows; i++) {
	    buffers[i] = new StringBuffer();
	}
	/**
	 * Good Question.
	 * NegativeArraySizeException.
	 */
	int len = (nRows - 1) << 1;
	int[] indexes = new int[len];
	int k = 0;
	for (;k < nRows; k++)
	    indexes[k] = k;
	for (; k < len; k++) 
	    indexes[k] = len - k;

	for (int i = 0; i < text.length(); i++) {
	    int index = i % len;
	    buffers[indexes[index]].append(text.charAt(i));
	}
	String s = "";
	for (int i = 0; i < nRows; i++) {
	    s += buffers[i].toString();
	}
	return s;
    }

    public static void main(String... args) {
	String text = "PAYPALISHIRING";
	int totalRows = 5;
	for (int i = 0; i < totalRows; i++) {
	    String s = convert(text, i);
	    System.out.println("With " + i + " rows, the result is " + s);
	}
    }
}