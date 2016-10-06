Leetcode 270 - Closest Binary Search Tree Value.java


public class Solution {
    public int closestValue(TreeNode root, double target) {
        if(root == null) {
            return 0;
        }
        
        int result = root.val;
        while(root != null) {
            if(Math.abs(root.val - target) < Math.abs(result - target)) {
                result = root.val;
            }
            root = target < root.val ? root.left : root.right;
        }
        
        return result;
    }
}