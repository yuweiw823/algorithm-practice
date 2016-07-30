Lintcode 069 - Binary Tree Level Order Traversal.java
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
Example
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
 
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        //用一个queue存储所有的Node。
        if(root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();
            //后面有poll操作，所以queue.size()会变，这里先存下来
            int size = queue.size(); 
            for(int i = 0; i < size; i++){
                TreeNode currNode = queue.poll();
                level.add(currNode.val);
                if (currNode.left != null) {
                    queue.offer(currNode.left);	
                }
                if (currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}
