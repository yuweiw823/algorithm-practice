Leetcode 160 - Intersection of Two Linked Lists.java

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        ListNode p1 = headA;
        ListNode p2 = headB;
        
        int count1 = 0;
        while(p1 != null){
            p1 = p1.next;
            count1++;
        }
        int count2 = 0;
        while(p2 != null){
            p2 = p2.next;
            count2++;
        }        
        
        p1 = headA;
        p2 = headB;
        
        while(count1!=count2){
            while(count1>count2){
                p1 = p1.next;
                count1--;
            }
            while(count1<count2){
                p2 = p2.next;
                count2--;
            }
            if(count1 == count2) break;
        }
        
        while(p1!=null && p2!=null){
            if(p1 == p2) {
                return p1;
            }
            else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return null;
        
    }
}