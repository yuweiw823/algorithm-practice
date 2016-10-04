//Leetcode 101 - Symmetric Tree - 树的性质，注意和100的区别.java

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        
        return DFS(root.left, root.right);
    }
    
    public boolean DFS(TreeNode L, TreeNode R) {
        if(L == null && R == null) {
            return true;
        }
        
        if(L == null || R == null) {
            return false;
        }
        
        if(L.val != R.val) {
            return false;
        }
        
        return DFS(L.right, R.left) && DFS(L.left, R.right);
    }
}