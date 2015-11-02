Leetcode 141 - Linked List Cycle - 两个指针，不同速度.java

//如果一个LinkedList里有环，那么环必在最尾，顺着list走，最终会在环内不停循环。

public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        
        ListNode p1 = head;
        ListNode p2 = head;
        
        while(p1 != null && p1.next != null){
            p1 = p1.next.next;
            p2 = p2.next;
            if(p1 == p2) return true;
        }
        return false;
    }
}