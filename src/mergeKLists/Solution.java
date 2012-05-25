package mergeKLists;

/**
 * Good Question. I did not pass the online tests.
 */
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

import java.util.Random;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Comparator;
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}
class Wrapper implements Comparable<Wrapper>{
    ListNode node;
    int index;
    public Wrapper(ListNode n, int index) {
        this.node = n;
        this.index = index;
    }
    
    public int compareTo(Wrapper r) {
        if (node.val > r.node.val) {
            return 1;
        } else if (node.val < r.node.val) {
            return -1;
        } else {
            return 0;
        }
    }
}

public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        if (lists == null || lists.size() == 0) {
            return null;
        }
        int n = lists.size();
        
        TreeSet<ListNode> heap = new TreeSet<ListNode>(new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                if (n1.val > n2.val) {
                	return 1;
                } else if (n1.val < n2.val) {
                	return -1;
                } else {
                	/*
                	 * Here was seriously wrong.
                	 */
                	//return 0;
                    	if (n1 == n2) {
                            return 0;   
                    	} else {
                         return 1;   
                    	}
                }
            }
        });
        
        for (int i = 0; i < n; i++) {
        	ListNode node = lists.get(i);
        	if (node != null) {
        		heap.add(node);
        	}
        }
       
        while (!heap.isEmpty()) {
            ListNode min = heap.first();
            heap.remove(heap.first());
            if (min.next != null) {
                heap.add(min.next);
            }
            p.next = new ListNode(min.val);
            p = p.next;
        }
        return head.next;
    }
    
    public static void main(String[] args) {
		Solution test = new Solution();
		int n = 5;
		ListNode l1 = new ListNode(5);
		ListNode p = l1;
		Random r = new Random();
		for (int i = 0; i < 2 * n; i++) {
			p.next = new ListNode(p.val + r.nextInt(10));
			p = p.next;
		}
		ListNode l2 = new ListNode(10);
		p = l2;
		for (int i = 0; i < n; i++) {
			p.next = new ListNode(p.val + r.nextInt(10));
			p = p.next;
		}
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		lists.add(l1);
		lists.add(l2);
		ListNode result = test.mergeKLists(lists);
		print(l1);
		print(l2);
		print(result);
	}
    
    private static void print(ListNode n) {
    	if (n == null) {
    		System.out.println("n is null.");
    	}
    	System.out.print("(");
    	while (n != null && n.next != null) {
    		System.out.print(n.val + ",");
    		n = n.next;
    	}
    	if (n != null) {
    		System.out.print(n.val + ")");
    	}
    	System.out.println();
    }
}
