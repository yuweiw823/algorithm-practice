//Leetcode 021 - Merge Two Sorted Lists - LinkedList 1p.java

//用一个指针互相在l1,l2之间连就可以
//先 initial dummy，再 initial p

public class Solution {
    public static void main(String[] args){
        ListNode head1 = new ListNode(0);
        ListNode l1 = head1;
        l1.next = new ListNode(1);
        l1 = l1.next;
        l1.next = new ListNode(2);
        l1 = l1.next;
        l1.next = new ListNode(4);
        l1 = l1.next;
        l1.next = new ListNode(5);
        l1 = l1.next;
      
        ListNode head2 = new ListNode(0);
        ListNode l2 = head2;
        l2.next = new ListNode(3);
        l2 = l2.next;
        l2.next = new ListNode(3);
        l2 = l2.next;
        l2.next = new ListNode(6);
        l2 = l2.next;
        l2.next = new ListNode(7);
        l2 = l2.next;
      
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        p.next = mergeTwoLists(head1.next, head2.next);
        p = p.next;
        
        while(p != null){
            System.out.print(p.val + "=>");
            p = p.next;
        }
      
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
      
        while(l1 != null && l2 != null){   //注意这里是 && 
            if(l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        
        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;
      
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