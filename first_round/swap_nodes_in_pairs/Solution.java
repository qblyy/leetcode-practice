package swap_nodes_in_pairs;

import util.ListNode;

public class Solution {
    public ListNode swapPairs(ListNode head) {
	ListNode header = new ListNode(0);
	ListNode p = header;
	header.next = head;
	ListNode nextTwo = head;
	while (nextTwo != null && nextTwo.next != null) {
	    p.next = nextTwo.next;
	    nextTwo.next = nextTwo.next.next;
	    p.next.next = nextTwo;
	    p = nextTwo;
	    nextTwo = nextTwo.next;
	}
	return header.next;
    }
}