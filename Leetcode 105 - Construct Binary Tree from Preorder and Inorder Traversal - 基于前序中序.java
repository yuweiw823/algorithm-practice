//Leetcode 105 - Construct Binary Tree from Preorder and Inorder Traversal.java

// PreOrder: 12453687
// Inorder:   42516837
// Postorder: 45286731

//难点在于，怎样在仅有PreOrder和Inorder的顺序下，把树搭建起来
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) return null;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<inorder.length; i++){   //inorder的下标
            map.put(inorder[i], i);
        }
        return helper(map,   preorder, 0, preorder.length-1,   inorder, 0, inorder.length-1);
    }  
    public TreeNode helper(HashMap<Integer, Integer> map, int[] preorder, int preL, int preR, int[] inorder, int inL, int inR){
        if(preL > preR || inL > inR) return null;
        int index = map.get(preorder[preL]);  //3
        TreeNode root = new TreeNode(preorder[preL]);
        //preR = (index-inL)+preL  index-inL是半棵树的长度
        root.left  = helper(map, preorder, preL+1, (index-inL)+preL, inorder, inL, index-1);  
        root.right = helper(map, preorder, (index-inL+preL)+1, preR, inorder, index+1, inR);
        return root;
    }
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {x = val;}
    }
}