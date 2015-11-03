Leetcode 143 - Reorder List - 切两段.java

// 在原地操作是无法做到的
// （1）找到中点，然后截成两条链表；
// （2）将后面一条链表reverse；
// （3）将两条链表按顺序依次merge起来。
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null ) return;
        
        //1)找到中点，然后截成两条链表；
        ListNode p1 = head;
        ListNode p2 = head;
        
        while(p2.next!= null && p2.next.next != null){
            p2 = p2.next.next;
            p1 = p1.next;
        }
        //无论 12345 或 123456
        //此时p1都在3，从3后面断开。123/45，123/456
        //p1,p2分别为两段 linkedlist 的起点
        p2 = p1.next;
        p1.next = null;
        ListNode head1 = head;
        
        // （2）将后面一条链表reverse；
        ListNode head2 = reverse(p2);
        
        // （3）将两条链表按顺序依次merge起来。
        while(head1!=null && head2!=null){
            ListNode next = head2.next;
            head2.next = head1.next;
            head1.next = head2;
            head1 = head2.next;
            head2 = next;
        }
    }
    //非递归翻转链表
    public ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}

// 递归翻转链表
public ListNode recursive_reverse(ListNode head) {
    if(head == null || head.next==null)
        return head;
    return recursive_reverse(head, head.next);
}

private ListNode recursive_reverse(ListNode current, ListNode next) {
    if (next == null) return current;
    ListNode newHead = recursive_reverse(current.next, next.next);
    next.next = current;
    current.next = null;
    return newHead;
}
