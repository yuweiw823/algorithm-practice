//Leetcode 082 - Remove Duplicates from Sorted List - 两个pointer.next.java
//加dummy，ifelse

public class Solution {
    public static void main (String[] args){
        ListNode p1 = new ListNode(0);
        ListNode head = p1;
        p1.next = new ListNode(1);
        p1 = p1.next;
        p1.next = new ListNode(2);
        p1 = p1.next;
        p1.next = new ListNode(2);
        p1 = p1.next;
        p1.next = new ListNode(3);
        p1 = p1.next;
        p1.next = new ListNode(4);
        p1 = p1.next;
        p1.next = new ListNode(4);
        p1 = p1.next;
        p1.next = new ListNode(5);
        p1 = p1.next;
      
        ListNode pointer = deleteDuplicates(head);
      
        while(pointer != null){
            System.out.print(pointer.val + " ->");
            pointer = pointer.next;
        }
    }
    
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = head;
        ListNode p2 = dummy;
        
        while(p1!=null){
            while(p1.next != null && p1.next.val == p2.next.val){
                p1 = p1.next;
            }
            if(p2.next == p1){//p2紧跟在p1后，没有duplicate
                p2 = p2.next;
            } else {
                p2.next = p1.next;
            }
            p1 = p1.next;
        }
        return dummy.next;
    }
  
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }
}