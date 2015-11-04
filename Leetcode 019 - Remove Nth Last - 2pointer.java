//Leetcode 019 - Remove Nth Node From End of List
import java.util.*;

//两个指针，一个p1先走n步，然后两个一起走，p2定位。

public class Solution {
    public static void main(String[] args){
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
        
        ListNode p = removeNthFromEnd(head, 3);
      
        while(p != null){
            System.out.println(p.val + "->");
            p = p.next;
        }
    }
    
    //
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;

        while(n>0 && p1 != null){
            p1 = p1.next;
            n--;
        }
        
        if(p1==null) return head.next;  //注意此时需要加判断条件！
        
        while(p1 != null){//注意，p1可以走到null
            p1 = p1.next;
            p2 = p2.next;
        }
        //Now p2 should be on the (N-1) last ListNode
        p2.next = p2.next.next;
        return head;
    }
}

    
class ListNode{
    int val;
    ListNode next;
    ListNode (int x) {
        val = x;
    }
}