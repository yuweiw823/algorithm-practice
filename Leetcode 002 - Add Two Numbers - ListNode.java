//Leetcode 002 - Add Two Numbers - ListNode

public class Solution {
    public static void main (String[] args){
        ListNode p1 = new ListNode(1);
        ListNode header1 = p1;
        p1.next = new ListNode(7);
        p1 = p1.next;
        p1.next = new ListNode(2);
        p1 = p1.next;
        p1.next = new ListNode(3);
        p1 = p1.next;
      
        ListNode p2 = new ListNode(0);
        ListNode header2 = p2;
        p2.next = new ListNode(5);
        p2 = p2.next;
        p2.next = new ListNode(4);
        p2 = p2.next;
      
        ListNode header = addTwoNumbers(header1, header2);
        ListNode pointer = header;
      
        while(pointer != null){
            System.out.print(pointer.val + " ->");
            pointer = pointer.next;
        }
      
    }
  
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num = 0;
        int carry = 0;
        int digit = 0;
        
        if (l1 == null && l2== null) return null;
        
        ListNode p = new ListNode(0);
        ListNode head = p;
        
        while(l1 != null || l2 != null || carry != 0){
            if (l1 == null) l1 = new ListNode(0);
            if (l2 == null) l2 = new ListNode(0);
            
            num = l1.val + l2.val + carry;
            digit = num % 10;
            carry = num / 10;
            
            p.next = new ListNode(digit);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
            
        }
        return head.next;
    }
  
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }
}