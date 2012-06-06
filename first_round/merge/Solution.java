package merge;

import java.util.*;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

/**
 * Good Question, merge1() is wrong.
 * It is done by grouping.
 * This is the same as a topcoder problem.
 * Garden Flowers.
 * @author ryan
 *
 */
public class Solution {
    public static ArrayList<Interval> merge1(ArrayList<Interval> intervals) {
        ArrayList<Interval> result = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            return result;
        }

    	Interval A[] = new Interval[intervals.size()];
		A = intervals.toArray(A);
		Arrays.sort(A, new Comparator<Interval>() {

			public int compare(Interval o1, Interval o2) {
				if (o1.end < o2.end) {
					return -1;
				} else if (o1.end > o2.end) {
					return 1;
				} else if (o1.start < o2.start) {
					return -1;
				} else if (o1.start > o2.start) {
					return 1;
				} else return 0;
			}
			
		});
		int j = 0;
		int i = 0;
		int start = A[0].start;
		for (; i < A.length - 1; ) {
			if (A[i].end < A[i+1].start) {
				result.add(new Interval(start, A[i].end));
				start = A[i + 1].start;
				j = i + 1;
			} else {
				start = Math.min(start, A[i + 1].start);
			}
			i++;
		}
		result.add(new Interval(start, A[i].end));
		return result;
	}

	
	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<Interval>();

		Interval i1 = new Interval(1, 3);
		Interval i2 = new Interval(2, 6);
		Interval i3 = new Interval(8, 10);
		Interval i4 = new Interval(15, 18);
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		intervals.add(i4);
		
		ArrayList<Interval> result = merge1(intervals);
		for (Interval in : result) {
			System.out.println("[" + in.start + ", " + in.end + "]");
		}


	}
}
