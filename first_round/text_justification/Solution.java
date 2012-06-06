package text_justification;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static ArrayList<String> fullJustify(String[] words, int L) {
	ArrayList<String> result = new ArrayList<String>();
	int length = words.length;
	int index = 0;
	while (index < length) {
	    int i = index;
	    int tmpLen = words[i].length();
	    while (i + 1 < length && tmpLen + 1 + words[i+1].length() <= L) {
		i += 1;
		tmpLen += (1 + words[i].length());
	    }
	    assert tmpLen <= L;
	    StringBuffer sb = new StringBuffer();
	    if (i == index) {
//		int len = words[i].length();
		while (tmpLen < L) {
		    sb.append(' ');
		    tmpLen++;
		}
		result.add(words[i] + sb.toString());
	    }
	    /**
	     * Good Question.
	     * The last line should just be left justified.
	     */
	    else if (i == length - 1) { // We hit the last line.
		for (int j = index; j < i; j++) {
		    sb.append(words[j]);
		    sb.append(' ');
		}
		sb.append(words[i]);
		while (tmpLen < L) {
		    sb.append(' ');
		    tmpLen++;
		}
		result.add(sb.toString());
	    }
	    else {
		int totalSpaces = L - tmpLen + (i - index);
		/**
		 * Good Question.
		 * average could be 1. In that case, cannot divide spaces as evenly as possible.
		 * Use a remainder insead.
		 */
		int quotient = totalSpaces / (i - index);
		int remainder = totalSpaces % (i - index);
		for (int j = index; j < i; j++) {
		    sb.append(words[j]);
		    for (int k = 0; k < quotient; k++) {
			sb.append(' ');
		    }
		    totalSpaces -= quotient;
//		    if (totalSpaces % quotient != 0) {
//			sb.append(' ');
//			totalSpaces--;
//		    }
		    if (remainder != 0) {
		    	sb.append(' ');
		    	remainder--;
		    }
		}
		sb.append(words[i]);
		result.add(sb.toString());
	    }
	    index = i + 1;
	}
	return result;
    }
    
    public static void main(String[] args) {
		String[] words = {
				"This", "is", "an", "example", "of", "text", "justification."
		};
		int L = 16;
		List<String> result = fullJustify(words, L);
		for (int i = 0; i < result.size(); i++) {
			System.out.println("\"" + result.get(i) + "\"");
		}
	}
}