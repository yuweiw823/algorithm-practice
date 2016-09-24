//Leetcode 024 - Swap Nodes in Pairs - 3pointers.java

public class Solution {
    public static void main(String[] agrs){
        ListNode p1 = new ListNode(0);
        ListNode head = p1;
        p1.next = new ListNode(1);
        p1 = p1.next;
        p1.next = new ListNode(2);
        p1 = p1.next;
        p1.next = new ListNode(3);
        p1 = p1.next;
        p1.next = new ListNode(4);
        p1 = p1.next;
        
        
        ListNode p = swapPairs(head.next);
      
        while(p != null){
            System.out.print(p.val + "->");
            p = p.next;
        }
    }
  
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode curr = head;
        dummy.next = head;
        
        while(curr != null && curr.next != null) {
            ListNode p = curr.next;
            curr.next = p.next;
            pre.next = p;
            p.next = curr;
            
            pre = curr;
            curr = curr.next;
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
