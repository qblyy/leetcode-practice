package mergeTwoLists;

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        
        ListNode head = null;
        ListNode c1 = l1;
        ListNode c2 = l2;
        if (l1.val > l2.val) {
            head = l2;
            c2 = c2.next;
        } else {
            head = l1;
            c1 = c1.next;
        }
        ListNode p = head;
        
        
        while (c1 != null || c2 != null) {
            if (c1 != null && c2 != null) {
                if(c1.val < c2.val) {
                    p.next = c1;
                    c1 = c1.next;
                } else {
                    p.next = c2;
                    c2 = c2.next;
                }
                p = p.next;
            } else if (c1 == null) {
                p.next = c2;
                break;
            } else if (c2 == null) {
                p.next = c1;
                break;
            }
        }
        return head;
    }
}