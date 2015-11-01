Leetcode 124 - Binary Tree Maximum Path Sum - 树的求和(无向图).java


这道题的写法非常tricky。以下是一种比较清晰的写法。但设定全局变量不是一个好的编程习惯。
public class Solution {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    
    public int dfs(TreeNode root){
        if(root == null) return 0;
        int lmax = dfs(root.left);
        int rmax = dfs(root.right);
        max = Math.max(max, root.val + lmax + rmax);
        return Math.max(0, root.val + Math.max(lmax, rmax));
    }
}

比较符合编程规范的写法：使用一个 list 来存
public class Solution {
    public int maxPathSum(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return 0;
        res.add(Integer.MIN_VALUE);
        dfs(root, res);
        return res.get(0);
    }
    
    public int dfs(TreeNode root, List<Integer> res){
        if(root == null) return 0;
        int lmax = dfs(root.left, res);
        int rmax = dfs(root.right, res);
        int cur = Math.max(res.get(0), root.val + lmax + rmax);
        res.set(0, cur);
        return Math.max(0, root.val + Math.max(lmax, rmax));
    }
}
