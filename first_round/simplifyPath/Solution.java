package simplifyPath;

import java.util.*;

public class Solution {
    public static String simplifyPath(String path) {
        if (path == null || path.isEmpty()) {
            return path;
        }
        String separator = "/";

        String[] paths = path.split(separator);
        LinkedList<String> stack = new LinkedList<String>();
        for (String dir : paths) {
        	/**
        	 * Good Question. Calling split("/") on "/home/" yields String[]{"", "home"}, not the expected {"home"}.
        	 * So check if empty.
        	 * Also,
        	 * Did you consider the case where path = "/../"?
			 * In this case, you should return "/".
			 * 
			 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
			 * In this case, you should ignore redundant slashes and return "/home/foo".
        	 */
        	if (dir.isEmpty()) {
        		continue;
        	} else
            if (dir.equals(".")) {
                continue;
            } else if (dir.equals("..")) {
                if (!stack.isEmpty()) { // Good practice!!
                    stack.removeFirst();
                }
            } else {
                stack.addFirst(dir);
            }
        }
        StringBuffer sb = new StringBuffer();
        //sb.append(sperator);
        while (!stack.isEmpty()) {
           sb.append(separator);
           /**
            * Good Question.
            * Here, it should act like a queue, not a stack.
            */
           //sb.append(stack.removeFirst());
           sb.append(stack.removeLast());
        }
        
        /**
         * Good Question. StringBuffer doesn't have a isEmpty() method. Call length() instead.
         */
//        if (sb.isEmpty()) {
        if (sb.length() == 0) {
            sb.append(separator);
        }
        return sb.toString();
    }

    
    public static void main(String[] args) {
		String path = 
//				"/home/"
				"/a/./b/../../c/"
				;
		String result = simplifyPath(path);
		System.out.println(result);
	}
}