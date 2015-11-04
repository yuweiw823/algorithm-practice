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
  
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
      
        ListNode prev = dummy;  //prev 用来记录前一个 Node，用于把0指向换位后的2
        ListNode p1 = head;
        
        while(p1 != null && p1.next != null){   //p1记录1
            ListNode p2 = p1.next;              //p2记录2
            p1.next = p2.next;                  //1指向3
            p2.next = p1;                       //2指向1
          
            prev.next = p2;                     //0指向2   0->2->1->3->4
            prev = p1;                          //prev 记录 1
            
            if (p1.next!=null) p1 = p1.next;
        }
        
        return dummy.next;  //dummy 用于最后传递0
    } 
  
}
    
class ListNode{
    int val;
    ListNode next;
    ListNode (int x) {
        val = x;
    }
}
