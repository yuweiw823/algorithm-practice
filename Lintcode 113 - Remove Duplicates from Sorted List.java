Lintocode 113 - Remove Duplicates from Sorted List II.java
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinctnumbers from the original list.
Example
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 
/**
 * Definition for ListNode
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
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        ListNode dummy = new ListNode(0);
        ListNode p1 = head;
        ListNode p2 = dummy;
        dummy.next = head;
        
        while(p1 != null) {
            while(p1.next != null && p1.next.val == p2.next.val) {
                p1 = p1.next;
            }
            if(p2.next == p1) {
                p2 = p2.next;
            } else {
                p2.next = p1.next;
            }
            p1 = p1.next;
        }
        return dummy.next;
    }
}
