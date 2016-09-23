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
  
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null) {
            return null;
        }
        
        int digit = 0;
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        
        while(l1 != null || l2 != null || carry != 0) {
            if(l1 == null) {
                l1 = new ListNode(0);
            }
            if(l2 == null) {
                l2 = new ListNode(0);
            }
            
            digit = l1.val + l2.val + carry;
            carry = digit / 10;
            digit = digit % 10;
            
            p.next = new ListNode(digit);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        return dummy.next;
    }
}

    
class ListNode{
    int val;
    ListNode next;
    ListNode (int x) {
        val = x;
    }
}