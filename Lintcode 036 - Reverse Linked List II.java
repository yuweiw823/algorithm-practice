Lintcode 036 - Reverse Linked List II.java
Reverse a linked list from position m to n.
Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
Example
Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
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
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        for (int i = 1; i < m; i++) {
            if(head == null) {
                return null;
            }
            head = head.next;
        }
        
        ListNode perm = head;
        ListNode nodem = head.next;
        ListNode noden = head.next;
        ListNode nnext = noden.next;
        for(int i = m; i < n; i++) {
            if(nnext == null) {
                return null;
            }
            ListNode temp = nnext.next;
            nnext.next = noden;
            noden = nnext;
            nnext = temp;
        }
        
        nodem.next = nnext;
        perm.next = noden; 
        return dummy.next;
        
    }
}
