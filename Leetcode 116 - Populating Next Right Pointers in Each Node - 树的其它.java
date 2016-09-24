Leetcode 116 - Populating Next Right Pointers in Each Node - 树的其它.java

//http://www.cnblogs.com/yuzhangcmu/p/4041341.html
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

//Divide and Conquer
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null || root.left == null) {
            return;
        }
        
        root.left.next = root.right;
        root.right.next = root.next == null ? null : root.next.left;
        
        connect(root.left);
        connect(root.right);
        
    }
}

//链表法
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        
        TreeLinkNode theLeft = root;
        while(theLeft != null) {
            TreeLinkNode curr = theLeft;
            while(curr != null && curr.left != null) {
                curr.left.next = curr.right;
                curr.right.next = curr.next == null ? null : curr.next.left;
                
                curr = curr.next;
            }
            theLeft = theLeft.left;
        }
    }
}