Leetcode 206 - Reverse Linked List - 重要.java

For linked list 1->2->3, the reversed linked list is 3->2->1
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

Iterative:  
public class Solution {
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode prev = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        
        return prev;
    }
}

Recursive:
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }
}

0 -> 1 -> 2 -> 3 -> null
               ^
0 -> 1 -> 2 -> 3 <- null
               |
               null

0 -> 1 -> 2 <- 3 <- null
          ^
0 -> 1 -> 2 <- 3 <- null
          |
          null

