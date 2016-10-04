Lintcode 094 -  Binary Tree Maximum Path Sum.java
Given a binary tree, find the maximum path sum.
The path may start and end at any node in the tree.
Example
Given the below binary tree:
  1
 / \
2   3
return 6.
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
    public int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    
    public int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        
        //本树的最大path，可以不通过根节点
        max = Math.max(max, root.val + left + right);
        //本树从根节点出发到任何一个节点的最大path，遇到负数立即停止
        return Math.max(0, root.val + Math.max(left, right));
    }
}