//Leetcode 083 - Remove Duplicates from Sorted List 2 - 两个pointer.next.java
//加dummy

public class Solution {
    public static void main (String[] args){
        ListNode p1 = new ListNode(1);
        ListNode head = p1;
        p1.next = new ListNode(1);
        p1 = p1.next;
        p1.next = new ListNode(2);
        p1 = p1.next;
        p1.next = new ListNode(2);
        p1 = p1.next;
        p1.next = new ListNode(2);
        p1 = p1.next;
        p1.next = new ListNode(3);
        p1 = p1.next;
        p1.next = new ListNode(3);
        p1 = p1.next;
        p1.next = new ListNode(3);
        p1 = p1.next;
      
        ListNode pointer = deleteDuplicates(head);
      
        while(pointer != null){
            System.out.print(pointer.val + " ->");
            pointer = pointer.next;
        }
    }
    //自己的思路：试图用一个指针是不行的，会出现这种状况：
    //Input: 1->2->2->2->3->3->3
    //Output: 1->2->2->3->3
    //会有残留
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        
        while(p.next!=null){
            if(p.val == p.next.val){
                p.next = p.next.next;
            }
            p = p.next;
        }
        return head;
    }

    //必须使用两个指针才能完成
    //两个指针：依旧是不 work 的解法
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode p1 = head;  //p1完全承担了检查的所有任务
        ListNode p2 = head;  //p2仅用于链接新List
        
        while(p1.next!=null){
            while(p1.val == p1.next.val){  //在这一步会出现问题，当p1走到最后一步时，
                                           //p.next==null，无法取得val，导致报错
                if(p1.next.next != null)
                p1 = p1.next;
            }
            if(p1.next != null)p1 = p1.next;
            p2.next = p1;
            p2 = p2.next;
        }
        return head;
    }

    //必须使用两个指针才能完成
    //创建一个duumy Node(0),
    // 0 -> 1 -> 1 -> 2 -> 2 -> 2 -> 3 -> 3 -> 3
    // p2   p1
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = head;
        ListNode p2 = dummy;
      
        while(p1!=null){
            while(p1.next!=null && p1.next.val == p2.next.val){ //注意比较的是next的值
                p1 = p1.next;
            }
            p2.next = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return dummy.next;
    }


  
    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }
}