Leetcode 102 - Binary Tree Level Order Traversal - 树层序遍历.java
维持一个queue，储存每一层的Node
每当遍历到一个Node，将Node的左右结点add到queue中，准备在下层的遍历中使用

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
            return result;
        }
        
        Queue<TreeNode> Q = new LinkedList<TreeNode>();
        Q.offer(root);
        
        while(!Q.isEmpty()) {
            int size = Q.size(); //注意：只有size和新建level这种层级的东西放在for循环外面
            List<Integer> level = new ArrayList<Integer>();
            
            for(int i = 0; i < size; i++) {
                TreeNode curr = Q.poll(); //取点放在for循环limian
                level.add(curr.val);
                
                if(curr.left != null) {
                    Q.offer(curr.left);
                }
                if(curr.right != null) {
                    Q.offer(curr.right);
                }
            }
            result.add(new ArrayList(level));
        }
        return result;
    }
}