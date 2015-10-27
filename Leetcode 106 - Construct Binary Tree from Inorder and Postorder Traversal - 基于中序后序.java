Leetcode 106 - Construct Binary Tree from Inorder and Postorder Traversal - 基于中序后序.java

// PreOrder: 12453687
// Inorder:    42516837
// Postorder: 45286731

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(map, postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
    }
    
    public TreeNode helper(HashMap<Integer, Integer> map, int[] postorder, int postL, int postR, int[] inorder, int inL, int inR){
        if(postL>postR || inL>inR) return null;
        TreeNode root = new TreeNode(postorder[postR]);
        int index = map.get(postorder[postR]);
        //postL = postR - (intR - index)  intR - index 是半棵树的长度
        root.left  = helper(map, postorder, postL, postR-(inR-index)-1, inorder, inL, index-1);
        root.right = helper(map, postorder, postR-(inR-index), postR-1, inorder, index+1, inR);
        return root;
    }

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {x = val;}
    }
}