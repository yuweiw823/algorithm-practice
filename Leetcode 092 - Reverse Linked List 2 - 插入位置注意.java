//Leetcode 092 - Reverse Linked List 2 - 插入位置注意.java

Lintcode 解法：
/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        for (int i = 1; i < m; i++) {
            if(head == null) {
                return null;
            }
            head = head.next;
        }
        
        ListNode perm = head;
        ListNode nodem = head.next;
        ListNode noden = head.next;
        ListNode nnext = noden.next;
        for(int i = m; i < n; i++) {
            if(nnext == null) {
                return null;
            }
            ListNode temp = nnext.next;
            nnext.next = noden;
            noden = nnext;
            nnext = temp;
        }
        
        nodem.next = nnext;
        perm.next = noden;
        
        return dummy.next;
    }
}


 
// 注意：不是交换 m 和 n,是反转 m-n这一段的链表
public class Solution {
    public static void main(String[] args){
        ListNode p1 = new ListNode(1);
        ListNode head = p1;
        p1.next = new ListNode(2);
        p1 = p1.next;
        p1.next = new ListNode(3);
        p1 = p1.next;
        p1.next = new ListNode(4);
        p1 = p1.next;
        p1.next = new ListNode(5);
        p1 = p1.next;
        p1.next = new ListNode(6);
        p1 = p1.next;
      
        ListNode p = reverseBetween(head, 2, 5);
        
        while(p != null){
            System.out.print(p.val + " ->");
            p = p.next;
        }
    }
  
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return head;
        if(m==n) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        
        int i=1;
        while(i<m && pre.next!=null){
            pre = pre.next;
            i++;
        }
        
        ListNode curr = pre.next; //use curr to locate m
        ListNode move = curr.next; //use p1n to locate the node will be inserted
        
        while(i<n && curr.next!=null){
            curr.next = move.next;
            move.next = pre.next;
            pre.next = move;
            
            move = curr.next;
            i++;
        }
        
        return dummy.next;
    }
  
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }
}

// 要翻转2和5之间的数，m=2，n=5，n+1=6
// 0 -> 1 -> 【2】 -> 3 -> 4 -> 5 -> 6
//      pre   curr   move

// 把3插到2的前面
// 0 -> 1 -> 3 -> 【2】 -> 4 -> 5 -> 6
//      pre        curr   move

// 再把4插到3的前面
// 0 -> 1 -> 4 -> 3 -> 【2】 -> 5 -> 6
//      pre             curr   move

// 再把5插到4的前面
// 0 -> 1 -> 5 -> 4 -> 3 -> 【2】 -> 6
//      pre                  curr   move

// 总结，每在curr后面读到一个结点，就把它插入到pre的后面


