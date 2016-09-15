Lintocode 106 - Convert Sorted List to Balanced BST.java
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
Example
               2
1->2->3  =>   / \
             1   3
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
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    private ListNode current; 
     
    public int getSize (ListNode head) {
        int size = 0;
        while(head != null) {
            head = head.next;
            size++;
        }
        return size;
    }
     
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        if(head == null) {
            return null;
        }
        int size;
        current = head;
        size = getSize(head);
        return DFSHelper(size);
    }
    
    public TreeNode DFSHelper(int size) {
        if (size <= 0) {
            return null;
        }
        
        TreeNode left = DFSHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = DFSHelper((size+1) / 2 - 1);
        
        root.left = left;
        root.right = right;
        
        return root;
        
    } 
}
