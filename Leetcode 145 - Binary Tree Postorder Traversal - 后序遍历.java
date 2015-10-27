//Leetcode 145 - Binary Tree Postorder Traversal - 后序遍历.java

//Recursive Method
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null) return res;
        helper(res, root);
        return res;
    }
    
    public void helper(List<Integer> res, TreeNode root){
        if(root == null) return;
        helper(res, root.left);
        helper(res, root.right);
        res.add(root.val);
    }

    public class TreeNode{
    	int val;
    	TreeNode left;
    	TreeNode right;
    	TreeNode(int x){val = x;}
    }
}

//Iterative Method
// 1）如果栈顶元素的右结点存在&&还没访问过（也就是右结点不等于上一个访问结点）-- 当前结点移到右结点继续循环；
// 2）如果栈顶元素右结点是空||已经访问过，那么说明栈顶元素的左右子树都访问完毕 -- 应该访问自己继续回溯了。
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null) return res;
        
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode pre = null;
        
        while(root !=null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            } else {
                TreeNode peekNode = stack.peek();
                if(peekNode.right != null && peekNode.right != pre){
                    root = peekNode.right;
                } else {
                    stack.pop();
                    res.add(peekNode.val);
                    pre = peekNode;
                }
            }
        }
        return res;
    }
}

