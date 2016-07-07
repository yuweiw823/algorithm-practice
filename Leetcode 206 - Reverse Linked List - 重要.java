Leetcode 206 - Reverse Linked List - 重要.java

方法1：iterative
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

方法2：recursive
public class Solution {
    public static void main(String[] args){
        ListNode p1 = new ListNode(1);
        ListNode head = p1;
        ListNode p2 = new ListNode(2);
        p1.next = p2;
        ListNode p3 = new ListNode(3);
        p2.next = p3;
        ListNode p4 = new ListNode(4);
        p3.next = p4;
        
        ListNode p = reverseList(head);
      
        while(p!=null){
            System.out.print(p.val + "->");
            p = p.next;
        }
        
    }
    
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        return recursiveReverse(head, head.next);
    }
    
    public static ListNode recursiveReverse(ListNode cur, ListNode next){
        if(next == null) return cur;
        ListNode newHead = recursiveReverse(cur.next, next.next);
        next.next = cur;
        cur.next = null;
        return newHead;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}

1->2 ->3 ->4 ->5
(1,2)
    (2,3)
        (3,4)
            (4,5)
                (5, null)
                5(newHead)
            4<-5
         3<-4
     2<-3
 1<-2
 return newHead(5);