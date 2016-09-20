Lintcode 011 - Search Range in Binary Search Tree.java

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
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
         ArrayList<Integer> result = new  ArrayList<Integer>();
         if(root == null) {
             return result;
         }
         
         helper(root, k1, k2, result);
         
         return result;
    }
    
    public void helper(TreeNode root, int k1, int k2, ArrayList<Integer> result) {
        if(root == null) {
            return;
        }
        
        helper(root.left, k1, k2, result);
        
        if(root.val >= k1 && root.val <= k2) {
            result.add(root.val);
        }
        
        helper(root.right, k1, k2, result);
        
    }
}



//不需要返回root，且完全可以通过语句排列来控制加入顺序，而不使用Collections.sort()
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        
        TreeNode dummy = mySearchRange(root, k1, k2, result);
        Collections.sort(result);
        return result;
    }
    
    public TreeNode mySearchRange(TreeNode root, int k1, int k2, ArrayList<Integer> result) {
        if(root == null) {
            return null;
        }
        if(root.val >= k1 && root.val <= k2) {
            result.add(root.val);
        }
        TreeNode left = mySearchRange(root.left, k1, k2, result);
        TreeNode right = mySearchRange(root.right, k1, k2, result);
        return root;
    }
}