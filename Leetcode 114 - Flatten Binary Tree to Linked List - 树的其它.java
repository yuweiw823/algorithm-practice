Leetcode 114 - Flatten Binary Tree to Linked List - 树的其它.java

public class Solution {
    public void flatten(TreeNode root) {
        List<TreeNode> pre = new ArrayList<TreeNode>();
        pre.add(null);
        dfs(root, pre);
    }
    
    public void dfs(TreeNode root, List<TreeNode> pre){
        if(root == null) return;
        TreeNode right = root.right;  // 其实就是先序遍历，但每次都先保存好右子树
        if(pre.get(0) != null){//然后使用pre来存储前一个结点
            pre.get(0).left = null;
            pre.get(0).right = root;
        }
        pre.set(0, root);
        dfs(root.left, pre);
        dfs(right, pre);
    }
}