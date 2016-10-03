//Leetcode 094 - Binary Tree Inorder Traversal - 中序遍历.java
//Given binary tree {1,#,2,3}, return [1,3,2]

//Recursive Method
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        
        DFS(root, result);
        return result;
    }
    
    public void DFS (TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }
        
        DFS(root.left, result);
        result.add(root.val);
        DFS(root.right, result);
    }
}

//Iterative Method
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null) return res;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        
        while(root!=null || !stack.isEmpty()){
            if(root!=null){
                stack.push(root);     //先不看root，而是把root记录下来，push到stack中
                root = root.left;     //Inorder的顺序：left root right
            } else {
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}