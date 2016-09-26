Leetcode 103 - Binary Tree Zigzag Level Order Traversal - 树的层序遍历.java


//1. 图简便的奇数层reverse方法：
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
            return result;
        }
        
        LinkedList<TreeNode> Q = new LinkedList<TreeNode>();
        Q.offer(root);
        int level = 1;
        
        while(!Q.isEmpty()) {
            int size = Q.size();
            List<Integer> list = new ArrayList<Integer>();
            
            for(int i = 0; i < size; i++) {
                TreeNode curr = Q.poll();
                list.add(curr.val);
                if(curr.left != null) {
                    Q.offer(curr.left);    
                }
                if(curr.right != null) {
                    Q.offer(curr.right);
                }
            }
            if(level % 2 == 0) {
                Collections.reverse(list);
            }
            result.add(new ArrayList(list));
            level++;
        }
        return result;
    }
    
}

//双stack法
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
            return result;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> newStack = new  Stack<TreeNode>();
        stack.push(root);
        int level = 1;
        while(!stack.isEmpty()) {
            int size = stack.size();
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < size; i++) {
                TreeNode curr = stack.pop();
                list.add(curr.val);
                if(level % 2 == 0) {
                    if(curr.right != null) {
                        newStack.push(curr.right);
                    }
                    if(curr.left != null) {
                        newStack.push(curr.left);
                    }
                    
                } else {
                    if(curr.left != null) {
                        newStack.push(curr.left);
                    }
                    if(curr.right != null) {
                        newStack.push(curr.right);
                    }                    
                }
            }
            result.add(new ArrayList(list));
            stack = newStack;
            newStack = new Stack<TreeNode>(); // 注意要重新把newStack refer到一个新的空 stack！！！
            level++;
        }
        return result;
        
        
    }
}