package threeSum;

import java.util.*;

public class Solution {
    static class Point {
        int[] A;
        public Point(int a, int b, int c) {
            A = new int[]{a, b, c};
            Arrays.sort(A);
        }
        
        public boolean equals(Object obj) {
            if (! (obj instanceof Point))
                return false;
            Point p = (Point)obj;
            for (int i = 0; i < A.length; i++) {
                if (A[i] != p.A[i])
                    return false;
            }
            return true;
        }
        
        public int hashCode() {
            int sum = 0;
            int fact = 1;
            for (int i = 0; i < A.length; i++) {
                sum += A[i] * fact;
                fact *= 10;
            }
            return sum;
        }
        
        public ArrayList<Integer> toList() {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < A.length; i++)
                list.add(A[i]);
            return list;
        }
    }
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
       Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
       Set<Point> set = new HashSet<Point>();
       for (Integer i : num) {
           if (memo.containsKey(i)) {
               memo.put(i, memo.get(i) + 1);
           } else {
               memo.put(i, 1);
           }
       }
       int sum = 0;
       for (int i = 0; i < num.length; i++) {
           memo.put(num[i], memo.get(num[i]) - 1);
           for (int j = i + 1; j < num.length; j++) {
               memo.put(num[j], memo.get(num[j]) - 1);
               sum = 0 - num[i] - num[j];
               if (memo.containsKey(sum) && memo.get(sum) > 0) {
                   set.add(new Point(num[i], num[j], sum));
               }
               memo.put(j, memo.get(j) + 1);
           }
           memo.put(i, memo.get(i) + 1);
       }
       
       ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
       for (Point i : set) {
           list.add(i.toList());
       }
       return list;
    }

    
    public static void main(String[] args) {
		int[] num = new int[]{-1, 0, 1, 2, -1, -4};
		Solution test = new Solution();
		test.threeSum(num);
	}
}
