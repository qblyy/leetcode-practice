package addTwoNumbers;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
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
	

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sum = 0, carry = 0;
        ListNode x = new ListNode(0);
        ListNode head = x;
        while (l1 != null || l2 != null || carry == 1) {
            if (l1 != null && l2 != null) {
                sum = l1.val + l2.val + carry;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null && l2 != null) {
                sum = l2.val + carry;
                l2 = l2.next;
            } else if (l2 == null && l1 != null) {
                sum = l1.val + carry;
                l1 = l1.next;
            } else {
                sum = carry;
            }
            x.val = (sum % 10);
            carry = sum / 10;
            if (l1 == null && l2 == null && carry == 0) {
                break;
            }
            x.next = new ListNode(0);
            x = x.next;
        }
        return head;
    }
	 
	 public static void main(String[] args) {
		ListNode l1 = new ListNode(5), h1 = l1;
		ListNode l2 = new ListNode(5), h2 = l2;
		
//		l1.next = new ListNode(4);
//		l2.next = new ListNode(6);
		
		Solution test = new Solution();
		ListNode result = test.addTwoNumbers(h1, h2);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
		
	}
}