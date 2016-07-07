Lintcode 098 - Sort List
//http://www.lintcode.com/en/problem/sort-list/

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

//Merge Sort 方法
public class Solution {
    public ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next !=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if(head1 != null) {
            tail.next = head1;
        } else {
            tail.next = head2;
        }
        return dummy.next;
        
    }
     
    public ListNode sortList(ListNode head) {  
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = findMiddle(head);

        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);

        return merge(left, right);
    }
}

//Quick Sort 伪代码
 function quicksort(q)
     var list less, pivotList, greater
     if length(q) ≤ 1 {
         return q
     } else {
         select a pivot value pivot from q
         for each x in q except the pivot element
             if x < pivot then add x to less
             if x ≥ pivot then add x to greater
         add pivot to pivotList
         return concatenate(quicksort(less), pivotList, quicksort(greater))
     }

//Quick Sort
public class Solution {
    public ListNode findMiddle (ListNode head) {
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public ListNode concat(ListNode left, ListNode middle, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        tail.next = left;
        tail = getTail(tail);  //到每一条的最尾端
        tail.next = middle;
        tail = getTail(tail);  //到每一条的最尾端
        tail.next = right;
        tail = getTail(tail);  //到每一条的最尾端
        
        return dummy.next;
    }
    
    public ListNode getTail(ListNode head) {
        if(head == null) {
            return null;
        }
        
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
    
    public ListNode sortList(ListNode head) {  
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode mid = findMiddle(head);
        
        ListNode leftDummy = new ListNode(0);
        ListNode leftTail = leftDummy;
        ListNode rightDummy = new ListNode(0);
        ListNode rightTail = rightDummy;
        ListNode middleDummy = new ListNode(0); // pivot
        ListNode middleTail = middleDummy;        
        
        while(head != null) {
            if(head.val < mid.val) {
                leftTail.next = head;
                leftTail  = head;
            } else if (head.val > mid.val) {
                rightTail.next = head;
                rightTail = head;
            } else {
                middleTail.next = head;
                middleTail = head;
            }
            head = head.next;
        }
        
        leftTail.next = null;
        middleTail.next = null;
        rightTail.next = null;
        
        ListNode left = sortList(leftDummy.next);
        ListNode right = sortList(rightDummy.next);
        
        return concat(left, middleDummy.next, right);
    }
}



