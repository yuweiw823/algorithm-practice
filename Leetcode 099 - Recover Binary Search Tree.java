Leetcode 099 - Recover Binary Search Tree.java

public class Solution {
    public void recoverTree(TreeNode root) {
        List<TreeNode> record = new ArrayList<TreeNode>();
        List<TreeNode> pre = new ArrayList<TreeNode>();
        pre.add(null);
        
        helper(root, record, pre);
        if(record.size()>0){
            int temp = record.get(0).val;
            record.get(0).val = record.get(1).val;
            record.get(1).val = temp;
        }
    }
    
    public void helper(TreeNode root, List<TreeNode> record, List<TreeNode> pre){
        if(root == null) return;
        helper(root.left, record, pre);
        if(pre.get(0) != null && pre.get(0).val > root.val){
            if(record.size()==0){
                record.add(pre.get(0));
                record.add(root);
            }else{
                record.set(1, root);
            }
        }
        pre.set(0, root);
        helper(root.right, record, pre);
    }
}