Leetcode 142 - Linked List Cycle 2.java


public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        // 注意这里 p1 p2 的起始点，否则步数不对。
        ListNode p1 = head.next.next;  //the runner
        ListNode p2 = head.next;        //the walker

        while(p1!=null && p2!=null && p1!=p2){
            if(p1.next != null) p1 = p1.next.next;
            else return null;
            p2 = p2.next;
        }
        if(p1 == null) return null;  //没有 cycle

        p1 = head;
        while(p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}