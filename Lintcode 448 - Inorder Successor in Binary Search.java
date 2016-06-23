Lintcode 448 - Inorder Successor in Binary Search Tree
     4
   /   \
  2     6
 / \   /  \
1   3 5    8
          / \
         7   9

试一下3、6、7三个Node，就能理解算法。
http://www.jiuzhang.com/solutions/inorder-successor-in-binary-search-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // write your code here
        TreeNode successor = null;
        while(root != null && root != p) { 
            if(root.val > p.val) { // p在root的左子树
                successor = root;   //一直向左找，并用successor卡住root
                root = root.left; 
            } else {
                root = root.right;  //一直向右找
            }
        }
        
        if(root == null) {
            return null;
        }
        
        if(root.right == null) {
            return successor;
        }
        
        //从这里开始，适用于example的 p = 6，需要一直向左找找到 7 
        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        
        return root;
    }
}