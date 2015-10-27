//Leetcode 144 - Binary Tree Preorder Traversal - 前序遍历.java


//Recursive Method
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        helper(root, res);
        return res;
    }
    
    public void helper(TreeNode root, List<Integer> res){
        if(root==null) return;
        res.add(root.val);
        helper(root.left,  res);
        helper(root.right, res);
    }

    public class TreeNode{
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x){val = x;}
    }
}

//Iterative Method
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        
        while(root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                res.add(root.val);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
        return res;
    }
}