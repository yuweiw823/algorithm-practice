Leetcode 160 - Intersection of Two Linked Lists.java

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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        
        int countA = 0;
        ListNode p = headA;
        while(p != null) {
            p = p.next;
            countA++;
        }
        
        int countB = 0;
        p = headB;
        while(p != null) {
            p = p.next;
            countB++;
        }
        
        int diff;
        ListNode fast;
        ListNode slow;
        if(countA > countB){
            diff = countA - countB;
            fast = headA;
            slow = headB;
        } else {
            diff = countB - countA;
            fast = headB;
            slow = headA;
        }
        
        while(diff > 0) {
            fast = fast.next;
            diff--;
        }
        
        while(fast != null && slow != null) {
            if(fast != slow) {
                fast = fast.next;
                slow = slow.next;
            } else {
                return fast;
            }
        }
        
        return null;
    }
}