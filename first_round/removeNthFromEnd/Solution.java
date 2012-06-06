package removeNthFromEnd;

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
	public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 0) {
            return  head;
        }
        /**
         * Good Question. l could be zero if ListNode head is null. Need a check on that.
         */
        //=============
        if (head == null) {
        	return head;
        }
        //=============
        int l = length(head);
        int k = n % l;
        if (k == 0) {
            return head;
        }
        ListNode p = head;
        while (k > 0 && p != null) {
            p = p.next;
            k--;
        }
        if (p == null) {
            return head;
        }
        ListNode h = head;
        while (p != null && p.next != null) {
            h = h.next;
            p = p.next;
        } 
        ListNode newHead = h.next;
        h.next = null;
        p.next = head;
        return newHead;
    }
    
    private static int length(ListNode n) {
        int l = 0;
        while (n != null) {
            l++;
            n = n.next;
        }
        return l;
    }
    
    private static void print(ListNode n) {
    	System.out.print("{");
    	while (n != null && n.next != null) {
    		System.out.print(n.val + ", ");
    		n = n.next;
    	}
    	if (n != null) {
    		System.out.print(n.val);
    	}
    	System.out.println("}");
    }
    
    public static void main(String[] args) {
		ListNode head = null;
//				new ListNode(1);
//		head.next = new ListNode(2);
		int n = 5;
		print(head);
		ListNode result = removeNthFromEnd(head, n);
		print(result);
		
	}
}