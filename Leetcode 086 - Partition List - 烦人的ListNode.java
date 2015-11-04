//Leetcode 086 - Partition List - 烦人的ListNode.java

public class Solution {
    public static void main (String[] args){
        ListNode p1 = new ListNode(1);
        ListNode head = p1;
        p1.next = new ListNode(4);
        p1 = p1.next;
        p1.next = new ListNode(3);
        p1 = p1.next;
        p1.next = new ListNode(2);
        p1 = p1.next;
        p1.next = new ListNode(5);
        p1 = p1.next;
        p1.next = new ListNode(2);
        p1 = p1.next;
        p1.next = new ListNode(1);
        p1 = p1.next;
        p1.next = new ListNode(6);
        p1 = p1.next;
      
        ListNode pointer = partition(head, 3);
      
        while(pointer != null){
            System.out.print(pointer.val + " ->");
            pointer = pointer.next;
        }
    }
//所有val<=3的Node都一定在3前面，val>3的可能在3前面，可能在3后面
//遇到<3的结点，直接把其调换到前面(原地操作，不需开新的list)，对于>3的结点，不需处理。
//需要用到两个pointer，一前一后操作数组的，p1在前面找到<3的结点，p2始终 stay 在3之前的节点上，随时准备连到p1找到的点
//使用.next.val 进行比较的，一般都会开一个dummy
    public static ListNode partition(ListNode head, int x) {
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
  
class ListNode{
    int val;
    ListNode next;
    ListNode (int x) {
        val = x;
    }
}