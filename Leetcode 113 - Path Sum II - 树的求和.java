Leetcode 113 - Path Sum II - 树的求和.java


public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        List<Integer> item = new ArrayList<Integer>();
        item.add(root.val);
        helper(root, sum-root.val, item, res);
        return res;
    }
    
    public void helper(TreeNode root, int sum, List<Integer> item, List<List<Integer>> res){
        if(root == null) return;
        if(root.left == null && root.right == null && sum == 0){
            res.add(new ArrayList<Integer>(item));
            return;
        }
        if(root.left != null){
            item.add(root.left.val);
            helper(root.left, sum-root.left.val, item, res);
            item.remove(item.size()-1);
        }
        if(root.right != null){
            item.add(root.right.val);
            helper(root.right, sum-root.right.val, item, res);
            item.remove(item.size()-1);
        }
    }
}