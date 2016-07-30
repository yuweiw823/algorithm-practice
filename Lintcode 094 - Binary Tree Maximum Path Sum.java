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
// public class Solution {
//     /**
//      * @param root: The root of binary tree.
//      * @return: An integer.
//      */
//     //不是将整棵树的node都加起来的意思，而是在树的path之间随意走，找到一条最max的路径
//     public int maxPathSum(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }
//         int left = maxPathSum(root.left);
//         int right = maxPathSum(root.right);
//         return left + right + root.val;
//     }
// }

public class Solution {
    int max = Integer.MIN_VALUE; //这里的max是一个全局变量
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(max, root.val + left + right);
        return Math.max(0, root.val + Math.max(left, right));
    }
}
