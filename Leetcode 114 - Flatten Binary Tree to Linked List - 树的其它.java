Leetcode 114 - Flatten Binary Tree to Linked List - 树的其它.java

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//Recursion
public class Solution {
    private TreeNode lastNode = null;
    
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        
        if(lastNode != null) {
            lastNode.right = root;
            lastNode.left = null;
        }
        
        //PreOrder
        lastNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
        
    }
}

//stack 的方法

public class Solution {
    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
            
            //connect
            node.left = null;
            if(stack.isEmpty()) {
                node.right = null;
            } else {
                node.right = stack.peek();
            }
        }
    }
}