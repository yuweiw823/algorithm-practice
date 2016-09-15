Lintcode 096 - Partition List.java
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.
Example
Given 1->4->3->2->5->2->null and x = 3,
return 1->2->2->4->3->5->null.
/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;
        
        while(p!=null && p.next!=null){
            if(p.next.val < x){//重构
                if(p==q){
                    p = p.next;
                } else {
                    ListNode nnext = p.next.next;
                    p.next.next = q.next;
                    q.next = p.next;
                    p.next = nnext;
                }
                q = q.next; //q永远stay在小于x的点上，随时准备交换，整个过程以q为主导
            } else {
                p = p.next;
            }
        }
        return dummy.next; //head这个点本身可能已经被换跑了，但dummy.next不会
    }
}
