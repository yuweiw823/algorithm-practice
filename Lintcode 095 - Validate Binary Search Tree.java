Lintcode 095 - Validate Binary Search Tree.java
Given a binary tree, determine if it is a valid binary search tree (BST).
Assume a BST is defined as follows:
•	The left subtree of a node contains only nodes with keys less than the node's key.
•	The right subtree of a node contains only nodes with keys greater than the node's key.
•	Both the left and right subtrees must also be binary search trees.
•	A single node tree is a BST
Example
An example:
  2
 / \
1   4
   / \
  3   5
The above binary tree is serialized as {2,1,4,#,#,3,5} (in level order).
/**
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
    public boolean isValidBST(TreeNode root) {
        // 思路1: Inorder 一遍看是不是升序排列
        // 思路2: Recursive, 左子树是否为BST？右子树是否为BST？
        // 注意这里的大小比较不是和自己的左右node比，而是整棵树拍平了后的左右比。
        // 因此要用 min， max 进行记录
        return DFS(root, null, null); 
    }
    
    public boolean DFS(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && min >= root.val) {
            return false;
        }
        if (max != null && max <= root.val) {
            return false;
        }
        return DFS(root.left, min, root.val) && DFS(root.right, root.val, max);
    }
}
