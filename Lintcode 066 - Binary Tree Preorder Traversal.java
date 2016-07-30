Lintcode 066 -  Binary Tree Preorder Traversal.java
Given a binary tree, return the preorder traversal of its nodes' values.
Example
Given:
    1
   / \
  2   3
 / \
4   5
return [1,2,4,5,3].
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
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;   
        }    
        DFS(result, root);
        return result;
        
    }
    
    public void DFS(ArrayList<Integer> result, TreeNode root) {
        if(root == null) {
            return;
        }
        result.add(root.val);
        DFS(result, root.left);
        DFS(result, root.right);
    }
}
