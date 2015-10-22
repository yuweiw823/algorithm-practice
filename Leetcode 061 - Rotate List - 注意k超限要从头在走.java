//Leetcode 060 - Rotate List - 注意k超限要从头在走.java

public class Solution {
    public static void main (String[] args){
        ListNode p1 = new ListNode(1);
        ListNode header1 = p1;
        p1.next = new ListNode(2);
        p1 = p1.next;
        p1.next = new ListNode(3);
        p1 = p1.next;
        p1.next = new ListNode(4);
        p1 = p1.next;
        p1.next = new ListNode(5);
        p1 = p1.next;

        ListNode header = rotateRight(header1, 2);
        ListNode pointer = header;
      
        while(pointer != null){
            System.out.print(pointer.val + " ->");
            pointer = pointer.next;
        }
      
    }
  
    public static ListNode rotateRight(ListNode head, int k) {
        //head == ListNode(1), not a dummy
        if(head == null) return head;
        ListNode p1 = head;
        ListNode p2 = head;
        
        int i=0;
        while(i<k && p1 != null){
            p1 = p1.next;
            i++;
        }
        
        if(p1 == null) { //如果到头，则从头再循环
            k = k % i;
            p1 = head;
            //从头再走一遍
            i=0;
            while(i<k && p1 != null){
                p1 = p1.next;
                i++;
            }
        }
        
        while(p1.next!=null){ //注意p1 stops 在最后的条件是 p1.next != null
            p1 = p1.next;  //p1 stops at 5
            p2 = p2.next;  //p2 stops at 3
        }

        p1.next = head;             //p1(5) points to head
        ListNode newHead = p2.next; //new head points to 4
        p2.next = null;             //p2(3) points to null
        
        return newHead;
    }
  
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }
}