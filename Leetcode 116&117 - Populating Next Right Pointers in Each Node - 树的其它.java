Leetcode 116&117 - Populating Next Right Pointers in Each Node - 树的其它.java

//方法1：BFS 层序遍历树
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        
        Queue<TreeLinkNode> Q = new LinkedList<TreeLinkNode>();
        
        Q.offer(root);
        while(!Q.isEmpty()) {
            int size = Q.size();
            for(int i = 0; i < size; i++) {
                TreeLinkNode curr = Q.poll();
                TreeLinkNode currNext = (i == size - 1) ? null : Q.peek();
                curr.next = currNext;
                
                if(curr.left != null) {
                    Q.offer(curr.left);
                }
                
                if(curr.right != null) {
                    Q.offer(curr.right);
                }
            }
        }
    }
}