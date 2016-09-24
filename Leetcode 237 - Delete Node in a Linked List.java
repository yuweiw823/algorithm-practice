Leetcode 237 - Delete Node in a Linked List.java

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void deleteNode(ListNode node) {
        if(node == null) {
            return;
        }
        
        node.val = node.next.val;
        node.next = node.next.next;
    }
}