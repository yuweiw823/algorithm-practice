Leetcode 124 - Binary Tree Maximum Path Sum - 树的求和(无向图).java

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
        //本树从根节点出发到任何一个节点的最大path.
        return Math.max(0, root.val + Math.max(left, right));
    }
}
