Leetcode 129 - Sum Root to Leaf Numbers.java


public class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return helper(root, 0);
    }
    
    public int helper(TreeNode root, int sum){
        if(root == null) return 0;
        if(root.left == null && root.right == null) return sum*10 + root.val;
        return helper(root.left, sum*10+root.val) + helper(root.right, sum*10+root.val);
    }
}