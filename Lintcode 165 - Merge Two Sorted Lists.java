Lintcode 165 - Merge Two Sorted Lists.java
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param ListNode l1 is the head of the linked list
     * @param ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
    	if(l1 == null && l2 == null) {
    		return null;
    	}

    	if(l1 == null) {
    		return l2;
    	}

    	if(l2 == null) {
    		return l1;
    	}

        ListNode tail;
		if(l1.val < l2.val) {
			tail = l1;
			l1 = l1.next;
		} else {
			tail = l2;
			l2 = l2.next;
		}

        ListNode dummy = new ListNode(0);
        dummy.next = tail;


        while(l1 != null && l2 != null) {
        	if(l1.val <= l2.val) {
        		tail.next = l1;
        	 	l1 = l1.next;
        	} else {
        		tail.next = l2;
        	 	l2 = l2.next;
        	}
        	tail = tail.next;
        }

        if(l1 != null) {
        	tail.next = l1;
        }

        if(l2 != null) {
        	tail.next = l2;
        } 

        return dummy.next;
    }
}
