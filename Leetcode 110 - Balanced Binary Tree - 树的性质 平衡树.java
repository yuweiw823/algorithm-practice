Leetcode 110 - Balanced Binary Tree - 平衡树.java
An empty tree is height-balanced. A non-empty binary tree T is balanced if:
1) Left subtree of T is balanced
2) Right subtree of T is balanced
3) The difference between heights of left subtree and right subtree is not more than 1.

维护一个值：
>=0 : 层数
-1  : 不balanced

public class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root) >= 0;
    }

    public int helper(TreeNode root){
        if(root == null) return 0;
        int L = helper(root.left);
        int R = helper(root.right);
        if(Math.abs(L-R) > 1) return -1;
        if(L < 0 || R < 0) return -1;     //重要！！！
        return Math.max(L, R)+1;
    }

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){val = x;}
    }
}