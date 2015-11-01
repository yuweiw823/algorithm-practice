Leetcode 116&117 - Populating Next Right Pointers in Each Node - 树的其它.java

相当于层序遍历
第一层(主要操作层)，curHead, curManager来将下一层的node推入栈中
第二层，记录nextHead，同时在curManager的指挥下，使用p将各个node连接起来

public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        TreeLinkNode curHead = root;
        TreeLinkNode nextHead = null;
        TreeLinkNode p = null;
        
        while(curHead!=null){
            TreeLinkNode curManager = curHead;
            while(curManager != null){
                if(curManager.left!=null){
                    if(nextHead == null){
                        nextHead = curManager.left;
                        p = nextHead;
                    } else{
                        p.next = curManager.left;
                        p = p.next;
                    }
                }
                if(curManager.right!=null){
                    if(nextHead == null){
                        nextHead = curManager.right;
                        p = nextHead;
                    } else {
                        p.next = curManager.right;
                        p = p.next;
                    }
                }
                curManager = curManager.next;
            }
            curHead = nextHead;
            nextHead = null;   //这一步不能忘！
        }
    }
}