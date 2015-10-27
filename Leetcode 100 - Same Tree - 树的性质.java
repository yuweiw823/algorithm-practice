Leetcode 100 - Same Tree - 树的性质.java

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public class TreeNode{
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x){val = x;}
    }
}