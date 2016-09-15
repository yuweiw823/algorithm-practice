Lintcode 103 - Linked List Cycle II.java
Given a linked list, return the node where the cycle begins.
If there is no cycle, return null.
Example
Given -21->10->4->5, tail connects to node index 1，return 10
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
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
        if (head == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != slow) {
            if(fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        
        fast = head;
        
        while(fast != slow.next) {
            fast = fast.next;
            slow = slow.next;
        }
        
        return fast; 
    }
}
