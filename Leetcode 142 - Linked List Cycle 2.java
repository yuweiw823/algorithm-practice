Leetcode 142 - Linked List Cycle 2.java


public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        // 注意这里 p1 p2 的起始点，否则步数不对。
        ListNode p1 = head.next.next;  //the runner
        ListNode p2 = head.next;        //the walker

        while(p1!=null && p2!=null && p1!=p2){
            if(p1.next != null) p1 = p1.next.next;
            else return null;
            p2 = p2.next;
        }
        if(p1 == null) return null;  //没有 cycle

        p1 = head;
        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}

Lintcode //

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
