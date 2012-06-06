package fourSum;
import java.util.*;

public class Solution {
    static class Point{
        int[] A;
        public Point(int a, int b, int c, int d) {
           A = new int[] {a, b, c, d};
           Arrays.sort(A);
        }
        
        
        public ArrayList<Integer> toList() {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < A.length; i++)
                list.add(A[i]);
            return list;
        }
    }
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        
        Arrays.sort(num);
        Set<String> memo = new HashSet<String>();
        
        ArrayList<ArrayList<Integer>> result =
        new ArrayList<ArrayList<Integer>>();
        int l = num.length - 1;
        int sum = 0;
        for (int i = 0; i < num.length - 3; i++) {
            for (int j = i + 1; j < num.length - 2; j++) {
                l = num.length - 1;
                for (int k = j + 1; k < l; ) {
                   sum = num[i] + num[j] + num[k] + num[l];
                   if (sum < target) {
                       k++;
                   } else if (sum > target) {
                       l--;
                   } else {
                       String key = num[i] + "" + num[j] + "" + num[k] + "" + num[l];
                       if (!memo.contains(key)) {
                           memo.add(key);
                           result.add(new Point(num[i], num[j], num[k], num[l]).toList());
                       }
                       k++;
                       l--;
                   }
                }
            }
        }
        return result;
    }
}
