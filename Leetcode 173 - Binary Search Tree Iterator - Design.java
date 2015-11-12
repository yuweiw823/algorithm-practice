Leetcode 173 - Binary Search Tree Iterator - Design.java

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
    public BSTIterator(TreeNode root) {
        if(root != null){
            setNext(root);            
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if(stack.isEmpty()) return -1;
        TreeNode node = stack.pop();
        int val = node.val;
        setNext(node.right);
        return val;
    }
    
    public void setNext(TreeNode root) {
        while(root!= null){
            stack.push(root);
            root = root.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */