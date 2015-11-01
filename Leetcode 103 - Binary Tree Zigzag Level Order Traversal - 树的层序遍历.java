Leetcode 103 - Binary Tree Zigzag Level Order Traversal - 树的层序遍历.java

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>(); 
        List<Integer> level = new ArrayList<Integer>();
        stack.push(root);
        int levelNum = 1;
        int curNum = 1;
        int nextNum = 0;
        
        while(!stack.isEmpty()){
            LinkedList<TreeNode> nextStack = new LinkedList<TreeNode>(); 
            while(curNum > 0){
                TreeNode cur = stack.pop(); 
                level.add(cur.val);
                curNum--;
                if(levelNum % 2 == 1){//1,3,5
                    if(cur.left!=null){
                        nextStack.push(cur.left);
                        nextNum++;
                    }
                    if(cur.right!=null){
                        nextStack.push(cur.right);
                        nextNum++;
                    }
                } else{
                    if(cur.right!=null){
                        nextStack.push(cur.right);
                        nextNum++;
                    }
                    if(cur.left!=null){
                        nextStack.push(cur.left);
                        nextNum++;
                    }
                }
            }                    
            curNum = nextNum;
            nextNum = 0;
            levelNum++;
            stack = nextStack;
            res.add(level);
            level = new ArrayList<Integer>();
        }
        return res;
    }
}