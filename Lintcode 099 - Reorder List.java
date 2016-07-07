Lintcode 099 - Reorder List
http://www.lintcode.com/en/problem/reorder-list/

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
    public ListNode findMiddle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    public void merge(ListNode head1, ListNode head2) {
        int count = 0;
        ListNode p = new ListNode(0);
        while(head1 != null && head2 != null) {
            if(count % 2 == 0) {
                p.next = head1;
                head1 = head1.next;
            } else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
            count++;
        }
        if(head1 != null) {
            p.next = head1;
        } else {
            p.next = head2;
        }
        
    }
    
    public void reorderList(ListNode head) {  
        if(head == null || head.next == null) {
            return;
        }
        // write your code here
        ListNode mid = findMiddle(head);

        ListNode tail = reverse(mid.next);
        mid.next = null;
        
        merge(head, tail);
        
    }
}
