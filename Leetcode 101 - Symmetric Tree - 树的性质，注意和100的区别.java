//Leetcode 101 - Symmetric Tree - 树的性质，注意和100的区别.java

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode L, TreeNode R){
        if(L == null && R == null) return true;
        if(L == null || R == null) return false;
        if(L.val != R.val) return false;
        return helper(L.left, R.right) && helper(R.left, L.right);
        //注意这里是 L.left 和 R.right 比较，R.left 和 L.right 比较。
    }

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {x = val;}
    }
}