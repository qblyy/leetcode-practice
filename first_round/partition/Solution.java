package partition;

import java.util.Random;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode leftHeader = new ListNode(0);
        ListNode rightHeader = new ListNode(0);
        ListNode l = leftHeader;
        ListNode r = rightHeader;
        
        while (head != null) {
            if (head.val < x) {
                l.next = head;
                l = l.next;
            } else {
                r.next = head;
                r = r.next;
            }
            head = head.next;
        }
        /**
         *  Very Good Question!!!!!
         *  Don't forget to set r.next to null, if do the replacement in place.
         */
        //=====================
        r.next = null;
        //=====================
        l.next = rightHeader.next;
        return leftHeader.next;
        
    }
    
    public static void main(String[] args) {
		int n = 10;
		Random r = new Random();
		ListNode header = new ListNode(0), p = header;
		int i = 0;
		do {
			p.next = new ListNode(r.nextInt(100));
			p = p.next;
			i++;
		} while (i < n);
		Solution test = new Solution();
		//Good Question.
		print(header.next);
		ListNode result = test.partition(header.next, 50);
//		print(header.next);
		print(result);
	}
    
    private static void  print(ListNode n) {
    	System.out.print("[");
    	while (n != null && n.next != null) {
    		System.out.print(n.val + ", ");
    		n = n.next;
    	}
    	if (n != null) {
    		System.out.print(n.val);
    	}
    	System.out.println("]");
    }
}